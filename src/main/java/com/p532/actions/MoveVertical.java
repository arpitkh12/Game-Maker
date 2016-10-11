package com.p532.actions;

import static com.p532.constants.Constants.VELY;

import java.awt.event.KeyEvent;

import com.p532.model.Sprite;
import com.p532.utils.Collision;

public class MoveVertical {
	private Sprite sprite;
	private int velY;

	public MoveVertical(Sprite sprite, Object t) {
		this.sprite = sprite;
		velY = sprite.getVely();
		moveDirection(t);
		move();
	}

	private void move() {
		sprite.setVely(velY);
		// PlaySound soundPlay = new PlaySound(sprite.getSoundIndex());
		sprite.setPosY(sprite.getPosY() + velY);
		sprite.setPosition();
	}

	public void moveDirection(Object t) {
		if (t instanceof KeyEvent) {
			KeyEvent keyEvent = (KeyEvent) t;
			if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
				sprite.setVelx(0);
				velY = -1 * Math.abs(VELY);
				
			}

			if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
				sprite.setVelx(0);
				velY = Math.abs(VELY);
				
			}
		}

		if (t instanceof Boolean) {
			Collision col = new Collision(sprite);
			Boolean top = col.collisionTopBorder();
			if (top == true) {
				velY = -velY;
			}
		}
	}

}
