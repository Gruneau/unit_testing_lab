package se.gruneau.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gruneau on 2017-08-29.
 */
public class TemperatureUtilTest {

    private final TemperatureUtil temperatureUtil = new TemperatureUtil();

    @Test
    public void testToCelsius() throws Exception {
        final Double fahrenheit = 32.0;
        final Double result = temperatureUtil.toCelsius(fahrenheit);
        assertEquals(0.0, result, 0);
    }

    @Test
    public void testToCelsius2() throws Exception {
        final Double fahrenheit = -18.23;
        final Double result = temperatureUtil.toCelsius(fahrenheit);
        assertEquals(-27.90555555555556, result, 0);
    }

}