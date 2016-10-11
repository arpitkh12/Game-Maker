package com.p532.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.p532.view.SpritePanel;

public class ListenerAssociateButton implements ActionListener {

	private Logger log = Logger.getLogger(ListenerAssociateButton.class);
	private ArrayList<ArrayList<Integer>> actionList = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> eventList = new ArrayList<Integer>();
	private SpritePanel spritePanel;
	// this eventIndex is used only for checking if that index exists in the
	// eventList
	private int eventIndex = 0;
	// actionsForOneEvent contains all the action indices that are ticked before
	// clicking the associate button
	private ArrayList<Integer> actionsForOneEvent = new ArrayList<Integer>();

	public ArrayList<ArrayList<Integer>> getActionList() {
		return actionList;
	}

	public ListenerAssociateButton(SpritePanel spritePanel) {
		this.spritePanel = spritePanel;
		spritePanel.addAssociationListener(this);
	}

	public ArrayList<Integer> getEventList() {
		return eventList;
	}

	public void clear() {
		eventList.clear();
		actionList.clear();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		eventIndex = spritePanel.getSelectedEvent();
		actionsForOneEvent = spritePanel.getSelectedAction();

		if (eventList.contains(eventIndex)) {
			// if the event already exists, append the actions to the respective
			// index
			int index = eventList.indexOf(eventIndex);
			ArrayList<Integer> list = new ArrayList<>();
			list = actionList.get(index);
			actionList.remove(index);
			list.addAll(actionsForOneEvent);
			actionList.add(index, list);
			log.info("" + eventIndex + spritePanel.getSelectedEvent() + spritePanel.getSelectedAction() + "\n");
		} else {
			// if the event does not exist, add the eventIndex as well as the
			// actions into a new record in their resp. list
			actionList.add(actionsForOneEvent);
			eventList.add(spritePanel.getSelectedEvent());
		}
	}
}
