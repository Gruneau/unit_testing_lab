package se.gruneau.utils;

import org.junit.Assert;
import org.junit.Test;

public class TemperatureConverterTest {

    private final TemperatureConverter converter = new TemperatureConverter();

    @Test
    public void fahrenheitToCelsius() throws Exception {
        //Arrange
        final Double fahrenheit = 50.0;
        final Double expected = 10.0;
        //Act
        final Double result = converter.toCelsius(fahrenheit);
        //Assert
        Assert.assertEquals(expected, result);
    }

}