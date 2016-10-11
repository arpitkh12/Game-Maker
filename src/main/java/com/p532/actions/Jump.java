package com.p532.actions;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import com.p532.model.Sprite;
import com.p532.view.GameArena;

public class Jump {
	private Sprite sprite;
	private int count;
	private KeyEvent keyEvent;
	private ActionListener action;
	private GameArena gameArena = GameArena.getInstance();

	public Jump(Sprite sprite, Object t) {
		this.sprite = sprite;
		if (t instanceof KeyEvent) {
			KeyEvent keyEvent = (KeyEvent) t;
			if (keyEvent.getKeyCode() == KeyEvent.VK_J) {
				actionJump();
			}
		}
		else{
			actionJump();
		}
	}

	public void jump() {
		if (count < 50) {
			sprite.setPosY(sprite.getPosY() - 1);
			count++;
		} 
		// else if (count > 50 && count < 100) {
		// sprite.setPosY(sprite.getPosY() - 1);
		// count++;
		// } 
		else {
			count = 0;
		}
	}

	public void actionJump() {
		count = 1;
		while (count != 0) {
			jump();
			sprite.setPosition();
			gameArena.repaint();
			gameArena.revalidate();
		}

	}

}
