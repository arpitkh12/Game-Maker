package com.p532.actions;

import static com.p532.constants.Constants.VELX;

import java.awt.event.KeyEvent;

import com.p532.model.Sprite;
import com.p532.utils.Collision;

public class MoveHorizontal {
	private Sprite sprite;
	private int velX;
	

	public MoveHorizontal(Sprite sprite, Object t) {
		this.sprite = sprite;
		velX = sprite.getVelx();
		
		moveDirection(t);
		move();
	}

	private void move() {
		sprite.setVelx(velX);
		// PlaySound soundPlay = new PlaySound(sprite.getSoundIndex());
		sprite.setPosX(sprite.getPosX() + velX);
		sprite.setPosition();
	}

	public void moveDirection(Object t) {
		if (t instanceof KeyEvent) {
			KeyEvent keyEvent = (KeyEvent) t;
			if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
				sprite.setVely(0);
				velX = -1 * Math.abs(VELX);
				
			}

			if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
				sprite.setVely(0);
				velX = Math.abs(VELX);
				
			}
		}

		if (t instanceof Boolean) {
			Collision col = new Collision(sprite);
			Boolean left = col.collisionLeftBorder();
			Boolean right = col.collisionRightBorder();
			if (left == true || right == true) {
				velX = -velX;
				
			}
		}
	}
}
