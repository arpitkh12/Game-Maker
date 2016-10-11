package com.p532.actions;

import com.p532.model.Sprite;
import com.p532.view.GameArena;

public class Collision_Right {

	private Sprite observer;
	private Object t;

	public Collision_Right(Sprite observer, Object t) {
		this.observer = observer;
		this.t = t;
		collisionRightBorder();
	}

	public void collisionRightBorder() {
		if (observer.getPosX() >= GameArena.width - observer.getLblSprite().getWidth()) {
			observer.setVelx(observer.getVelx() * -1);
		}

	}
}
