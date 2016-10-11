/**
 * 
 */
package com.p532.test.actions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.p532.actions.Collision_Bottom;
import com.p532.actions.Collision_Left;
import com.p532.actions.Collision_Right;
import com.p532.actions.Collision_Top;
import com.p532.model.Sprite;

/**
 * @author arpitkhandelwal
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CollisionTest {

	@Mock
	Sprite sprite;
	Collision_Bottom collision_Bottom;
	Collision_Left collision_Left;
	Collision_Right collision_Right;
	Collision_Top collision_Top;

	public void setUp() {
		// MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {

		Mockito.when(sprite.getPosX()).thenReturn(100);
		Mockito.when(sprite.getPosY()).thenReturn(200);
		collision_Bottom = new Collision_Bottom(sprite, 0);
		collision_Left = new Collision_Left(sprite, 0);
		collision_Right = new Collision_Right(sprite, 0);
		collision_Top = new Collision_Top(sprite, 0);
		

	}

}
