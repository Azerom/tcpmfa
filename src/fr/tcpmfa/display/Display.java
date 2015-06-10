package fr.tcpmfa.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Display extends JFrame {

	    
	private static final long serialVersionUID = -9188791268601682170L;
	private BufferedImage image;
	private MapPanel panel;
	
	private ArrayList<GraphicalElement> elements;
	
	public Display(String titre, ArrayList<GraphicalElement> elements){
		super(titre);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.panel = new MapPanel();
		this.setContentPane(this.panel);
		this.setBackground(Color.black);
		this.elements = elements;
		this.setVisible(true);
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {

				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void afficher() {
		this.empty();
		this.drawAllGraphicalElement();
		this.panel.setImage(image);
		this.panel.repaint();
	}
	
	private void empty() {
		this.image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = this.image.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public void drawGraphicalElement(final GraphicalElement gElement, final Graphics g) {
		int xP = gElement.getCoord().getX() - 15;
		int yP = gElement.getCoord().getY() - 15;
		g.drawImage(gElement.getImage(), xP, yP, 30, 30,  null);
		
//		g.setColor(Color.red);
//		g.fillRect(xP, yP - 10, 30, 5);
//		
//		g.setColor(Color.green);
//		g.fillRect(xP, yP - 10, Math.round(arg0), height);
	}

	public void drawAllGraphicalElement() {
		Graphics g = this.image.getGraphics();
		for (GraphicalElement gElement : elements) {
			this.drawGraphicalElement(gElement, g);
		}
	}
	
//	private int calcX(float x){
//		return (int)Math.ceil(this.getContentPane().getWidth()*(x/this.map.getWidth()));
//		
//	}
//	
//	private int calcY(float y){
//		return (int)Math.ceil(this.getContentPane().getWidth()*(y/this.map.getHeight()));
//	}
	
}

