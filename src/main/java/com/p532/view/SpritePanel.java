package com.p532.view;

import static com.p532.constants.Constants.ACTIONS;
import static com.p532.constants.Constants.EIGHT;
import static com.p532.constants.Constants.EVENTS;
import static com.p532.constants.Constants.SOUNDS;
import static com.p532.constants.Constants.SPRITE_HEIGHT;
import static com.p532.constants.Constants.SPRITE_LIST;
import static com.p532.constants.Constants.SPRITE_WIDTH;
import static com.p532.constants.Constants.TWO;
import static com.p532.constants.Constants.ZERO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "rawtypes" })
public class SpritePanel extends JPanel {
	private JPanel actionContentsPanel = new JPanel();
	private JButton addButton = new JButton("Add Sprite");
	private JButton associateButton = new JButton("Associate Events and Sprite");

	private Vector allActionsList = new Vector();

	public void setAllActionsList(Vector allActionsList) {
		this.allActionsList = allActionsList;
	}

	private JComboCheckBox ccbActions;
	private JComboBox<String> cbEvents;
	private JComboBox<String> cbSounds;
	private JComboBox<String> cbSprite;
	private JPanel displaySpritePanel = new JPanel();
	private JPanel eventContentsPanel = new JPanel();

	private JLabel lblAction = new JLabel("Select an Action:");
	private JLabel lblEvent = new JLabel("Select an Event:");
	private JLabel lblSound = new JLabel("Select a sound:");
	private JLabel lblSprite = new JLabel("Select a Sprite:");
	private String[] messagesevent = EVENTS;
	private String[] messagessound = SOUNDS;
	private JLabel picture = new JLabel();
	private JPanel soundContentsPanel = new JPanel();
	private JPanel spriteContentsPanel = new JPanel();
	private JLabel instructions = new JLabel("       Arrow keys: navigate   Space: shoot   A-W-S-D: Rotate");

	public SpritePanel() {
		setFocusable(true);
		setPreferredSize(new Dimension(SPRITE_WIDTH, SPRITE_HEIGHT));
		setBorder(BorderFactory.createMatteBorder(TWO, TWO, TWO, TWO, Color.BLACK));
		setLayout(new GridLayout(EIGHT, ZERO));
		init();
	}

	// To add Action Listener for Sprite JComboBox
	public void addListeners(ActionListener listener) {
		cbSprite.addActionListener(listener);
		addButton.addActionListener(listener);
	}

	public void addSoundListeners(ActionListener listener) {
		cbSounds.addActionListener(listener);
	}

	public void addAssociationListener(ActionListener listener) {
		associateButton.addActionListener(listener);
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JLabel getPicture() {
		return picture;
	}

	public ArrayList<Integer> getSelectedAction() {
		ArrayList<Integer> indexActions = ccbActions.getSelected();
		return indexActions;
	}

	public int getSelectedEvent() {

		return cbEvents.getSelectedIndex();
	}

	public String getSelecteditem() {
		// TODO Auto-generated method stub
		return cbSprite.getSelectedItem().toString().toLowerCase();
	}

	public int getSelectedSound() {
		return cbSounds.getSelectedIndex();
	}

	public int init() {
		for (int i = 0; i < ACTIONS.length; i++) {
			allActionsList.add(new JCheckBox(ACTIONS[i], false));
		}
		ccbActions = new JComboCheckBox(allActionsList, this);
		cbSprite = new JComboBox<String>(SPRITE_LIST);
		cbEvents = new JComboBox<String>(messagesevent);
		cbSounds = new JComboBox<String>(messagessound);
		cbSprite.setSelectedIndex(0);
		spriteContentsPanel.add(lblSprite);
		spriteContentsPanel.add(cbSprite);
		actionContentsPanel.add(lblAction);
		actionContentsPanel.add(ccbActions);
		eventContentsPanel.add(lblEvent);
		eventContentsPanel.add(cbEvents);
		soundContentsPanel.add(lblSound);
		soundContentsPanel.add(cbSounds);
		displaySpritePanel.setBorder(BorderFactory.createMatteBorder(TWO, TWO, TWO, TWO, Color.BLACK));
		displaySpritePanel.add(picture);

		this.add(displaySpritePanel);
		this.add(spriteContentsPanel);
		this.add(actionContentsPanel);
		this.add(eventContentsPanel);
		this.add(associateButton);
		this.add(soundContentsPanel);
		this.add(instructions);
		this.add(addButton);
		return 0;
	}

	public void setActionContentsPanel(JPanel actionContentsPanel) {
		this.actionContentsPanel = actionContentsPanel;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public void setPicture(JLabel picture) {
		this.picture = picture;
	}

}
