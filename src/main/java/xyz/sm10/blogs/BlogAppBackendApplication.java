package xyz.sm10.blogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BlogAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppBackendApplication.class, args);
	}
    @GetMapping("/")
    public String home() {
        return "welcome to blog app backend";
    }
}
