package com.p532.events;

import com.p532.model.Sprite;

public interface EventObservable {
	public void notifyObservers();

	public void registerObserver(Sprite observer, int eventIndex);
}
