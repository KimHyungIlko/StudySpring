package com.example.dns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DnsApplication {

	@RestController
	class HelloController {

		@GetMapping("/")
		public String hello() {
			return "hello long time no see";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DnsApplication.class, args);
	}

}
