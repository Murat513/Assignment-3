package kz.aitu.oop.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "kz.aitu.oop.restservice")
@EntityScan(basePackages = "kz.aitu.oop.restservice.entities")
public class RestserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
	}
}
