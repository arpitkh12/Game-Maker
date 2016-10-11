/**
 * 
 */
package com.p532.test.controller;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import com.p532.controller.PlayGame;

/**
 * @author arpitkhandelwal
 *
 */
public class PlayGameTest {

	private PlayGame playGame;

	@Before
	public void setUp() {
		playGame = mock(PlayGame.class);
		playGame.startGame();
	}

	@Test
	public void test() {
	}

}
