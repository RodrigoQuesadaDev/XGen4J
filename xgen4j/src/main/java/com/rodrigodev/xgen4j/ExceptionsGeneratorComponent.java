package com.rodrigodev.xgen4j;

import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 27/06/15.
 */
@Singleton
@Component(modules = {MainModule.class})
public interface ExceptionsGeneratorComponent {

    void inject(ExceptionsGenerator generator);

    ExceptionsGenerator generator();
}