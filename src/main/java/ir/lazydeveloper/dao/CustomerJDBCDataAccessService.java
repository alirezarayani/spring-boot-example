package ir.lazydeveloper.dao;

import ir.lazydeveloper.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class CustomerJDBCDataAccessService implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    @Autowired
    public CustomerJDBCDataAccessService(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        var sql = """
                SELECT id ,name, email,age FROM customer;
                """;
        //First approach
        //Row Mapper allows us to transform data that we get back from our table into a java object
//        RowMapper<Customer> customerRowMapper = (rs, rowNum) ->
//            new Customer(
//                    rs.getLong("id"),
//                    rs.getString("name"),
//                    rs.getString("email"),
//                    rs.getInt("age"));
        return jdbcTemplate.query(sql, customerRowMapper);
    }

    @Override
    public Optional<Customer> selectCustomerByIs(Integer id) {
        var sql = """
                SELECT id, name, email, age FROM customer WHERE id = ?
                """;
        return jdbcTemplate
                .query(sql, customerRowMapper, id)
                .stream()
                .findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        var sql = """
                INSERT INTO customer (name,email,age) values (?,?,?);
                """;
        jdbcTemplate.update(
                sql,
                customer.getName(),
                customer.getEmail(),
                customer.getAge()
        );
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        var sql = """
                SELECT
                count(id)
                FROM customer
                WHERE email = ?
                 """;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count != null && count > 0;
    }

    @Override
    public boolean existPersonWithId(Integer customerId) {
        var sql = """
                SELECT
                count(id)
                FROM customer
                WHERE id = ?
                 """;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, customerId);
        return count != null && count > 0;
    }

    @Override
    public void deleteCustomerById(Integer customerId) {
        var sql = """
                DELETE FROM customer WHERE id = ?
                """;
        jdbcTemplate.update(sql, customerId);
    }

    @Override
    public void updateCustomer(Customer update) {
        if (update.getName() != null) {
            var sql = """
                    UPDATE customer set name = ?  WHERE id = ?
                    """;
            int result = jdbcTemplate.update(
                    sql,
                    update.getName(),
                    update.getId()
            );
        }
        if (update.getAge() != null) {
            var sql = """
                    UPDATE customer set age = ? WHERE id = ?
                    """;
            int result = jdbcTemplate.update(
                    sql,
                    update.getAge(),
                    update.getId()
            );
        }
        if (update.getAge() != null) {
            var sql = """
                    UPDATE customer set email = ? WHERE id = ?
                    """;
            int result = jdbcTemplate.update(
                    sql,
                    update.getEmail(),
                    update.getId()
            );
        }
    }
}
