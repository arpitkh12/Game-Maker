//package com.p532.test.controller;
//
//import static org.mockito.Mockito.when;
//
//import java.awt.event.ActionEvent;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import com.p532.controller.ListenerSpritePanel;
//import com.p532.view.GameArena;
//import com.p532.view.SpritePanel;
//
//public class ListenerSpritePanelTest {
//
//	private ActionEvent e;
//	private GameArena gameArena;
//	private ListenerSpritePanel listenerSpritePanel;
//	private SpritePanel spritePanel;
//
//	@Test
//	public void actionPerformedTest() {
//		when(e.getActionCommand()).thenReturn("Add Sprite");
//		listenerSpritePanel.actionPerformed(e);
//	}
//
//	@Before
//	public void setUp() throws Exception {
//		gameArena = new GameArena();
//		spritePanel = new SpritePanel();
//		listenerSpritePanel = new ListenerSpritePanel(spritePanel, gameArena);
//		e = Mockito.mock(ActionEvent.class);
//
//	}
//
//}
