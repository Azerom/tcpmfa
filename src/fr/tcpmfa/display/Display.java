package fr.tcpmfa.display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.tcpmfa.engine.Tower;
import fr.tcpmfa.util.Coordinate;

public class Display extends JFrame {

	    
	private static final long serialVersionUID = -9188791268601682170L;
	private BufferedImage image;
	private MapPanel panel;
	
	private ArrayList<GraphicalElement> elements;
	private TPanel interfacePanel;
	
	private int idMap;
	
	public Display(String titre, ArrayList<GraphicalElement> elements, int idMap){
		super(titre);
		this.idMap = idMap;
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.panel = new MapPanel();
		this.panel.setSize(new Dimension(800, 600));
		interfacePanel = new TPanel();
		interfacePanel.setSize(200, 600);
		interfacePanel.setPreferredSize(new Dimension(200, 600));
		interfacePanel.add(new JButton("Test"));

		this.add(this.panel, BorderLayout.CENTER);
		this.add(interfacePanel, BorderLayout.WEST);
		
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
				
				for(GraphicalElement e : elements){

					int tX = e.getCoord().getX();
					int tY = e.getCoord().getY();
					
					int eX = arg0.getX()-200;
					int eY = arg0.getY();
					
					int dX = Math.abs(eX - tX);
					int dY = Math.abs(eY - tY);

					if((dX <= 30) && 
							(dY <= 30)){
						

								
								interfacePanel.setGElement(e);
							

						
					}
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
	
	public JFrame getThis(){
		return this;
	}
	
	/**
	 * Empty the buffered image
	 */
	private void empty() {
		this.image = new BufferedImage(this.panel.getWidth(), this.panel.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = this.image.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//Test code

		try {
			g.drawImage(ImageIO.read(new File("Images/Map" + idMap + "F.png")), 0, 0, 800, 600, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		return (int)Math.ceil(this.panel.getWidth()*(x/800));
		
	}
	
	private int calcY(float y){
		return (int)Math.ceil(this.panel.getHeight()*(y/600));
	}
	
}

