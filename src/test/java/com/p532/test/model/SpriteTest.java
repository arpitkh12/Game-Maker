package com.p532.test.model;

import static com.p532.constants.Constants.BALL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.junit.Test;

import com.p532.model.Sprite;

public class SpriteTest {

	@Test
	public void test() {
		ArrayList<Integer> eventList = new ArrayList<>();
		eventList.add(1);
		ArrayList<ArrayList<Integer>> actionList = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		actionList.add(list);
		Sprite newSprite = new Sprite(BALL, eventList, actionList, 0);
		ImageIcon obj = new ImageIcon(BALL);
		ImageIcon obj2 = (ImageIcon) newSprite.getLblSprite().getIcon();
		assertNotNull(obj);
		assertNotNull(obj2);
		assertEquals(obj.getImage(), obj2.getImage());
		assertNotNull(newSprite.getBounds(newSprite));
	}

}
