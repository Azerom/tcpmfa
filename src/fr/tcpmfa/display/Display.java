package fr.tcpmfa.display;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JFrame {

	    
	private Image image;
	;
	public Image getImage(){
		return image;
	}
	public void setImage(Image Image){
		this.image = Image;
	}
	public void addGrahicalElement(GraphicalElement Element1){

	}
	public Display(){
		this.setTitle("Tower Defense TCPMFA");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JPanel menuPanel = new JPanel();
		JPanel mapPanel = new JPanel();
		JPanel interfacePanel = new JPanel();
		
		
		this.setVisible(true);
		}
	}

