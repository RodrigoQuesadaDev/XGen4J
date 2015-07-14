package com.rodrigodev.xgen.test.common.doubles.service.time;

import com.rodrigodev.xgen.service.time.TimeModule;
import com.rodrigodev.xgen.service.time.TimeService;

/**
 * Created by Rodrigo Quesada on 28/06/15.
 */
public class FakeTimeModule extends TimeModule {

    @Override
    public TimeService provideTimeService() {
        return new FakeTimeService();
    }
}
