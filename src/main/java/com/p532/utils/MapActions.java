package com.p532.utils;

import static com.p532.constants.Constants.ACTIONS;

import com.p532.actions.BlowAndDivide;
import com.p532.actions.BlowUp;
import com.p532.actions.Collision_Bottom;
import com.p532.actions.Collision_Left;
import com.p532.actions.Collision_Right;
import com.p532.actions.Collision_Top;
import com.p532.actions.Jump;
import com.p532.actions.MoveCross;
import com.p532.actions.MoveHorizontal;
import com.p532.actions.MoveVertical;
import com.p532.actions.Projectile;
import com.p532.actions.Reflect;
import com.p532.actions.RevealBlockType;
import com.p532.actions.Rotate;
import com.p532.model.Sprite;

@SuppressWarnings("unused")
public class MapActions {
	String[] actions = ACTIONS;
	private BlowUp blowUp;
	private MoveCross moveCross;
	private MoveHorizontal moveHorizontal;
	private MoveVertical moveVertical;
	private Rotate rotate;
	private Jump jump;
	private Projectile projectile;
	private BlowAndDivide blowAndDivide;
	private RevealBlockType revealBlockType;
	private Collision_Top collisionTop;
	private Collision_Bottom collisionBottom;
	private Collision_Left collisionLeft;
	private Collision_Right collisionRight;
	private Reflect reflect;

	public void findAction(int actionIndex, Sprite observer, Object t) {
		String action = actions[actionIndex];
		find(action, observer, t);
	}

	public void find(String action, Sprite observer, Object t) {
		switch (action) {
		case "Move Cross":
			moveCross = new MoveCross(observer, t);
			break;
		case "Move Horizontal":
			moveHorizontal = new MoveHorizontal(observer, t);
			break;
		case "Move Vertical":
			moveVertical = new MoveVertical(observer, t);
			break;
		case "Blow Up":
			blowUp = new BlowUp(observer, t);
			break;
		case "Shoot":
			projectile = new Projectile(observer, t);
			break;
		case "Rotate":
			rotate = new Rotate(observer, t);
			break;
		case "Jump":
			jump = new Jump(observer, t);
			break;
		case "Blow and Divide":
			blowAndDivide = new BlowAndDivide(observer, t);
			break;
		case "Reveal Block Type":
			revealBlockType = new RevealBlockType(observer, t);
			break;
		case "Collision Top":
			collisionTop = new Collision_Top(observer, t);
			break;
		case "Collision Bottom":
			collisionBottom = new Collision_Bottom(observer, t);
			break;
		case "Collision Left":
			collisionLeft = new Collision_Left(observer, t);
			break;
		case "Collision Right":
			collisionRight = new Collision_Right(observer, t);
			break;
		case "Reflect":
			reflect = new Reflect(observer, t);
			break;

		}
	}
}
