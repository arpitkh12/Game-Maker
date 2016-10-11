package com.p532.utils;

import static com.p532.constants.Constants.EVENTS;

import org.apache.log4j.Logger;

import com.p532.events.EventCollision;
import com.p532.events.EventKeyPress;
import com.p532.events.EventMouseClick;
import com.p532.events.EventTimer;
import com.p532.model.Sprite;

public class SetSpriteEvent {
	private EventCollision eventCollision = EventCollision.getInstance();
	private EventKeyPress eventKeyPress = EventKeyPress.getInstance();
	String[] events = EVENTS;
	private EventTimer eventTimer = EventTimer.getInstance();
	private EventMouseClick eventMouseClick = EventMouseClick.getInstance();
	private Logger log = Logger.getLogger(SetSpriteEvent.class);
	private Sprite sprite;

	public SetSpriteEvent(Sprite sprite) {
		this.sprite = sprite;
		for (int i = 0; i < sprite.getEventList().size(); i++) {
			setEvent(sprite.getEventList().get(i), i);
		}
	}

	public void setEvent(int eventIndex, int index) {
		String event = events[eventIndex];
		switch (event) {
		case "Key Press":
			log.info("Registering Key Press Event");
			eventKeyPress.registerObserver(sprite, index);
			break;
		case "Collision":
			log.info("Registering Collision Event");
			eventCollision.registerObserver(sprite, index);
			break;
		case "Timer":
			log.info("Registering Update Event");
			eventTimer.registerObserver(sprite, index);
			break;
		case "Mouse Click":
			log.info("Registering Mouse Click Event");
			eventMouseClick.registerObserver(sprite, index);
			break;
		default:
			break;
		}
	}
}
