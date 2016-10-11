package com.p532.actions;

import static com.p532.constants.Constants.VELX;
import static com.p532.constants.Constants.VELY;

import java.awt.event.KeyEvent;

import com.p532.model.Sprite;
import com.p532.utils.Collision;

public class MoveCross {
	private Sprite sprite;
	private int velX;
	private int velY;

	public MoveCross(Sprite sprite, Object t) {
		this.sprite = sprite;
		velX = sprite.getVelx();
		velY = sprite.getVely();
		moveDirection(t);
		move();
	}

	public void move() {
		sprite.setVelx(velX);
		sprite.setVely(velY);
		sprite.setPosY(sprite.getPosY() + velY);
		sprite.setPosX(sprite.getPosX() + velX);
		sprite.setPosition();
	}

	public void moveDirection(Object t) {
		if (t instanceof KeyEvent) {
			KeyEvent keyEvent = (KeyEvent) t;
			if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
				velX = -1 * Math.abs(VELX);
			}

			if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
				velX = Math.abs(VELX);
			}

			if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
				velY = -1 * Math.abs(VELY);
			}

			if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
				velY = Math.abs(VELY);
			}
		}

		if (t instanceof Boolean) {
			Collision col = new Collision(sprite);
			Boolean left = col.collisionLeftBorder();
			Boolean right = col.collisionRightBorder();
			if (left == true || right == true) {
				velX = -velX;
			}
			Boolean top = col.collisionTopBorder();
			if (top == true) {
				velY = -velY;
			}

			// newly added code
			Boolean bottom = col.collisionBottomBorder();
			if (bottom.equals(true)) {
				velY = -velY;
			}
		}
	}

}
