package com.p532.actions;

import static com.p532.constants.Constants.FOUR;
import static com.p532.constants.Constants.TANK;
import static com.p532.constants.Constants.TANKDOWN;
import static com.p532.constants.Constants.TANKLEFT;
import static com.p532.constants.Constants.TANKRIGHT;
import static com.p532.constants.Constants.THREE;
import static com.p532.constants.Constants.TWO;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.p532.model.Sprite;
import com.p532.view.GameArena;

public class Rotate {

	private Sprite sprite;
	private JLabel change;
	private GameArena gameArena = GameArena.getInstance();

	private static int currentDirection = THREE;

	public Rotate(Sprite sprite, Object t) {
		this.sprite = sprite;
		moveDirection(t);

	}

	public void moveDirection(Object t) {

		if (t instanceof KeyEvent) {
			KeyEvent keyEvent = (KeyEvent) t;
			if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
				currentDirection = TWO;
				ImageIcon imgIcon = new ImageIcon(this.getClass().getClassLoader().getResource(TANKLEFT));
				change = sprite.getLblSprite();
				change.setIcon(imgIcon);
				sprite.setLblSprite(change);

			}

			if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
				currentDirection = 1;
				ImageIcon imgIcon = new ImageIcon(this.getClass().getClassLoader().getResource(TANKRIGHT));
				change = sprite.getLblSprite();
				change.setIcon(imgIcon);
				sprite.setLblSprite(change);

			}

			if (keyEvent.getKeyCode() == KeyEvent.VK_S) {
				currentDirection = FOUR;
				ImageIcon imgIcon = new ImageIcon(this.getClass().getClassLoader().getResource(TANKDOWN));
				change = sprite.getLblSprite();
				change.setIcon(imgIcon);
				sprite.setLblSprite(change);

			}

			if (keyEvent.getKeyCode() == KeyEvent.VK_W) {

				ImageIcon imgIcon = new ImageIcon(this.getClass().getClassLoader().getResource(TANK));
				change = sprite.getLblSprite();
				change.setIcon(imgIcon);
				sprite.setLblSprite(change);

			}
			gameArena.revalidate();
			gameArena.repaint();
		}

	}
}
