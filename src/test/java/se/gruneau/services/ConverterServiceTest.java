package se.gruneau.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.gruneau.utils.TemperatureConverter;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;

public class ConverterServiceTest {

    private final TemperatureConverter temperatureConverter = mock(TemperatureConverter.class);

    private final ConverterService service = new ConverterService(temperatureConverter);

    @Before
    public void setUp() throws Exception {
        when(temperatureConverter.toCelsius(anyDouble())).thenReturn(0.0);
    }

    @Test
    public void toCelsius() throws Exception {
        //Arrange
        List<Double> fahrenheit = new ArrayList<Double>();
        fahrenheit.add(32.0);
        fahrenheit.add(-0.5);
        fahrenheit.add(5.23);
        //Act
        List<Double> results = service.toCelsius(fahrenheit);
        //Assert
        verify(temperatureConverter, times(3)).toCelsius(anyDouble());
        Assert.assertTrue(results.size() == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toCelsiusEmptyArgs() throws Exception {
        //Arrange
        List<Double> fahrenheit = new ArrayList<Double>();
        //Act
        service.toCelsius(fahrenheit);
        //Assert
        verifyZeroInteractions(temperatureConverter);
    }

}