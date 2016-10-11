package com.p532.view;

import static com.p532.constants.Constants.BACKGROUND;
import static com.p532.constants.Constants.SPRITE_HEIGHT;
import static com.p532.constants.Constants.SPRITE_WIDTH;
import static com.p532.constants.Constants.THREE;
import static com.p532.constants.Constants.TWO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	private JLabel backgroundPicture = new JLabel();
	private ImageIcon bgImage;
	private JButton btnBackground = new JButton("Add Background");
	private JComboBox<String> cbBackgrounds;
	private JLabel lblBackground = new JLabel("              Background Image");
	private String[] messagesbackgrounds = BACKGROUND;

	public BackgroundPanel() {
		setFocusable(true);
		setPreferredSize(new Dimension(SPRITE_WIDTH, SPRITE_HEIGHT / TWO));
		setBorder(BorderFactory.createMatteBorder(TWO, TWO, TWO, TWO, Color.BLACK));
		setLayout(new GridLayout(0, TWO));
		init();
	}

	// To add Action Listener for Background JComboBox and button
	public void addListnersForBackground(ActionListener listener) {
		cbBackgrounds.addActionListener(listener);
		btnBackground.addActionListener(listener);
	}

	public JLabel getBackgroundPicture() {
		return backgroundPicture;
	}

	public ImageIcon getBgImage() {
		return bgImage;
	}

	public JButton getBtnBackground() {
		return btnBackground;
	}

	public String getSelecteditem() {
		return cbBackgrounds.getSelectedItem().toString();
	}

	private void init() {
		cbBackgrounds = new JComboBox<String>(messagesbackgrounds);
		// Left panel to hold the label, combo box and the button
		JPanel tempBgPanel = new JPanel();
		tempBgPanel.setLayout(new GridLayout(THREE, 0));
		tempBgPanel.add(lblBackground);
		tempBgPanel.add(cbBackgrounds);
		tempBgPanel.add(btnBackground);
		// Right panel to hold the background image display
		JPanel backpicPanel = new JPanel();
		backpicPanel.add(backgroundPicture);
		btnBackground.setActionCommand("Add background");
		this.add(tempBgPanel);
		this.add(backpicPanel);
	}

	public void setBackgroundPicture(JLabel backgroundPicture) {
		this.backgroundPicture = backgroundPicture;
	}

	public void setBgImage(ImageIcon bgImage) {
		this.bgImage = bgImage;
	}

	public void setBtnBackground(JButton btnBackground) {
		this.btnBackground = btnBackground;
	}
}
