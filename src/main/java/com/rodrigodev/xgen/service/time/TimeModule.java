package com.rodrigodev.xgen.service.time;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 27/06/15.
 */
@Module
public class TimeModule {

    @Provides
    @Singleton
    public TimeService provideTimeService() {
        return new TimeService();
    }
}
