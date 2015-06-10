package fr.tcpmfa.display;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Map extends JFrame {


	private Image image;
	public Image getImage(){
		return image;
	}
	public void setImage(Image Image){
		this.image = Image;
	}
	public void addGrahicalElement(GraphicalElement Element1){

	}
	public Map(){
		this.setTitle("Tower Defense TCPMFA");
		this.setSize(900, 600);
		 JPanel map = new JPanel();
		 JLabel image = new JLabel( new ImageIcon("Images/Map1.png"));
		 map.setLayout(new BorderLayout());
		 map.add(image);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		}
	}

