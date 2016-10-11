package com.p532.controller;

import java.util.ArrayList;

import com.p532.model.Sprite;
import com.p532.utils.MapActions;

public class SpriteActions {
	private static ArrayList<Integer> actionList;
	private static MapActions mapActions = new MapActions();

	public static void actionCall(Sprite observer, Object t, int eventIndex) {
		actionList = observer.getActionList().get(eventIndex);
		for (int i = 0; i < actionList.size(); i++) {
			mapActions.findAction(actionList.get(i), observer, t);
		}
	}
}
