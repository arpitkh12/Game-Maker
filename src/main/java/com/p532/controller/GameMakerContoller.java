package com.p532.controller;

import static com.p532.constants.Constants.TEN;
import static com.p532.constants.Constants.TWO;

import java.awt.Rectangle;

import com.p532.commands.CommandLogic;
import com.p532.view.BackgroundPanel;
import com.p532.view.GameArena;
import com.p532.view.GameDesigner;
import com.p532.view.GameDock;
import com.p532.view.SpritePanel;

@SuppressWarnings("unused")
public class GameMakerContoller {
	private BackgroundPanel backgroundPanel;
	private CommandLogic commandLogic;
	private GameArena gameArena;
	private GameDesigner gameDesigner;
	private GameDock gameDock;
	private ListenerBackgroundPanel listenerBackgroundPanel;
	private ListenerPlayButton listenerPlayButton;
	private ListenerSpritePanel listenerSpritePanel;
	private ListenerAssociateButton listenerAssociateButton;
	private PlayGame playGame;
	private SpritePanel spritePanel;

	public GameMakerContoller() {
		init();

		while (true) {
			Rectangle r = gameDesigner.getBounds();
			double height = r.getHeight();
			double width = r.getWidth();

			GameArena.height = (int) (height);
			GameArena.width = (int) (width / TWO - TEN);
		}

	}

	public int init() {
		commandLogic = new CommandLogic();
		backgroundPanel = new BackgroundPanel();
		spritePanel = new SpritePanel();
		gameDock = new GameDock(spritePanel, backgroundPanel);
		gameArena = GameArena.getInstance();
		commandLogic = new CommandLogic();
		gameDesigner = new GameDesigner(gameDock);
		listenerAssociateButton = new ListenerAssociateButton(spritePanel);
		playGame = new PlayGame();

		listenerPlayButton = new ListenerPlayButton(gameDock, playGame);
		gameArena.setBackgroundPanel(backgroundPanel);
		listenerSpritePanel = new ListenerSpritePanel(spritePanel, listenerAssociateButton);
		listenerBackgroundPanel = new ListenerBackgroundPanel(backgroundPanel);

		return 0;
	}
}
