/**
 * 
 */
package com.p532.test.actions;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.p532.actions.Projectile;
import com.p532.model.Sprite;
import com.p532.view.GameArena;

/**
 * @author arpitkhandelwal
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectileTest {
	
    
	@Mock
	Sprite sprite;
	Projectile projectile;

	public void setUp() {
		// MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		
		Mockito.when(sprite.getPosX()).thenReturn(100);
		Mockito.when(sprite.getPosY()).thenReturn(200);
		projectile = new Projectile(sprite, 0);
		projectile.init(sprite, 0);
		// Field field = ReflectionUtils.findField(Projectile.class,
		// "gameArena");
		try {
			Class<Projectile> person = (Class<Projectile>) Class.forName("com.p532.actions.Projectile");
			Field field = projectile.getClass().getDeclaredField("gameArena");
			GameArena obj = (GameArena) field.get(projectile);
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
