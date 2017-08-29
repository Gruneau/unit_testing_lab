package se.gruneau.services;

import org.junit.Assert;
import org.junit.Test;
import se.gruneau.utils.TemperatureUtil;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gruneau on 2017-08-29.
 */
public class ConverterServiceTest {

    private final TemperatureUtil temperatureUtil = mock(TemperatureUtil.class);

    private final ConverterService converterService = new ConverterService(temperatureUtil);

    @Test
    public void testConvertToCelsius() throws Exception {

        //Arrange
        List<Double> fahrenheit = new ArrayList<>();
        fahrenheit.add(12.0);
        fahrenheit.add(-25.12);
        fahrenheit.add(0.0);
        when(temperatureUtil.toCelsius(any(Double.class))).thenReturn(12.0);

        //Act
        List<Double> results = converterService.convertToCelsius(fahrenheit);

        //Assert
        Assert.assertEquals(3, results.size());
    }

}