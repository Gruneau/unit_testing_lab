package se.gruneau;

import se.gruneau.services.ConverterService;
import se.gruneau.utils.TemperatureConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{

    private static final ConverterService converterService =
            new ConverterService(new TemperatureConverter());

    public static void main( String[] args )
    {
        List<Double> input = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            try {
                Double d = Double.parseDouble(args[i]);
                input.add(d);
            } catch (Exception e) {
                e.printStackTrace();
                //ignore bad input
            }
        }
        System.out.println( "CONVERTING");
        System.out.println(input);
        List<Double> results = converterService.toCelsius(input);
        System.out.println(results);

    }
}


//Story: Convert fahrenheit to celsius

//    As an cosmonaut
//    In order to keep track of my body temperature
//    I want to be able to read my spacesuits temperature in celsius
//
//        Scenario 1: Temperatures should be displayed in celsius
//        Given that I have a list of three temperatures in fahrenheit
//        When I run the app with that list of arguments
//        Then I should get back three temperatures converted to celsius in the same order
//
//        Scenario 2: Empty input
//        Given that I run the converter app with an empty list/no arguments
//        When I run the app
//        Then I should get an IllegalArgumentException.
