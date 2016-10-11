package com.p532.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import com.p532.commands.AddSpriteCommand;
import com.p532.view.GameArena;
import com.p532.view.SpritePanel;

public class ListenerSpritePanel implements ActionListener {
	private GameArena gameArena = GameArena.getInstance();
	private Logger log = Logger.getLogger(ListenerSpritePanel.class);
	private JLabel picture;
	private SpritePanel spritePanel;
	private ListenerAssociateButton listenerAssociateButton;

	public ListenerSpritePanel(SpritePanel spritePanel, ListenerAssociateButton listenerAssociateButton) {
		this.listenerAssociateButton = listenerAssociateButton;
		this.spritePanel = spritePanel;
		spritePanel.addListeners(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		log.info(e.getActionCommand());
		if (e.getActionCommand() == "Add Sprite") {
			log.info("Entered add sprite");
			AddSpriteCommand addSpriteCommand = new AddSpriteCommand();
			addSpriteCommand.setSpritePanel(spritePanel);
			addSpriteCommand.setListenerAssociateButton(listenerAssociateButton);
			addSpriteCommand.executeCommand();
		}
		// else if (e.getActionCommand() == "ADD ACTIONS&EVENTS") {
		// // Right Now do nothing.
		// // This functionality may be implemented later
		// }
		else {
			JComboBox cb = (JComboBox) e.getSource();
			String sprite = cb.getSelectedItem().toString().toLowerCase();
			updateLabel(sprite);
		}
	}

	private void updateLabel(String sprite) {

		ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource(sprite + ".png"));
		picture = spritePanel.getPicture();
		picture.setIcon(icon);
		spritePanel.setPicture(picture);
	}

}
