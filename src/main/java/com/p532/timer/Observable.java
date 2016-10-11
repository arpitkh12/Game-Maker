package com.p532.timer;

public interface Observable {
	public void notifyObservers();

	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);
}