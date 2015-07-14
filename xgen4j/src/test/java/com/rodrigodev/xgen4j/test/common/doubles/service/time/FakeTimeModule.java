package com.rodrigodev.xgen4j.test.common.doubles.service.time;

import com.rodrigodev.xgen4j.service.time.TimeModule;
import com.rodrigodev.xgen4j.service.time.TimeService;

/**
 * Created by Rodrigo Quesada on 28/06/15.
 */
public class FakeTimeModule extends TimeModule {

    @Override
    public TimeService provideTimeService() {
        return new FakeTimeService();
    }
}
