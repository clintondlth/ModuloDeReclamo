package com.bbva.reclamo_servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ReclamoServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamoServicioApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Component
	public static class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

		@Override
		public void onApplicationEvent(ApplicationReadyEvent event) {
			int port = event.getApplicationContext().getEnvironment().getProperty("server.port", Integer.class);
			System.out.println("El microservicio se ha ejecutado correctamente en el puerto: " + port);
		}

	}
}
