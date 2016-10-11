package com.p532.model;

import static com.p532.constants.Constants.VELX;
import static com.p532.constants.Constants.VELY;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import com.p532.controller.SpriteActions;
import com.p532.events.EventObserver;

public class Sprite implements EventObserver<Object> {
	private static Logger log = Logger.getLogger(Sprite.class);
	private ArrayList<Integer> eventList;
	private ArrayList<ArrayList<Integer>> actionList;
	private JLabel lblSprite;
	private int posX, posY;
	private int soundIndex;
	private int spriteId = -1;
	private ImageIcon spriteImage;
	private String spriteType;
	private int velx = VELX;
	private int vely = VELY;
	private boolean visibiltiy;

	public Sprite(String image, ArrayList<Integer> eventList, ArrayList<ArrayList<Integer>> actionList,
			int soundIndex) {
		log.info("Added new Sprite");
		this.actionList = new ArrayList<>(actionList);
		// this.actionList = actionList;
		this.eventList = new ArrayList<>(eventList);
		// this.eventList = eventList;
		lblSprite = new JLabel();
		spriteImage = new ImageIcon(image);
		this.setSoundIndex(soundIndex);
		lblSprite.setIcon(spriteImage);
		spriteCount++;
		spriteType = image;
		visibiltiy = true;
		lblSprite.setVisible(visibiltiy);
		setSpriteId(spriteCount);
	}

	public boolean isVisibiltiy() {
		return visibiltiy;
	}

	// To store number of sprites in game
	private static int spriteCount = 0;

	@Override
	public void eventOccured(Sprite observer, Object t, int eventIndex) {
		if (observer.visibiltiy) {
			SpriteActions.actionCall(observer, t, eventIndex);
		}

	}

	public Rectangle getBounds(Sprite sprite) {
		return new Rectangle(sprite.getPosX(), sprite.getPosY(), sprite.getLblSprite().getWidth(),
				sprite.getLblSprite().getHeight());
	}

	public JLabel getLblSprite() {
		return lblSprite;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getSoundIndex() {
		return soundIndex;
	}

	public int getSpriteId() {
		return spriteId;
	}

	public ImageIcon getSpriteImage() {
		return spriteImage;
	}

	public void setSpriteImage(ImageIcon spriteImage) {
		this.spriteImage = spriteImage;
	}

	public String getSpriteType() {
		return spriteType;
	}

	public int getVelx() {
		return velx;
	}

	public int getVely() {
		return vely;
	}

	public void setLblSprite(JLabel lblSprite) {
		this.lblSprite = lblSprite;
	}

	public void setPosition() {
		lblSprite.setLocation(posX, posY);
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setSoundIndex(int soundIndex) {
		this.soundIndex = soundIndex;
	}

	public void setSpriteId(int spriteId) {
		this.spriteId = spriteId;
	}

	public void setSpriteType(String spriteType) {
		this.spriteType = spriteType;
	}

	public void setVelx(int velx) {
		this.velx = velx;
	}

	public void setVely(int vely) {
		this.vely = vely;
	}

	public void setVisibiltiy(boolean visibiltiy) {
		this.visibiltiy = visibiltiy;
		lblSprite.setVisible(visibiltiy);
	}

	public ArrayList<Integer> getEventList() {
		return eventList;
	}

	public ArrayList<ArrayList<Integer>> getActionList() {
		return actionList;
	}

}
