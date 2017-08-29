package se.gruneau.services;

import se.gruneau.utils.TemperatureUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gruneau on 2017-08-29.
 */
public class ConverterService {

    private final TemperatureUtil temperatureUtil;

    public ConverterService(TemperatureUtil temperatureUtil) {
        this.temperatureUtil = temperatureUtil;
    }

    /**
     * Takes a list of temperatures in fahrenheit and outputs a list in the same order
     * with the temperatures converted to celsius.
     * @param listOfFahrenheitTemps list of temperatures in fahrenheit.
     * @return temperature list in celsius.
     */

    public List<Double> convertToFahrenheit(List<Double> listOfFahrenheitTemps) {
        return listOfFahrenheitTemps.stream()
                .map(temperatureUtil::toCelsius)
                .collect(Collectors.toList());
    }

}
