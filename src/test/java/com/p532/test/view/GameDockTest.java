package com.p532.test.view;

import static org.mockito.Mockito.mock;

import javax.swing.JPanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.p532.view.BackgroundPanel;
import com.p532.view.GameDock;
import com.p532.view.SpritePanel;

public class GameDockTest {
	
	private JPanel buttonPanel;
	private BackgroundPanel bpanel;
	private SpritePanel spritePanel;
	private GameDock gameDock;
	
	@Before
	public void setUp(){
		bpanel = new BackgroundPanel();
		spritePanel = new SpritePanel();
		gameDock = new GameDock(spritePanel,bpanel);
	}
	
	
	@Test
	public void initTest(){
		GameDock gameDock = mock(GameDock.class);
		Assert.assertEquals(0, gameDock.init());
	}
	
	
	
}
