package com.p532.constants;

public interface Constants {

	public static final int HUNDRED = 100;
	public static final int ONESEVENTYFIVE = 175;
	public static final int ONENINTY = 190;
	public static final int THREE = 3;
	public static final int TWO = 2;
	public static final int FOUR = 4;
	public static final int FORTY = 4;
	public static final int TWENTY = 20;
	public static final int TEN = 10;
	public static final int ZERO = 0;
	public static final int EIGHT = 8;
	public static final int FIFTY = 50;
	public static final int FOURSIXTY = 460;
	public static final int SIXHUNDRED = 600;
	public static final int PLANKHEIGHT = 100;

	public static final String[] ACTIONS = { "Move Cross", "Move Horizontal", "Move Vertical", "Blow Up", "Shoot",
			"Rotate", "Jump", "Blow and Divide", "Reveal Block Type", "Reflect", "Collision Top", "Collision Bottom",
			"Collision Left", "Collision Right" };

	public static final String[] BACKGROUND = { "DEFAULT", "DAY", "SAND", "SKY", "WATER", "SPACE" };
	// Variables for images for Sprite class
	public static final String BALL = "/ball.png";

	public static final String BULLET = "/bullet.png";

	public static final String TANK = "tank.png";
	public static final String TANKLEFT = "tank_left.png";
	public static final String TANKRIGHT = "tank_right.png";
	public static final String TANKDOWN = "tank_down.png";
	public static final String BRICK1 = "brick1.png";
	public static final String BRICK2 = "brick2.png";
	public static final String BRICK3 = "brick3.png";
	public static final String BRICK4 = "brick4.png";
	public static final String BRICK5 = "brick5.png";
	public static final String ASTEROID = "asteroid.png";
	public static final String ROD = "rod.png";

	/* Minesweeper sprites */
	public static final String GRID = "grid.png";
	public static final String BLOCK_1 = "block_1.png";
	public static final String BLOCK_2 = "block_2.png";
	public static final String BLOCK_3 = "block_3.png";
	public static final String MINE = "mine.png";
	public static final String UNCOVERED_BLOCK = "uncovered_block.png";
	public static final String COVERED_BLOCK = "covered_block.png";

	// Variables for background images
	public static final String DEFAULT = "/defaultimage.jpeg";

	// Variables for images for Sprite class
	public static final String DEFAULTIMAGE = "/defaultimage.jpeg";
	// Variables for ObservableTimer class
	public static final int DELAY = 10;
	public static final String[] DIRECTIONS = { "Up", "Down", "Left", "Right" };
	public static final int EVENT_PANEL_HEIGHT = 260;
	// Variables for Event Panel
	public static final int EVENT_PANEL_WIDTH = 470;

	public static final String[] EVENTS = { "Key Press", "Collision", "Timer", "Mouse Click" };

	public static final int FRAME_HEIGHT = 600;
	public static final int FRAME_WIDTH = 1000;

	// Variables for Game Panel

	public static final int GAME_ARENA_HEIGHT = FRAME_HEIGHT;
	// Variable for Game Arena
	public static final int GAME_ARENA_WIDTH = FRAME_WIDTH / 2 - 10;

	public static final int GAME_DOCK_HEIGHT = FRAME_HEIGHT;
	// Variable for Game Dock
	public static final int GAME_DOCK_WIDTH = FRAME_WIDTH / 2 - 10;

	public static final String PADDLE = "/paddle.png";

	public static final String SAND = "/sand.jpeg";
	public static final String WATER = "/water.jpeg";
	public static final String SKY = "/sky.jpeg";
	public static final String SPACE = "/space.jpeg";
	public static final String DAY = "/day.jpeg";

	public static final String[] SOUNDS = { "ballbounce", "brickbreak", "paddlebounce" };

	public static final int SPRITE_HEIGHT = 260;
	public static final String[] SPRITE_LIST = { "BALL", "BRICK1", "BRICK2", "BRICK3", "TANK", "PADDLE", "ASTEROID",
			"ROD", "GRID", "BLOCK_1", "BLOCK_2", "BLOCK_3", "MINE", "UNCOVERED_BLOCK", "COVERED_BLOCK" };

	// Variables for Sprite Panel
	public static final int SPRITE_WIDTH = 470;

	// Variables for Movement
	public static final int VELX = 2;
	public static final int VELY = -2;

	// Variable for Shoot
	public static final int SEVEN = 7;

}
