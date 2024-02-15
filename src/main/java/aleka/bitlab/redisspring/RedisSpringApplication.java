package aleka.bitlab.redisspring;

import jakarta.servlet.http.HttpSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RedisSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisSpringApplication.class, args);
	}
}
