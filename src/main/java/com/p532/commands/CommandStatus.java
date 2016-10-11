package com.p532.commands;

public class CommandStatus {

	private static boolean spriteAdded = false;

	public static boolean isSpriteAdded() {
		return spriteAdded;
	}

	public static void setSpriteAdded(boolean spriteAdded) {
		CommandStatus.spriteAdded = spriteAdded;
	}

	private CommandStatus() {

	}
}
