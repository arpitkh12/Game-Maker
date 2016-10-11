package com.p532.actions;

import com.p532.model.Sprite;
import com.p532.view.GameArena;

public class Collision_Bottom {

	private Sprite observer;
	private Object t;

	public Collision_Bottom(Sprite observer, Object t) {
		this.observer = observer;
		this.t = t;
		collisionBottomBorder();
	}

	public void collisionBottomBorder() {
		if (observer.getPosY() >= GameArena.height - observer.getLblSprite().getHeight()) {
			observer.setVely(observer.getVely() * -1);
		}
	}
}
