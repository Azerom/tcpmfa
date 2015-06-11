package fr.tcpmfa.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class InterfacePanel extends JPanel{
	
	private BufferedImage image;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		 g.setColor(Color.BLACK);
		g.drawRect(0, 0, this.getWidth(), this.getHeight());          
	}
}
