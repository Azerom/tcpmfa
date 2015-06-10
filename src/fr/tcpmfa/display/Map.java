package fr.tcpmfa.display;

import java.awt.Image;

import javax.swing.JFrame;

public class Map extends JFrame {


	private Image Image;
	public Image getImage(){
		return Image;
	}
	public void setImage(Image Image){
		this.Image = Image;
	}
	public void addGrahicalElement(GraphicalElement Element1){

	}
	public Map(){
		this.setTitle("Animation");
		this.setSize(800, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		}
	}

