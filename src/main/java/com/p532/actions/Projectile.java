package com.p532.actions;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import com.p532.commands.AddSpriteCommand;
import com.p532.model.Sprite;
import com.p532.utils.SetSpriteEvent;
import com.p532.view.GameArena;

public class Projectile {
	private static Logger log = Logger.getLogger(Projectile.class);
	private Sprite spriteBullet;
	public GameArena gameArena = GameArena.getInstance();
	private SetSpriteEvent setSpriteEvent;
	private AddSpriteCommand addSpriteCommand;
	private static int count = 0;

	public Projectile(Sprite sprite, Object t) {
		shooting(sprite, t);

	}

	public void init(Sprite sprite, Object t) {
		ArrayList<Integer> eventList = new ArrayList<>();
		eventList.add(2);
		ArrayList<ArrayList<Integer>> actionList = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		actionList.add(list);
		spriteBullet = new Sprite("bullet", eventList, actionList, 0);
		spriteBullet.setPosX(sprite.getPosX());
		spriteBullet.setPosY(sprite.getPosY());
		spriteBullet.setVisibiltiy(true);
		setSpriteEvent = new SetSpriteEvent(spriteBullet);
		ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("bullet.png"));
		JLabel lblSprite = new JLabel();
		lblSprite.setIcon(icon);
		spriteBullet.setLblSprite(lblSprite);
		addSpriteCommand = new AddSpriteCommand();
		addSpriteCommand.addSprite(spriteBullet);
		gameArena.add(spriteBullet.getLblSprite());
		gameArena.repaint();
		gameArena.revalidate();
		log.info("Created bullet");

	}

	public void shooting(Sprite sprite, Object t) {
		if (t instanceof KeyEvent) {
			KeyEvent keyEvent = (KeyEvent) t;
			if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
				init(sprite, t);
			}
		} else {
			count++;
			if (count % 100 == 0)
				init(sprite, t);
		}
	}

}