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
