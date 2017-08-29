package se.gruneau.services;

import se.gruneau.enums.UnitType;
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

    public <T> List<T> convert(List<T> any, UnitType type) {
        switch (type) {
            case CELSIUS:
                return (List<T>) convertToCelsius((List<Double>) any);
            case FAHRENHEIT:
                break;
            case FEET:
                break;
            case METER:
                break;
        }
        return null;
    }

    /**
     * Takes a list of temperatures in fahrenheit and outputs a list in the same order
     * with the temperatures converted to celsius.
     * @param listOfFahrenheitTemps list of temperatures in fahrenheit.
     * @return temperature list in celsius.
     */

    protected List<Double> convertToCelsius(List<Double> listOfFahrenheitTemps) {
        return listOfFahrenheitTemps.stream()
                .map(temperatureUtil::toCelsius)
                .collect(Collectors.toList());
    }

}
