// WireMockServerRunner.java

package com.ghostAPI.app.config.wiremock;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class WireMockServerRunner {

    private static volatile boolean stopRequested = false;

    public static void startWireMock() {
        Thread wireMockThread = new Thread(() -> {
            try {
                // Locate WireMock JAR file
                URL resourceUrl = WireMockServerRunner.class.getClassLoader().getResource("wiremock/wiremock.jar");
                if (resourceUrl == null) {
                    System.err.println("WireMock JAR file not found in resources.");
                    return;
                }

                // Prepare JAR file path
                File jarFile = Paths.get(resourceUrl.toURI()).toFile();
                String jarFilePath = jarFile.getAbsolutePath();

                // Build and start WireMock process
                ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "wiremock.jar");
                processBuilder.directory(jarFile.getParentFile());
                processBuilder.inheritIO();
                Process process = processBuilder.start();

                // Wait for WireMock process to exit
                int exitCode = process.waitFor();
                System.out.println("WireMock process exited with code: " + exitCode);

            } catch (IOException | InterruptedException | java.net.URISyntaxException e) {
                handleException(e);
            }
        });

        // Start WireMock thread
        wireMockThread.start();

        // Gracefully handle interruption
        handleInterruption(wireMockThread);
    }

    public static void stopWireMock() {
        stopRequested = true;
        System.out.println("WireMock server stopped.");
    }

    private static void handleException(Exception e) {
        // Log or handle the exception according to your application's logging strategy
        e.printStackTrace();
    }

    private static void handleInterruption(Thread thread) {
        if (Thread.interrupted() || stopRequested) {
            System.out.println("Thread interrupted or stop requested. Exiting gracefully.");
            thread.interrupt(); // Re-interrupt the thread
            return;
        }
    }
}
