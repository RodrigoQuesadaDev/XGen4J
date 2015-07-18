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

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 04/04/15.
 */
public class FakeTimeServiceTest {

    private FakeTimeService fakeTimeService;

    @Before
    public void setup(){
        fakeTimeService = new FakeTimeService();
    }

    @Test
    public void new_timeIsReturnedNormally() {
        fakeTimeService = new FakeTimeService();

        assertThat(fakeTimeService.now().isBefore(fakeTimeService.now())).isTrue();
    }

    @Test
    public void setTime_aDateTimeIsPassed_theDateTimeIsUsedToGenerateSuccessiveTimes(){
        LocalDateTime expectedDateTime = LocalDateTime.of(1234, 3, 7, 11, 13, 17, 19);
        fakeTimeService.setupConstant();

        fakeTimeService.setTime(expectedDateTime);

        assertThat(fakeTimeService.now()).isEqualTo(expectedDateTime);
    }

    @Test
    public void setupBackwards_methodIsCalled_timeIsReturnedBackwards() {
        fakeTimeService.setupBackwards();

        assertThat(fakeTimeService.now().isAfter(fakeTimeService.now())).isTrue();
    }

    @Test
    public void setupConstant_methodIsCalled_sameTimeIsAlwaysReturned() {
        fakeTimeService.setupConstant();

        assertThat(fakeTimeService.now().isEqual(fakeTimeService.now())).isTrue();
    }

    @Test
    public void reset_methodIsCalled_theStateIsReset() {
        LocalDateTime initialDateTime = fakeTimeService.now();
        fakeTimeService.setupBackwards();

        fakeTimeService.reset();

        assertThat(fakeTimeService.now()).isEqualTo(initialDateTime);
        assertThat(fakeTimeService.now().isBefore(fakeTimeService.now())).isTrue();
    }
}
