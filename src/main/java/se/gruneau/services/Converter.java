package se.gruneau.services;

import com.google.inject.Inject;
import se.gruneau.interfaces.ConverterService;
import se.gruneau.utils.TemperatureConverter;

import java.util.List;
import java.util.stream.Collectors;

public class Converter implements ConverterService {

    private final TemperatureConverter temperatureConverter;

    @Inject
    Converter(TemperatureConverter temperatureConverter) {
        this.temperatureConverter = temperatureConverter;
    }

    @Override
    public List<Double> toCelsius(List<Double> listOfFahrenheit) {
        if (null == listOfFahrenheit || listOfFahrenheit.isEmpty()) {
            throw new IllegalArgumentException("List of input can not be empty");
        }
        return listOfFahrenheit.stream()
                .map(temperatureConverter::toCelsius).collect(Collectors.toList());
    }

    @Override
    public List<Double> toDouble(List<String> listOfStrings) {
        if (null == listOfStrings || listOfStrings.isEmpty()) {
            throw new IllegalArgumentException("List of input can not be empty");
        }
        return listOfStrings.stream()
                .map(Double::parseDouble).collect(Collectors.toList());
    }

}
