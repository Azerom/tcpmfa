package fr.tcpmfa.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.tcpmfa.engine.Tower;
import fr.tcpmfa.util.Coordinate;

public class InterfacePanel extends JPanel{

	private BufferedImage image;
	private GraphicalElement gElement;

	public InterfacePanel(){

		this.gElement = new GraphicalElement() {
			
			@Override
			public void setImage(String image) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setCoord(Coordinate Coordinates) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public BufferedImage getImage() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Coordinate getCoord() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ArrayList<String> getPossibleAction() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void reactToAction(String action) {
				// TODO Auto-generated method stub
				
			}
		};
		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory.createTitledBorder("Tower"));

		JLabel level = new JLabel("");
		JLabel icon = new JLabel(new ImageIcon("Images/TowerIcon1.png"));

		pan.add(icon);
		pan.add(level);

	}

	public void setGElement(GraphicalElement gElement){
		this.gElement = gElement;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, this.getWidth(), this.getHeight());          
	}
}
