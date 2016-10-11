package com.p532.controller;

import static com.p532.constants.Constants.SOUNDS;

import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class PlaySound implements Runnable {
	private static AudioStream audioStream;
	private static String[] sounds = SOUNDS;

	public static AudioStream getAudioStream() {
		return audioStream;
	}

	private int soundIndex;

	public PlaySound(int soundIndex) {
		this.soundIndex = soundIndex;
	}

	public void playSound() {

		try {
			InputStream inputSound = this.getClass().getClassLoader()
					.getResourceAsStream((sounds[soundIndex] + ".wav"));
			audioStream = new AudioStream(inputSound);
			AudioPlayer.player.start(audioStream);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void run() {
		playSound();

	}
}
