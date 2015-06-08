package fr.tcpmfa.laucher;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
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
				
				JDialog loadAsk = new JDialog();
				loadAsk.setTitle("Save loading");
				
				loadAsk.setSize(new Dimension(220, 25));
				
				JLabel label = new JLabel("Save ID : ");
				JFormattedTextField champ = new JFormattedTextField(NumberFormat.getIntegerInstance());
				champ.setPreferredSize(new Dimension(100, 25));
				loadAsk.setLayout(new BoxLayout(loadAsk, BoxLayout.LINE_AXIS));

				loadAsk.add(label);
				loadAsk.add(champ);
				
				loadAsk.setVisible(true);
				
				setVisible(false);
				
			}
		});
		
		this.add(launchBouton);
		this.add(loadButton);
	}
	

}
