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

        //Hint: At this point we can mock up the temperature util completely! (We already covered it in its own test class.)
        //In larger and more complex projects, this can turn an insanely huge test redundant - stick to small and meaningful tests,
        //Large complex overlapping tests are slower and also harder to understand and maintain.
        //Try to mock away everything that is not relevant for the test.
        when(temperatureUtil.toCelsius(any(Double.class))).thenReturn(any(Double.class));

        //Act
        List<Double> results = converterService.convertToCelsius(fahrenheit);

        //Assert
        Assert.assertEquals(3, results.size());
    }

}