package com.p532.test.controller;

import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Test;

import com.p532.controller.GameMakerContoller;

public class GameMakerControllerTest {
	
	private GameMakerContoller gameMakerController;
	
	public void setUp(){
		GameMakerContoller gameMakerController =  new GameMakerContoller();
	}
	
	@Test
	public void test() {
		gameMakerController = mock(GameMakerContoller.class);
		Assert.assertEquals(0, gameMakerController.init());

}
}
