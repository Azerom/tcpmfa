package fr.tcpmfa.laucher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ValidationPanel extends JPanel {
	
	public ValidationPanel (){
		super();
		
		JButton launchBouton = new JButton("Launch");

		launchBouton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {        
				System.out.println("Lanchement ! Achtung !");
				setVisible(false);

			}  

		});
		
		
		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Chargement de partie");
				setVisible(false);
			}
		});
	}

}
