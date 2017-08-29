package se.gruneau.services;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import se.gruneau.utils.TemperatureUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
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

        //Hint: At this point we can mock up the temperature util completely! (We already covered it in its own test class.)
        //In larger and more complex projects, this can turn an insanely huge test redundant - stick to small and meaningful tests,
        //Large complex overlapping tests are slower and also harder to understand and maintain.
        //Try to mock away everything that is not relevant for the test.
        when(temperatureUtil.toCelsius(any(Double.class))).thenReturn(any(Double.class));

        //Act
        List<Double> results = converterService.convertToCelsius(fahrenheit);

        //Assert
        assertEquals(3, results.size());
    }

    @Test
    public void testConvertToCelsiusControlArgs() throws Exception {

        //Arrange
        List<Double> fahrenheit = new ArrayList<>();
        fahrenheit.add(12.0);
        fahrenheit.add(-25.12);
        fahrenheit.add(0.0);

        //The captor is capturing all values that are sent in, here we don't test the converter
        //but actually check that the arguments passed in are passed in the same order and are equal values.
        ArgumentCaptor<Double> captor = ArgumentCaptor.forClass(Double.class);
        when(temperatureUtil.toCelsius(captor.capture())).thenReturn(any(Double.class));

        //Act
        converterService.convertToCelsius(fahrenheit);

        //Assert
        assertEquals(12.0, captor.getAllValues().get(0), 0);
        assertEquals(-25.12, captor.getAllValues().get(1), 0);
        assertEquals(0.0, captor.getAllValues().get(2), 0);
    }

}