package org.guardiandev.helloservice;

import org.guardiandev.helloservice.config.TestPropertiesContainer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloWorldIntegrationTest {

    private final TestPropertiesContainer properties = new TestPropertiesContainer();

    @Test
    public void shouldReturnHelloWorld() {
        // Arrange

        // Act
        var result = makeGetRequest(properties.getValue("hello.endpoint"));

        // Assert
        assertTrue(result.contains("Hello World!"));
    }

    private String makeGetRequest(String uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        try {
            return client
                    .send(request, HttpResponse.BodyHandlers.ofString())
                    .body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
