/**
 * 
 */
package com.p532.test.actions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.p532.actions.MoveVertical;
import com.p532.model.Sprite;

/**
 * @author arpitkhandelwal
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MoveHorizontalTest {

	@Mock
	Sprite sprite;
	MoveVertical projectile;

	public void setUp() {
		// MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {

		Mockito.when(sprite.getPosX()).thenReturn(100);
		Mockito.when(sprite.getPosY()).thenReturn(200);
		projectile = new MoveVertical(sprite, 0);

	}

}
