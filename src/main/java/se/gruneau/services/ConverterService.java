package se.gruneau.services;

import se.gruneau.utils.TemperatureConverter;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterService {

    private final TemperatureConverter temperatureConverter;

    public ConverterService(TemperatureConverter temperatureConverter) {
        this.temperatureConverter = temperatureConverter;
    }

    public List<Double> toCelsius(List<Double> listOfFahrenheit) {
        if (null == listOfFahrenheit || listOfFahrenheit.isEmpty()) {
            throw new IllegalArgumentException("List of input can not be empty");
        }
        return listOfFahrenheit.stream()
                .map(temperatureConverter::toCelsius).collect(Collectors.toList());
    }

}
