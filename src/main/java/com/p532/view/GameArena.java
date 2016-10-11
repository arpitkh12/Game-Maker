package com.p532.view;

import static com.p532.constants.Constants.GAME_ARENA_WIDTH;
import static com.p532.constants.Constants.GAME_DOCK_HEIGHT;
import static com.p532.constants.Constants.HUNDRED;
import static com.p532.constants.Constants.ONENINTY;
import static com.p532.constants.Constants.ONESEVENTYFIVE;
import static com.p532.constants.Constants.TWO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.p532.gamemaker.DragLayout;

@SuppressWarnings("serial")
public class GameArena extends JPanel {
	// private ArrayList<Sprite> spriteList = new ArrayList<Sprite>();
	//
	// public void addSpriteToSpriteList(Sprite newSprite) {
	// spriteList.add(newSprite);
	// }

	public BackgroundPanel backgroundPanel;
	private Logger log = Logger.getLogger(GameArena.class);
	public ArrayList<JLabel> spriteLabel = new ArrayList<JLabel>();

	public static int height = GAME_DOCK_HEIGHT;
	public static int width = GAME_ARENA_WIDTH;

	private static GameArena gameArena;

	public static GameArena getInstance() {
		if (gameArena == null) {
			gameArena = new GameArena();
		}
		return gameArena;
	}

	private GameArena() {

		requestFocus();
		requestFocusInWindow();
		log.info("Created GameArena");
		setFocusable(true);
		this.setLayout(new DragLayout());
		this.setPreferredSize(new Dimension(GAME_ARENA_WIDTH, GAME_DOCK_HEIGHT));
		this.setBorder(
				BorderFactory.createMatteBorder(TWO, TWO, TWO, TWO, new Color(HUNDRED, ONESEVENTYFIVE, ONENINTY)));
		revalidate();
		repaint();
		setVisible(true);

	}

	public void addListener(KeyListener listener) {
		requestFocus();
		this.addKeyListener(listener);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// ImageIcon bgImage = new ImageIcon(backgroundPanel.getBgImage());
		// if (backgroundPanel.getBgImage() == null) {
		// ImageIcon defaultImage = new ImageIcon("images/default.jpeg");
		// g.drawImage(defaultImage.getImage(), 0, 0, this.getSize().width,
		// this.getSize().height, this);
		// }
		// g.drawImage(bgImage.getImage(), 0, 0, this.getSize().width,
		// this.getSize().height, this);
		for (JLabel sprite : spriteLabel) {
			add(sprite);
		}
	}

	public void setBackgroundPanel(BackgroundPanel backgroundPanel) {
		this.backgroundPanel = backgroundPanel;
	}

}
