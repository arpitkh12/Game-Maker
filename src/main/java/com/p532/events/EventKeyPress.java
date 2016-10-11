package com.p532.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import com.p532.model.Sprite;

public class EventKeyPress implements EventObservable, KeyListener {
	private static EventKeyPress eventKeyPress;

	public static EventKeyPress getInstance() {
		if (eventKeyPress == null) {
			eventKeyPress = new EventKeyPress();
		}
		return eventKeyPress;
	}

	private KeyEvent keyEvent;

	private ArrayList<Sprite> observers = new ArrayList<Sprite>();
	// To store the event index that is being passed
	private ArrayList<Integer> observerEventIndex = new ArrayList<>();

	private EventKeyPress() {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.keyEvent = e;
		notifyObservers();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Do Nothing
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).eventOccured(observers.get(i), keyEvent, observerEventIndex.get(i));
		}
	}

	@Override
	public void registerObserver(Sprite observer, int eventIndex) {
		observers.add(observer);
		observerEventIndex.add(eventIndex);
	}

}
