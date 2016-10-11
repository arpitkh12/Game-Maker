package com.p532.timer;

import static com.p532.constants.Constants.DELAY;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class ObservableTimer implements Observable {

	private ActionListener action;
	private int counter = 0;
	private int delay = DELAY;
	private ArrayList<Observer> observers;
	private Timer time;

	public ObservableTimer() {
		observers = new ArrayList<Observer>();
		action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (counter < 0) {
					time.stop();
				} else {
					counter += 1;
					setCounter(counter);
				}

			}
		};
	}

	public void stopTimer() {
		time.stop();
	}

	public int getCounter() {
		return counter;
	}

	public List<Observer> getObservers() {
		return observers;
	}

	@Override
	public void notifyObservers() {
		for (Observer ob : observers) {
			ob.update(this.counter);
		}
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void setCounter(int counter) {
		this.counter = counter;
		notifyObservers();
	}

	public void startTimer() {
		time = new Timer(delay, action);
		time.setInitialDelay(0);
		time.start();
	}
}