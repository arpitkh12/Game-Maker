package com.p532.view;

import static com.p532.constants.Constants.FORTY;
import static com.p532.constants.Constants.FOURSIXTY;
import static com.p532.constants.Constants.GAME_DOCK_HEIGHT;
import static com.p532.constants.Constants.GAME_DOCK_WIDTH;
import static com.p532.constants.Constants.HUNDRED;
import static com.p532.constants.Constants.ONENINTY;
import static com.p532.constants.Constants.ONESEVENTYFIVE;
import static com.p532.constants.Constants.THREE;
import static com.p532.constants.Constants.TWENTY;
import static com.p532.constants.Constants.TWO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.p532.controller.ListenerSaveLoadButtons;

@SuppressWarnings("serial")
public class GameDock extends JPanel {

	public enum Actions {
		LOAD, SAVE
	}

	private BackgroundPanel bpanel;
	public JButton btnLoad;
	private JButton btnPlay;
	private JButton btnSave;
	private JPanel buttonPanel;

	private SpritePanel spritePanel;

	public GameDock(SpritePanel spritePanel, BackgroundPanel backgroundPanel) {
		setVisible(true);
		this.spritePanel = spritePanel;
		this.bpanel = backgroundPanel;
		setLayout(new GridBagLayout());
		init();
	}

	public void addPlayActionListener(ActionListener listener) {
		btnPlay.addActionListener(listener);
	}

	public int init() {
		setPreferredSize(new Dimension(GAME_DOCK_WIDTH, GAME_DOCK_HEIGHT));
		setBorder(BorderFactory.createMatteBorder(TWO, TWO, TWO, TWO, new Color(HUNDRED, ONESEVENTYFIVE, ONENINTY)));
		buttonPanel = new JPanel();
		GridBagConstraints c = new GridBagConstraints();

		// For sprite panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = FORTY;
		c.weightx = 0.0;
		c.gridwidth = THREE;
		c.gridx = 0;
		c.gridy = 0;
		this.add(spritePanel, c);

		// For background panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = FORTY;
		c.weightx = 0.0;
		c.gridwidth = THREE;
		c.gridx = 0;
		c.gridy = 1;
		this.add(bpanel, c);

		buttonPanel.setLayout(new GridLayout(0, THREE));

		// Adding the save button

		btnSave = new JButton("SAVE");
		btnSave.setPreferredSize(new Dimension(FOURSIXTY / THREE, TWENTY));
		btnSave.setBorder(BorderFactory.createMatteBorder(TWO, TWO, TWO, TWO, Color.GREEN));
		buttonPanel.add(btnSave, c);
		btnSave.setActionCommand(Actions.SAVE.name());
		ListenerSaveLoadButtons l = new ListenerSaveLoadButtons(this);
		btnSave.addActionListener(l);

		btnLoad = new JButton("LOAD");
		btnLoad.setPreferredSize(new Dimension(FOURSIXTY / THREE, TWENTY));
		btnLoad.setBorder(BorderFactory.createMatteBorder(TWO, TWO, TWO, TWO, Color.RED));
		buttonPanel.add(btnLoad, c);
		btnLoad.setActionCommand(Actions.LOAD.name());
		btnLoad.addActionListener(l);

		btnPlay = new JButton("Play");
		btnPlay.setPreferredSize(new Dimension(FOURSIXTY / THREE, TWENTY));
		btnPlay.setBorder(BorderFactory.createMatteBorder(TWO, TWO, TWO, TWO, Color.BLUE));
		buttonPanel.add(btnPlay, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = TWENTY;
		c.weightx = 0.0;
		c.gridwidth = THREE;
		c.gridx = 0;
		c.gridy = TWO;
		this.add(buttonPanel, c);

		return 0;

	}
}
