package com.rodrigodev.xgen.test.common.doubles.service.time;

import com.rodrigodev.xgen.service.time.TimeService;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Created by Rodrigo Quesada on 03/04/15.
 */
public class FakeTimeService extends TimeService {

    private static final LocalDateTime START_TIME = LocalDateTime.of(0, 1, 1, 0, 0);
    private static final int RANDOM_BOUND = 1_000;

    private Random random;
    private LocalDateTime currentDateTime;
    private FakeTimeServiceState state;

    public FakeTimeService() {
        reset();
    }

    public void reset() {
        random = new Random(0);
        currentDateTime = START_TIME;
        state = new NormalState();
    }

    @Override
    public LocalDateTime now() {
        currentDateTime = state.nextDateTime();
        return currentDateTime;
    }

    public void setTime(@NonNull LocalDateTime dateTime) {
        currentDateTime = dateTime;
    }

    public void setupBackwards() {
        state = new BackwardsState();
    }

    public void setupConstant() {
        state = new ConstantState();
    }

    private interface FakeTimeServiceState {

        LocalDateTime nextDateTime();
    }

    private class NormalState implements FakeTimeServiceState {

        @Override
        public LocalDateTime nextDateTime() {
            return currentDateTime.plusSeconds(random.nextInt(RANDOM_BOUND) + 1);
        }
    }

    private class BackwardsState implements FakeTimeServiceState {

        @Override
        public LocalDateTime nextDateTime() {
            return currentDateTime.minusSeconds(random.nextInt(RANDOM_BOUND) + 1);
        }
    }

    private class ConstantState implements FakeTimeServiceState {

        @Override
        public LocalDateTime nextDateTime() {
            return currentDateTime;
        }
    }
}
