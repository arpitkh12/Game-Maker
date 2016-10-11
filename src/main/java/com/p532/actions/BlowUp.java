package com.p532.actions;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.p532.commands.AddSpriteCommand;
import com.p532.controller.PlaySound;
import com.p532.model.Sprite;
import com.p532.utils.Collision;

public class BlowUp {
	private static ArrayList<Sprite> spriteList = AddSpriteCommand.getSpriteList();
	private Sprite sprite;

	public BlowUp(Sprite sprite, Object t) {
		this.sprite = sprite;
		if (t instanceof Boolean) {
			blowCheck();
		} else {
			blow();
		}
	}

	public void blow() {
		PlaySound soundPlay = new PlaySound(sprite.getSoundIndex());
		soundPlay.playSound();
		sprite.setVisibiltiy(false);
	}

	public void blowCheck() {
		Collision collision = new Collision(sprite);
		Rectangle r1 = sprite.getBounds(sprite);
		for (int i = 0; i < spriteList.size(); i++) {
			Rectangle r2 = spriteList.get(i).getBounds(spriteList.get(i));
			if (collision.collisionCheck(r1, r2) && sprite.isVisibiltiy() == true) {
				if (sprite.getSpriteId() != spriteList.get(i).getSpriteId()
						&& sprite.getSpriteType() != spriteList.get(i).getSpriteType()) {
					if (sprite.getSpriteType() == "SPECIAL1") {
						spriteList.get(i).setVelx(-spriteList.get(i).getVelx());
						spriteList.get(i).setVely(-spriteList.get(i).getVely());

					} else {
						spriteList.get(i).setVelx(-spriteList.get(i).getVelx());
						spriteList.get(i).setVely(-spriteList.get(i).getVely());
						blow();
					}

				}
			}
		}
	}
}
