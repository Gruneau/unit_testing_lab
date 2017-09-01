package se.gruneau.interfaces;

import java.util.List;

/**
 * Created by gruneau on 2017-09-01.
 */
public interface ConverterService {

    /**
     * Attempts to covert the input fahrenheit list to celsius.
     *
     * @return a list of the converted numbers.
     */

    List<Double> toCelsius(List<Double> listOfFahrenheit);

    List<Double> toDouble(List<String> listOfStrings);

}
