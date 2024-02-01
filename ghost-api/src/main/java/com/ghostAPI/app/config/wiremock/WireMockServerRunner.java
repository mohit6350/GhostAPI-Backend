package com.ghostAPI.app.config.wiremock;

import java.io.IOException;

public class WireMockServerRunner {

    public static void main(String[] args) {
        try {
            runExternalJar("wiremock/wiremock-standalone-3.3.1.jar");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runExternalJar(String jarPath) throws IOException, InterruptedException {
        // Construct the command line with "java -jar" and the JAR path
        String[] command = {"java", "-jar", jarPath};

        ProcessBuilder processBuilder = new ProcessBuilder(command);

        // Redirecting error stream to standard output
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        // Wait for the process to finish
        int exitCode = process.waitFor();

        System.out.println("External JAR process exited with code: " + exitCode);
    }
}
