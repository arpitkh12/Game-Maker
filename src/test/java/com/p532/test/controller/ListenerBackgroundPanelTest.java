package com.p532.test.controller;

import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.p532.controller.ListenerBackgroundPanel;
import com.p532.view.BackgroundPanel;
import com.p532.view.GameArena;

public class ListenerBackgroundPanelTest {

	private BackgroundPanel backgroundPanel;
	private ActionEvent e;
	private GameArena gameArena = GameArena.getInstance();
	private ListenerBackgroundPanel listenerBackgroundPanel;

	@Test
	public void actionPerformedTest() {
		when(e.getActionCommand()).thenReturn("Add background");
		listenerBackgroundPanel.actionPerformed(e);

	}

	@Before
	public void setUp() throws Exception {
		backgroundPanel = new BackgroundPanel();
		listenerBackgroundPanel = new ListenerBackgroundPanel(backgroundPanel);
		e = Mockito.mock(ActionEvent.class);

	}

}
