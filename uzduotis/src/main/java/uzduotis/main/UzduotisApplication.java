package uzduotis.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import uzduotis.controller.ConsumerController;

@SpringBootApplication
@ComponentScan("uzduotis")
public class UzduotisApplication {

	public static void main(String[] args) {
		SpringApplication.run(UzduotisApplication.class, args);
		System.out.println("Work?");
	}

}

