package com.p532.test.timer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.p532.timer.ObservableTimer;

public class ObservableTimerTest {

	@Test
	public void test() {
		ObservableTimer observableTimer = new ObservableTimer();
		assertNotNull(observableTimer);
		observableTimer.setCounter(0);
		assertEquals(0, observableTimer.getCounter());
	}

}
