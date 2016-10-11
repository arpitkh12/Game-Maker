package com.p532.commands;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.p532.controller.ListenerAssociateButton;
import com.p532.gamemaker.DragListener;
import com.p532.model.Sprite;
import com.p532.utils.SetSpriteEvent;
import com.p532.view.GameArena;
import com.p532.view.JComboCheckBox;
import com.p532.view.SpritePanel;

@SuppressWarnings("unused")
public class AddSpriteCommand implements Command {
	private static ArrayList<Sprite> spriteList = new ArrayList<Sprite>();

	public static void setSpriteList(ArrayList<Sprite> spriteList) {
		AddSpriteCommand.spriteList = spriteList;
	}

	public static ArrayList<Sprite> getSpriteList() {
		return spriteList;
	}

	private ArrayList<Integer> eventList;
	private ArrayList<ArrayList<Integer>> actionList;
	private GameArena arena = GameArena.getInstance();
	private DragListener drag;
	private ImageIcon icon;
	private JLabel lblSprite;
	private Sprite newSprite;
	private ListenerAssociateButton listenerAssociateButton;

	public void setListenerAssociateButton(ListenerAssociateButton listenerAssociateButton) {
		this.listenerAssociateButton = listenerAssociateButton;
	}

	private SetSpriteEvent setSpriteEvent;
	private SpritePanel spritePanel;

	@Override
	public void executeCommand() {
		eventList = listenerAssociateButton.getEventList();
		actionList = listenerAssociateButton.getActionList();

		newSprite = new Sprite(spritePanel.getSelecteditem(), eventList, actionList, spritePanel.getSelectedSound());
		spriteList.add(newSprite);
		listenerAssociateButton.clear();
		// arena.addSpriteToSpriteList(newSprite);
		setSpriteEvent = new SetSpriteEvent(newSprite);
		// Image
		// image_piece=ImageIO.read(getClass().getResourceAsStream("ball.png"));
		// icon = image_piece.;
		icon = new ImageIcon(this.getClass().getClassLoader()
				.getResource(spritePanel.getSelecteditem().toString().toLowerCase() + ".png"));
		lblSprite = new JLabel();
		lblSprite.setIcon(icon);
		newSprite.setLblSprite(lblSprite);
		drag = new DragListener(newSprite);
		arena.add(newSprite.getLblSprite());
		arena.revalidate();
		arena.repaint();
		newSprite.getLblSprite().addMouseListener(drag);
		newSprite.getLblSprite().addMouseMotionListener(drag);
		JComboCheckBox.clear();
	}

	public void setSpritePanel(SpritePanel spritePanel) {
		this.spritePanel = spritePanel;
	}

	public void addSprite(Sprite sprite) {
		spriteList.add(sprite);
	}
}
