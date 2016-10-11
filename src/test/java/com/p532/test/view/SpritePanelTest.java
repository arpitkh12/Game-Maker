package com.p532.test.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.p532.view.SpritePanel;

public class SpritePanelTest {

	private SpritePanel spritePanel;
	
	@Before
	public void setUp(){	
		spritePanel = new SpritePanel();
	}
	
	@Test
	public void initTest(){
		Assert.assertEquals(0, spritePanel.init());
	}
	
	
}
