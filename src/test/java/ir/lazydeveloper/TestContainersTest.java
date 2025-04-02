package ir.lazydeveloper;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public class TestContainersTest {

    @Container
    private static final PostgreSQLContainer<?> postgresSQLContainer =
            new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("amigoscode")
                    .withUsername("amigoscode")
                    .withPassword("password");

    @Test
    public void canStartPostgresDB() {
        Assertions.assertThat(postgresSQLContainer.isRunning()).isTrue();
        Assertions.assertThat(postgresSQLContainer.isCreated()).isTrue();
    }
}
