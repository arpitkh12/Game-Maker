package com.p532.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.p532.commands.CommandLogic;
import com.p532.view.GameDock;
import com.p532.view.GameDock.Actions;

public class ListenerSaveLoadButtons implements ActionListener {

	private JFileChooser fc = new JFileChooser();
	private final GameDock gameDock;
	private Logger log = Logger.getLogger(ListenerSaveLoadButtons.class);
	private CommandLogic logic = new CommandLogic();
	private int returnvalue;
	private String test;

	public ListenerSaveLoadButtons(GameDock gameDock) {
		this.gameDock = gameDock;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == Actions.LOAD.name()) {
			if (e.getSource() == gameDock.btnLoad) {
				log.info("inside btnLoad");
				returnvalue = fc.showOpenDialog(gameDock);
				if (returnvalue == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					try {
						logic.load(f);
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				}
			}

		}
		if (e.getActionCommand() == Actions.SAVE.name()) {
			test = JOptionPane.showInputDialog("Save as:");
			try {
				logic.getComp(test);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

}
