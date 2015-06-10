package fr.tcpmfa.display;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MapPanel extends JPanel{
 
	private static final long serialVersionUID = 3829369919316966211L;
	private Image image;

	public void setImage(final Image image) {
		this.image = image;
	}

	public Image getImage() {
		return this.image;
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}

}