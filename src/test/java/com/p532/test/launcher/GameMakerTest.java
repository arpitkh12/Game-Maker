package com.p532.test.launcher;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.p532.launcher.GameMaker;

public class GameMakerTest {

	@Test
	public void test() {
		GameMaker gameMaker = mock(GameMaker.class);
		assertNotNull(gameMaker);

	}

}
