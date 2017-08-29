package se.gruneau;

import se.gruneau.services.ConverterService;
import se.gruneau.utils.TemperatureUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    private static final ConverterService converterService = new ConverterService(new TemperatureUtil());

    public static void main( String[] args ) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No args provided! Terminating.");
        }
        System.out.println("Converting args to celsius!");
        final List<Double> fahrenheitList = Arrays.stream(args).map(Double::valueOf).collect(Collectors.toCollection(ArrayList::new));
        final List<Double> celsiusResult = converterService.convertToCelsius(fahrenheitList);
        System.out.println("Input:");
        System.out.println(fahrenheitList);
        System.out.println("Result:");
        System.out.println(celsiusResult);
    }
}
