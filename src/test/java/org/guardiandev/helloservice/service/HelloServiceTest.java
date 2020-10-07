package org.guardiandev.helloservice.service;

import org.guardiandev.helloservice.models.Hello;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloServiceTest {

    private final HelloService unitUnderTest = new HelloService();

    @Test
    public void shouldReturnHelloWorldText() {
        // Arrange
        Hello expectedResult = new Hello().text("Hello World!");

        // Act
        Hello result = unitUnderTest.getHello();

        // Assert
        assertEquals(result, expectedResult);
    }
}