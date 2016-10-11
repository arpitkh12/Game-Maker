package com.p532.events;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.p532.model.Sprite;

public class EventCollision implements EventObservable {
	private static EventCollision eventCollision;

	public static EventCollision getInstance() {
		if (eventCollision == null) {
			eventCollision = new EventCollision();
		}
		return eventCollision;
	}

	private Logger log = Logger.getLogger(EventCollision.class);

	private ArrayList<Sprite> observers = new ArrayList<Sprite>();
	// To store the event index that is being passed
	private ArrayList<Integer> observerEventIndex = new ArrayList<>();

	private EventCollision() {
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			// log.info("Entered notify observers Collision");
			observers.get(i).eventOccured(observers.get(i), true, observerEventIndex.get(i));
		}
	}

	@Override
	public void registerObserver(Sprite observer, int eventIndex) {
		observers.add(observer);
		observerEventIndex.add(eventIndex);
	}

}
