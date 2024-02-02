// GhostApiApplication.java

package com.ghostAPI.app;

import com.ghostAPI.app.config.wiremock.WireMockServerRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class GhostApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GhostApiApplication.class, args);

		// Start WireMock server
		WireMockServerRunner.startWireMock();

		// Gracefully handle shutdown
		context.getBean(ThreadPoolTaskExecutor.class).execute(() -> {
			try {
				Thread.sleep(10000); // Wait for 10 seconds
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			context.close(); // Close Spring Boot application
			WireMockServerRunner.stopWireMock(); // Stop WireMock
			System.out.println("Application and WireMock server stopped gracefully.");
			System.exit(0);
		});
	}

	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(1);
		executor.setQueueCapacity(1);
		executor.initialize();
		return executor;
	}
}
