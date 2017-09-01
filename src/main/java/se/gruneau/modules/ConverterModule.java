package se.gruneau.modules;


import com.google.inject.AbstractModule;
import se.gruneau.interfaces.ConverterService;
import se.gruneau.services.Converter;

public class ConverterModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ConverterService.class).to(Converter.class);
    }
}
