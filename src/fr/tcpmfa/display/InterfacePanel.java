package fr.tcpmfa.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.tcpmfa.engine.Tower;

public class InterfacePanel extends JPanel{
	
	private BufferedImage image;
	private Tower tower = null;
	
	public InterfacePanel(){
		  JPanel pan = new JPanel();
		  pan.setBorder(BorderFactory.createTitledBorder("Tower"));
		  
		  JLabel level = new JLabel("");
		  JLabel icon = new JLabel(new ImageIcon("Images/TowerIcon1.png"));
		  
		  pan.add(icon);
		  pan.add(level);
		  
	}
	
	public void setTower(Tower tower){
		this.tower = tower;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		 g.setColor(Color.BLACK);
		g.drawRect(0, 0, this.getWidth(), this.getHeight());          
	}
}
