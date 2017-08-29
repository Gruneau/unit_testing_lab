package se.gruneau.utils;

/**
 * Created by gruneau on 2017-08-29.
 */
public class TemperatureUtil {

    /**
     * Takes the temperature in fahrenheit as input and converts it to celsius
     * according to the conversion formula: T(°C) = (T(°F) - 32) / 1.8
     *
     * @param fahrenheit double
     * @return
     */

    public Double toCelsius(Double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }

}
