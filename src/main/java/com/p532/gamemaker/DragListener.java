package com.p532.gamemaker;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import com.p532.model.Sprite;

public class DragListener extends MouseInputAdapter {
	private Cursor cursor;
	private Point location;
	private MouseEvent pressed;
	private Sprite sprite;
	private int x, y;

	public DragListener(Sprite sprite) {
		super();
		cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
		this.sprite = sprite;
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		Component component = me.getComponent();
		location = component.getLocation(location);
		x = location.x - pressed.getX() + me.getX();
		y = location.y - pressed.getY() + me.getY();
		component.setLocation(x, y);
	}

	@Override
	public void mousePressed(MouseEvent me) {
		pressed = me;
		me.getComponent().setCursor(cursor);
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		Component component = me.getComponent();
		component.setLocation(x, y);
		sprite.setPosX(x);
		sprite.setPosY(y);
	}
}