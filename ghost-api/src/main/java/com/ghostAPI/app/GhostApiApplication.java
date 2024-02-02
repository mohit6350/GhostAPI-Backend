package com.ghostAPI.app;

import com.ghostAPI.app.config.wiremock.WireMockServerRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GhostApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(GhostApiApplication.class, args);
		WireMockServerRunner.startWireMock();

	}

}
