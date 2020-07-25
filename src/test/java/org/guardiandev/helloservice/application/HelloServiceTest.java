package org.guardiandev.helloservice.application;

import org.guardiandev.helloservice.models.Hello;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {

    private final HelloService unitUnderTest = new HelloService();

    @Test
    public void shouldReturnHelloWorld() {
        // Arrange
        Hello expectedResult = new Hello().text("Hello World!");

        // Act
        Hello result = unitUnderTest.getHello();

        // Assert
        assertThat(result).isEqualToComparingFieldByField(expectedResult);
    }
}