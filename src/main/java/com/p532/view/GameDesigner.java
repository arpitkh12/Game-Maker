package com.p532.view;

import static com.p532.constants.Constants.FIFTY;
import static com.p532.constants.Constants.FRAME_HEIGHT;
import static com.p532.constants.Constants.FRAME_WIDTH;
import static com.p532.constants.Constants.TWO;
import static com.p532.constants.Constants.ZERO;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameDesigner extends JFrame {
	private GameArena gameArena = GameArena.getInstance();
	private GameDock gameDock;

	public GameDesigner(GameDock gameDock) {
		this.gameDock = gameDock;
		developGUI();
	}

	public void developGUI() {
		setTitle("Game Maker");
		setLayout(new GridLayout(ZERO, TWO));
		setBounds(FIFTY, FIFTY, FRAME_WIDTH, FRAME_HEIGHT);
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		add(gameDock);
		add(gameArena);
		setVisible(true);
		pack();
	}
}
