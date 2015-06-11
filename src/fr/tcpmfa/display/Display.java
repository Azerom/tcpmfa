package fr.tcpmfa.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.tcpmfa.util.Coordinate;

public class Display extends JFrame {

	    
	private static final long serialVersionUID = -9188791268601682170L;
	private BufferedImage image;
	private MapPanel panel;
	
	private ArrayList<GraphicalElement> elements;
	
	public Display(String titre, ArrayList<GraphicalElement> elements){
		super(titre);
		this.setSize(900, 900);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.panel = new MapPanel();
		this.panel.setSize(new Dimension(700, 900));
		JPanel p2 = new JPanel();
		p2.setSize(200, 900);
		
		this.add(this.panel);
		this.add(p2);
		this.setBackground(Color.black);
		this.elements = elements;
		this.setVisible(true);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Coordinate coord = new Coordinate(arg0.getX(), arg0.getY());
				System.out.println(arg0);
				for(GraphicalElement e : elements){

					int tX = e.getCoord().getX();
					int tY = e.getCoord().getY();
					
					int eX = arg0.getX();
					int eY = arg0.getY();
					
					int dX = Math.abs(eX - tX);
					int dY = Math.abs(eY - tY);

					if((dX <= 30) && 
							(dY <= 30)){
						
							e.setImage("Images/FortiGuard.png");

						
					}
					break;
				}
			}
		});
	}
	public void afficher() {
		this.empty();
		this.drawAllGraphicalElement();
		this.panel.setImage(image);
		this.panel.repaint();
	}
	
	/**
	 * Empty the buffered image
	 */
	private void empty() {
		this.image = new BufferedImage(this.panel.getWidth(), this.panel.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = this.image.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public void drawGraphicalElement(final GraphicalElement gElement, final Graphics g) {
		int xP = calcX(gElement.getCoord().getX()) - gElement.getImage().getWidth()/2;
		int yP = calcY(gElement.getCoord().getY()) - gElement.getImage().getHeight()/2;
		g.drawImage(gElement.getImage(), xP, yP, null);
		
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
	
	private int calcX(float x){
		return (int)Math.ceil(this.panel.getWidth()*(x/1000));
		
	}
	
	private int calcY(float y){
		return (int)Math.ceil(this.panel.getWidth()*(y/1000));
	}
	
}

