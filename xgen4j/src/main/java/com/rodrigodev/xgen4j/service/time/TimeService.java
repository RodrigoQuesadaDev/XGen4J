package com.rodrigodev.xgen4j.service.time;

import javax.inject.Singleton;
import java.time.LocalDateTime;

/**
 * Created by Rodrigo Quesada on 27/06/15.
 */
@Singleton
public class TimeService {

    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
