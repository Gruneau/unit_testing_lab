package se.gruneau;

import com.google.inject.Guice;
import com.google.inject.Injector;
import se.gruneau.interfaces.ConverterService;
import se.gruneau.modules.ConverterModule;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{

    public static void main( String[] args )
    {
        //Config guice
        Injector injector = Guice.createInjector(new ConverterModule());
        ConverterService service = injector.getInstance(ConverterService.class);
        //Input
        System.out.println( "CONVERTING");
        List<Double> parsedInput = service.toDouble(Arrays.asList(args));
        System.out.println(parsedInput);
        List<Double> results = service.toCelsius(parsedInput);
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
