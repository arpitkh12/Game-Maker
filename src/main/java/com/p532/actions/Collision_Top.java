package com.p532.actions;

import com.p532.model.Sprite;

public class Collision_Top {

	private Sprite observer;
	private Object t;

	public Collision_Top(Sprite observer, Object t) {
		this.observer = observer;
		this.t = t;
		collisionTopBorder();
	}

	public void collisionTopBorder() {
		if (observer.getPosY() <= 0) {
			observer.setVely(observer.getVely() * -1);
		}
	}

}
