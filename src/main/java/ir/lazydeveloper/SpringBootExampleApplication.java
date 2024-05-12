package ir.lazydeveloper;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import ir.lazydeveloper.dao.CustomerRepository;
import ir.lazydeveloper.model.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootExampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootExampleApplication.class, args);
//        // printBean(context);
    }

    @Bean
    public CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            Faker faker = new Faker();
            Name name = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();
            Customer customer = new Customer(
                    "%s %s".formatted(firstName,lastName),
                    "%s.%s%s".formatted(firstName, lastName, "@gamil.com"),
                    faker.number().numberBetween(18, 99)
            );
            customerRepository.save(customer);
        };
    }

    //    public static void printBean(String... args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootExampleApplication.class, args);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String beanName : beanDefinitionNames) {
//            System.out.println(beanName);
//        }
//    }

//    @Bean
//    public static String[] printBean(ConfigurableApplicationContext ctx) {
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        for (String beanName : beanDefinitionNames) {
//            System.out.println(beanName);
//        }
//        return beanDefinitionNames;
//    }


}
