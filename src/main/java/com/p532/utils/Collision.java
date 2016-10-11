package com.p532.utils;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.p532.commands.AddSpriteCommand;
import com.p532.constants.Constants;
import com.p532.model.Sprite;
import com.p532.view.GameArena;

public class Collision implements Constants {
	private static ArrayList<Sprite> spriteList = AddSpriteCommand.getSpriteList();
	private Sprite observer;

	public Collision(Sprite observer) {
		this.observer = observer;
	}

	public Boolean collisionCheck(Rectangle r1, Rectangle r2) {
		if (r1.intersects(r2)) {
			return true;
		}
		return false;
	}

	public Boolean collisionLeftBorder() {
		if (observer.getPosX() <= 0) {
			return true;
		}
		return false;
	}

	public Boolean collisionRightBorder() {
		if (observer.getPosX() >= GameArena.width - observer.getLblSprite().getWidth()) {
			return true;
		}
		return false;
	}

	public Boolean collisionTopBorder() {
		if (observer.getPosY() <= 0) {
			return true;
		}
		return false;
	}

	// newly added code
	public Boolean collisionBottomBorder() {
		if (observer.getPosY() >= GameArena.height - observer.getLblSprite().getHeight()) {
			return true;
		}
		return false;
	}
}
