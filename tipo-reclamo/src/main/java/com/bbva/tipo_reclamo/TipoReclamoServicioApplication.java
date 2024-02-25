package com.bbva.tipo_reclamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@EnableDiscoveryClient
@SpringBootApplication
public class TipoReclamoServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(TipoReclamoServicioApplication.class, args);
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
