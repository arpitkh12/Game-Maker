package com.p532.actions;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import com.p532.commands.AddSpriteCommand;
import com.p532.model.Sprite;
import com.p532.utils.SetSpriteEvent;
import com.p532.view.GameArena;

public class BlowAndDivide {

	private static Logger log = Logger.getLogger(BlowAndDivide.class);

	private GameArena gameArena = GameArena.getInstance();
	private SetSpriteEvent setSpriteEvent;
	private AddSpriteCommand addSpriteCommand;

	private Sprite[] dividedSprites = new Sprite[2];

	public BlowAndDivide(Sprite sprite, Object t) {
		blow_divide(sprite, t);
	}

	public void blow_divide(Sprite sprite, Object t) {
		if (t instanceof Boolean) {
			init(sprite, t);
		}
	}

	public void init(Sprite sprite, Object t) {
		if (t instanceof Boolean)
			sprite.setVisibiltiy(false);

		/*
		 * dividedSprites properties like actions and events(as if you are
		 * adding through the game maker)
		 */

		ArrayList<Integer> eventList = new ArrayList<>();
		eventList.add(2);
		ArrayList<ArrayList<Integer>> actionList = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		actionList.add(list);
		// String dividedImage = sprite.getLblSprite().toString();

		int j = 1;
		for (int i = 0; i < 2; i++) {

			dividedSprites[i] = new Sprite("brick5", eventList, actionList, 0);
			dividedSprites[i].setPosX(sprite.getPosX() + (50 * i * j));
			dividedSprites[i].setPosY(sprite.getPosY() - (50 * i * j));
			j *= -1;
			/*
			 * Associating the spriteBullet with game arena, linking events,
			 * etc.
			 */

			dividedSprites[i].setVisibiltiy(true);
			setSpriteEvent = new SetSpriteEvent(dividedSprites[i]);

			ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("brick5.png"));
			JLabel lblSprite = new JLabel();
			lblSprite.setIcon(icon);
			dividedSprites[i].setLblSprite(lblSprite);

			addSpriteCommand = new AddSpriteCommand();
			addSpriteCommand.addSprite(dividedSprites[i]);

			gameArena.add(dividedSprites[i].getLblSprite());
		}
		// end of for loop

		gameArena.repaint();
		gameArena.revalidate();

		/*------*/

		log.info("Created sub Sprites");

	}

}
