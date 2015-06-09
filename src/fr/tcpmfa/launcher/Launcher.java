package fr.tcpmfa.launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.tcpmfa.Main;



public class Launcher extends JDialog {

	private static final long serialVersionUID = 1L;

	  public Launcher(JFrame parent, String title, boolean modal){

			//On appelle le constructer de JDialog correspondant, on lui spécifie une taille, la position, la boite n'est pas redimensionnable, on affiche ensuite
			super(parent, title, modal);
			this.setSize(800, 500);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			
			this.initComponant();
			
			this.setVisible(true);
	  }
	  
	  private void initComponant(){
			
		  //Welcome
		  JPanel panWel = new JPanel();
		  panWel.setBorder(BorderFactory.createTitledBorder("Bienvenue"));
		  
		  JLabel welcMessage = new JLabel("Bonjour et bienvenue sur TCPMFA, veuillez parametrer votre jeu et commencer la partie ou charger une partie.");
		  
		  panWel.add(welcMessage);
		  //
		  
		  
		  //Settings
		  JPanel panSet = new JPanel();
		  panSet.setBackground(Color.RED);
		  panSet.setPreferredSize(new Dimension(200, 20));
		  panSet.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		  
		  JButton settingTest = new JButton("BoutonTest");
		  settingTest.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
					System.out.println("Chargement de la partie en cours...");
				}
			});
		  	//Quelques presets
		  	JPanel panSetPseudo = new JPanel();
		  	JTextField pseudo = new JTextField();
		    pseudo.setPreferredSize(new Dimension(100, 25));
		    JLabel pseudoLabel = new JLabel("Pseudo :");
		    panSetPseudo.add(pseudoLabel);
		    panSetPseudo.add(pseudo);
		  	//
		  	panSet.add(panSetPseudo);
		  	
		  	
		  panSet.add(settingTest);
		  //
		  
		  
		  //New-LoadGame
		  JPanel panNLG = new JPanel();
		  panNLG.setBorder(BorderFactory.createTitledBorder("Jeu"));
		  
		  JButton newGameButton = new JButton("Nouvelle Partie");
		  newGameButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  System.out.println("Nouvelle Partie Commencée");
				  Main.launch();
			  }
		  });
		  
		  JButton loadGameButton = new JButton("Charger une partie");
		  loadGameButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  System.out.println("Chargement de la partie");
				  int idSave = Integer.parseInt(JOptionPane.showInputDialog(null, "Veuillez entrer le numéro de votre sauvegarde :", "Chargement de la partie", JOptionPane.QUESTION_MESSAGE));
				  System.out.println(idSave);
				  Main.launch(idSave);
			  }
		  });
		  
		  panNLG.add(newGameButton);
		  panNLG.add(loadGameButton);
		  //
		  
		  
  
		  //content
		  JPanel content = new JPanel();
		  content.setBackground(Color.YELLOW);
		  content.add(panWel);
		  content.add(panSet);
		  this.add(content);
		  
		  this.getContentPane().add(panWel, BorderLayout.NORTH);
		  this.getContentPane().add(panSet, BorderLayout.CENTER);
		  this.getContentPane().add(panNLG, BorderLayout.SOUTH);
		  //
	  }
}
