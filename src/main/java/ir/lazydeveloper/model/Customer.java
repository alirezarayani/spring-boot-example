package ir.lazydeveloper.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Entity
@Table
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_id_sequence")
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Integer age;
}
