package fr.tcpmfa.display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.tcpmfa.util.Coordinate;

public class TPanel extends JPanel {

	private GraphicalElement gElement;
	/**
	 * Create the panel.
	 */
	public TPanel() {
		gElement = new GraphicalElement() {

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
				BufferedImage image;
				try {                
					image =  ImageIO.read(new File("Images/e1.png"));
					return image;
				} catch (IOException ex) {
					// handle exception...
				}
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

		if(this.gElement.getPossibleAction() != null){
			for(String action : this.gElement.getPossibleAction()){
				JLabel lblNewLabel = new JLabel(action);
				add(lblNewLabel);
			}
		}



	}
	
	public void setGElement(GraphicalElement gElement){
		this.gElement = gElement;
		this.removeAll();
		if(this.gElement.getPossibleAction() != null){
			for(String action : this.gElement.getPossibleAction()){
				JButton button = new JButton(action);
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						gElement.reactToAction(action);
						setGElement(gElement);
						
					}
				});
				add(button);
			}
		}
		this.revalidate();
		this.repaint();
	}

}
