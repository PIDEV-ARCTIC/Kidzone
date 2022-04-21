package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PidevKidZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PidevKidZoneApplication.class, args);
			
		}


}
