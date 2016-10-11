package com.p532.actions;

import com.p532.model.Sprite;

public class Collision_Left {

	private Sprite observer;
	private Object t;

	public Collision_Left(Sprite observer, Object t) {
		this.observer = observer;
		this.t = t;
		collisionLeftBorder();
	}

	public void collisionLeftBorder() {
		if (observer.getPosX() <= 0) {
			observer.setVelx(observer.getVelx() * -1);
		}
	}

}