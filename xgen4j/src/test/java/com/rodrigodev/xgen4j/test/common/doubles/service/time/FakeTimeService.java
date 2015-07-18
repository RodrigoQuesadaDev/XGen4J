/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Rodrigo Quesada <rodrigoquesada.dev@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.rodrigodev.xgen4j.test.common.doubles.service.time;

import com.rodrigodev.xgen4j.service.time.TimeService;
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
