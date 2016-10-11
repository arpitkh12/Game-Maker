package com.p532.actions;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import com.p532.model.Sprite;
import com.p532.view.GameArena;

public class RevealBlockType {
	
	private static Logger log = Logger.getLogger(RevealBlockType.class);
	private GameArena gameArena = GameArena.getInstance();	
	
	
	
	public RevealBlockType(Sprite sprite,Object t) {
		revealBlock(sprite, t);
	}
	
	public void revealBlock(Sprite sprite, Object t){
		if(t instanceof MouseEvent){
			init(sprite);
		}
		if(t instanceof KeyEvent){
			init(sprite);
			
		}
	}
	
	public void init(Sprite sprite){
		sprite.setVisibiltiy(false);
		ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("mine.png"));
		JLabel lblSprite = new JLabel();
		lblSprite.setIcon(icon);
		sprite.setLblSprite(lblSprite);
		sprite.setSpriteImage(icon);
		sprite.setPosX(sprite.getPosX());
		sprite.setPosY(sprite.getPosY());
		sprite.setPosition();
		sprite.setVisibiltiy(true);
		gameArena.add(sprite.getLblSprite());
		gameArena.repaint();
		gameArena.revalidate();
		log.info("Changed block");
	}

}
