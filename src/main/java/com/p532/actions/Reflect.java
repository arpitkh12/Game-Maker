package com.p532.actions;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.p532.commands.AddSpriteCommand;
import com.p532.model.Sprite;
import com.p532.utils.Collision;

public class Reflect {
	private static ArrayList<Sprite> spriteList = AddSpriteCommand.getSpriteList();
	private Sprite sprite;
	private Object t;

	public Reflect(Sprite observer, Object t) {
		this.sprite = observer;
		this.t = t;
		reflect();
	}

	public void reflect() {
		Collision collision = new Collision(sprite);
		Rectangle r1 = sprite.getBounds(sprite);
		for (int i = 0; i < spriteList.size(); i++) {
			Rectangle r2 = spriteList.get(i).getBounds(spriteList.get(i));
			if (collision.collisionCheck(r1, r2) && sprite.isVisibiltiy() == true) {
				if (sprite.getSpriteId() != spriteList.get(i).getSpriteId()
						&& sprite.getSpriteType() != spriteList.get(i).getSpriteType()) {
					// spriteList.get(i).setVelx(-spriteList.get(i).getVelx());
					// spriteList.get(i).setVely(-spriteList.get(i).getVely());
					sprite.setVelx(-sprite.getVelx());
					sprite.setVely(-sprite.getVely());

				}

			}
		}

	}

}
