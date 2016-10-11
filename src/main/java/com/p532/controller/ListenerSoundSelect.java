package com.p532.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JComboBox;

import com.p532.view.SpritePanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class ListenerSoundSelect implements ActionListener {
	private AudioStream audioStream;

	public ListenerSoundSelect(SpritePanel spritePanel) {
		spritePanel.addSoundListeners(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cbSound = (JComboBox) e.getSource();
		try {
			InputStream inputSound = this.getClass().getClassLoader()
					.getResourceAsStream(cbSound.getSelectedItem().toString().toLowerCase() + ".wav");
			audioStream = new AudioStream(inputSound);
			AudioPlayer.player.start(audioStream);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
