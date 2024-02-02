package com.ghostAPI.app.config.wiremock;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class WireMockServerRunner {

    public static void startWireMock() {
        try {
            ClassLoader classLoader = WireMockServerRunner.class.getClassLoader();
            URL resourceUrl = classLoader.getResource("wiremock/wiremock.jar");

            if (resourceUrl == null) {
                System.err.println("WireMock JAR file not found in resources.");
                return;
            }

            File jarFile = Paths.get(resourceUrl.toURI()).toFile();
            String jarFilePath = jarFile.getAbsolutePath();

            ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "wiremock.jar");
            processBuilder.directory(jarFile.getParentFile());
            processBuilder.inheritIO();

            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            System.out.println("WireMock process exited with code: " + exitCode);
        } catch (IOException | InterruptedException | NullPointerException | java.net.URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
