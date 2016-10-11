package com.p532.events;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import com.p532.model.Sprite;

public class EventMouseClick extends MouseAdapter implements EventObservable, MouseListener {
	private static EventMouseClick eventMouseClick;

	public static EventMouseClick getInstance() {
		if (eventMouseClick == null) {
			eventMouseClick = new EventMouseClick();
		}
		return eventMouseClick;
	}

	private MouseEvent mouseEvent;
	private ArrayList<Sprite> observers = new ArrayList<Sprite>();
	private ArrayList<Integer> observerEventIndex = new ArrayList<>();

	@Override
	public void mousePressed(MouseEvent e) {
		this.mouseEvent = e;
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).eventOccured(observers.get(i), mouseEvent, observerEventIndex.get(i));
		}
	}

	@Override
	public void registerObserver(Sprite observer, int eventIndex) {
		observers.add(observer);
		observerEventIndex.add(eventIndex);
	}

}
