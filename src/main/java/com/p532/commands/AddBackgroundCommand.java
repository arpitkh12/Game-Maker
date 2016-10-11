package com.p532.commands;

import com.p532.view.BackgroundPanel;
import com.p532.view.GameArena;

public class AddBackgroundCommand implements Command {
	public GameArena arena = GameArena.getInstance();
	private BackgroundPanel backgroundPanel;

	@Override
	public void executeCommand() {
		arena.revalidate();
		arena.repaint();

	}

	public void setBackgroundPanel(BackgroundPanel backgroundPanel) {
		this.backgroundPanel = backgroundPanel;
	}
}
