package com.p532.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.p532.view.GameDock;

public class ListenerPlayButton implements ActionListener {
	private GameDock gameDock;
	private PlayGame playGame;

	public ListenerPlayButton(GameDock gameDock, PlayGame playGame) {
		this.gameDock = gameDock;
		this.playGame = playGame;
		gameDock.addPlayActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Play") {
			playGame.startGame();
		}
	}

}
