package com.p532.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import com.p532.commands.AddBackgroundCommand;
import com.p532.view.BackgroundPanel;
import com.p532.view.GameArena;

public class ListenerBackgroundPanel implements ActionListener {

	private BackgroundPanel backgroundPanel;
	private JLabel backgroundPicture;
	private ImageIcon bgImage;
	private GameArena gameArena = GameArena.getInstance();
	private Logger log = Logger.getLogger(ListenerBackgroundPanel.class);

	public ListenerBackgroundPanel(BackgroundPanel backgroundPanel) {
		this.backgroundPanel = backgroundPanel;
		backgroundPanel.addListnersForBackground(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		log.info(e.getActionCommand());
		if (e.getActionCommand() == "Add background") {
			log.info("Entered add background");
			// add background button code
			AddBackgroundCommand addBackgroundCommand = new AddBackgroundCommand();
			addBackgroundCommand.setBackgroundPanel(backgroundPanel);
			addBackgroundCommand.executeCommand();
		} else if (e.getActionCommand() == "ADD ACTIONS&EVENTS") {
			// Right Now do nothing.
			// This functionality may be implemented later
		} else {
			JComboBox cb = (JComboBox) e.getSource();
			bgImage = new ImageIcon(this.getClass().getClassLoader()
					.getResource(cb.getSelectedItem().toString().toLowerCase() + ".jpeg"));
			backgroundPanel.setBgImage(bgImage);
			updateLabel(bgImage);
		}
	}

	public ImageIcon getBgImage() {
		return bgImage;
	}

	private void updateLabel(ImageIcon bgImage) {
		backgroundPicture = backgroundPanel.getBackgroundPicture();
		backgroundPicture.setIcon(bgImage);
		backgroundPanel.setBackgroundPicture(backgroundPicture);
	}
}
