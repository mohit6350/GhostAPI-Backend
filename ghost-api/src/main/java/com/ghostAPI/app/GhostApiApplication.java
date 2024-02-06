// GhostApiApplication.java

package com.ghostAPI.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class GhostApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GhostApiApplication.class, args);

	}




}
