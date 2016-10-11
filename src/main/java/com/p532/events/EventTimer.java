package com.p532.events;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.p532.model.Sprite;

public class EventTimer implements EventObservable {
	private static EventTimer eventTimer;

	public static EventTimer getInstance() {
		if (eventTimer == null) {
			eventTimer = new EventTimer();
		}
		return eventTimer;
	}

	private Logger log = Logger.getLogger(EventTimer.class);

	private ArrayList<Sprite> observers = new ArrayList<Sprite>();
	// To store the event index that is being passed
	private ArrayList<Integer> observerEventIndex = new ArrayList<>();

	private EventTimer() {

	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			// log.info("Entered notify observers Timer");
			observers.get(i).eventOccured(observers.get(i), 1, observerEventIndex.get(i));
		}
	}

	@Override
	public void registerObserver(Sprite observer, int eventIndex) {
		observers.add(observer);
		observerEventIndex.add(eventIndex);
	}

}
