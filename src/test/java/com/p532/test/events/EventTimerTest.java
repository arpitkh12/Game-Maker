package com.p532.test.events;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import com.p532.events.EventTimer;
import com.p532.model.Sprite;

public class EventTimerTest {

	@Test
	public void test() {
		ArrayList<Integer> eventList = new ArrayList<>();
		ArrayList<ArrayList<Integer>> actionList = new ArrayList<>();
		Sprite newSprite = new Sprite("BALL", eventList, actionList, 0);
		EventTimer eventTimer = EventTimer.getInstance();
		eventTimer.registerObserver(newSprite,1);
		assertNotNull(eventTimer);

	}

}
