package fr.tcpmfa.display;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapPanel extends JPanel{
	
 private Image background;

public void Background(){
	if (ID_map = 1){
			JLabel image = new JLabel( new ImageIcon("Images/Map1F.png"));
	}
	else {
	if (ID_map = 2){
		JLabel image = new JLabel( new ImageIcon("Images/Map2F.png"));
	else {
		JLabel image1 = new JLabel( new ImageIcon("Images/Map3F.png"));
			}
	}
	}
	
}
}
/*
 **Affiche MAP 1 quand ID_map = 1
 **Affiche MAP 2 quand ID_map = 2
 **Affiche MAP 3 quand ID_map = 3
 */
