package bookclub.bookclubspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class BookclubSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookclubSpringApplication.class, args);
	}

}
