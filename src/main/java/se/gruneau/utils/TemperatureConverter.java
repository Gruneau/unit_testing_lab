package se.gruneau.utils;

public class TemperatureConverter {

    /**
     * Converts the input value from fahrenheit to celsius
     * according to the conversion function T(°C) = (T(°F) - 32) / 1.8
     * @param fahrenheit
     * @return
     */

    public Double toCelsius(Double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }

}
