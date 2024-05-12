package ir.lazydeveloper.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Entity
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(
                name = "customer_email_unique",
                columnNames = "email"
        )})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_id_seq",
            sequenceName = "customer_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer age;

    public Customer(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
