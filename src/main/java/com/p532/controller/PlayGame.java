package com.p532.controller;

import org.apache.log4j.Logger;

import com.p532.events.EventCollision;
import com.p532.events.EventKeyPress;
import com.p532.events.EventTimer;
import com.p532.timer.ObservableTimer;
import com.p532.timer.Observer;
import com.p532.view.GameArena;

public class PlayGame implements Observer {
	private EventCollision eventCollision = EventCollision.getInstance();
	private EventKeyPress eventKeyPress = EventKeyPress.getInstance();
	private EventTimer eventTimer = EventTimer.getInstance();
	private GameArena gameArena = GameArena.getInstance();
	private Logger log = Logger.getLogger(PlayGame.class);
	private ObservableTimer observableTimer;

	public void startGame() {
		gameArena.addListener(eventKeyPress);
		gameArena.setFocusable(true);
		observableTimer = new ObservableTimer();
		observableTimer.registerObserver(this);
		log.info("Starting Game");
		try {
			observableTimer.startTimer();
		} catch (Exception e) {
			log.error(e);
		}
	}

	@Override
	public void update(int counter) {
		eventCollision.notifyObservers();
		eventTimer.notifyObservers();
	}
}
