package com.p532.events;

import com.p532.model.Sprite;

public interface EventObserver<T> {
	public void eventOccured(Sprite observer, T t, int eventIndex);

}
