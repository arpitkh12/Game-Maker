package com.p532.test.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import static com.p532.constants.Constants.SKY;
import com.p532.view.BackgroundPanel;

public class BackgroundPanelTest {

	ImageIcon backgroundImage;
	BackgroundPanel backgroundPanel;
	JLabel backgroundPicture;
	ImageIcon icon1;
	ImageIcon icon2;
	ImageIcon testBackgroundImage;

	@Before
	public void setUp() throws Exception {
		backgroundPicture = new JLabel();
		backgroundPanel = new BackgroundPanel();
		backgroundImage = new ImageIcon(SKY);

		backgroundPanel.setBgImage(backgroundImage);
		testBackgroundImage = backgroundPanel.getBgImage();

		icon1 = testBackgroundImage;
		backgroundPicture.setIcon(icon1);
		backgroundPanel.setBackgroundPicture(backgroundPicture);
		icon2 = (ImageIcon) backgroundPanel.getBackgroundPicture().getIcon();

		// do nothing
	}

	@Test
	public void test() {
		assertNotNull(icon1);
		assertNotNull(icon2);
		assertEquals(icon1.getImage(), icon2.getImage());
	}

}
