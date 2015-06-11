package fr.tcpmfa.launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
		  JLabel icon = new JLabel(new ImageIcon("Images/TowerIcon1.png"));
		  JLabel icon1 = new JLabel(new ImageIcon("Images/TowerIcon1.png"));
		  
		  panWel.add(icon);
		  panWel.add(welcMessage);
		  panWel.add(icon1);
		  //
		  
		  //========
		  //Settings
		  //========
		  JPanel panSet = new JPanel();
		  panSet.setPreferredSize(new Dimension(200, 20));
		  panSet.setBorder(BorderFactory.createTitledBorder("Settings"));
		  //Settings - Pseudo
		  	JPanel panSetPseudo = new JPanel();
		  	JTextField pseudo = new JTextField();
		    pseudo.setPreferredSize(new Dimension(300, 25));
		    panSetPseudo.setBorder(BorderFactory.createTitledBorder("Entrez votre pseudo :"));
		    panSetPseudo.add(pseudo);
		  //
		  	panSet.add(panSetPseudo);
			  //Settings - ChoixMap
		  	JPanel panSetMap = new JPanel();
		  	panSetMap.setPreferredSize(new Dimension(300, 60));
		  	panSetMap.setBorder(BorderFactory.createTitledBorder("Choix de la Map"));
		  	JComboBox<Integer> id_Map = new JComboBox<Integer>();
		  	id_Map.addItem(1);
		  	id_Map.addItem(2);
		  	id_Map.addItem(3);
		  	JLabel mapLabel = new JLabel("Map : ");
		  	//Voir Map TEST
		  	JOptionPane seeMapPopUp = new JOptionPane();
		  	JButton seeMapButton = new JButton("Voir Cartes");
		  	seeMapButton.addActionListener(new ActionListener(){
		  		public void actionPerformed(ActionEvent argo0) {

		  		}
		  	});

//		    okBouton.addActionListener(new ActionListener(){
//		        public void actionPerformed(ActionEvent arg0) {        
//		          zInfo = new ZDialogInfo(nom.getText(), (String)sexe.getSelectedItem(), getAge(), (String)cheveux.getSelectedItem() ,getTaille());
//		          setVisible(false);
//		        }
//===========================================================================================================================
//		  	
//		  	ZDialog zd = new ZDialog(null, "Coucou les ZérOs", true);
//	        ZDialogInfo zInfo = zd.showZDialog(); 
//	        JOptionPane jop = new JOptionPane();
//	        jop.showMessageDialog(null, zInfo.toString(), "Informations personnage", JOptionPane.INFORMATION_MESSAGE);
//===========================================================================================================================
//			  JButton newGameButton = new JButton("Nouvelle Partie");
//			  newGameButton.addActionListener(new ActionListener(){
//				  public void actionPerformed(ActionEvent arg0) {
//					  
//					  System.out.println("Pseudo : "+pseudo.getText()+"\nNombre de Points de vie : "+HP.getSelectedItem()+"\nRessources : "+Ressources.getSelectedItem()+"\nN°Map :"+id_Map.getSelectedItem());
//					  Main.launch(pseudo.getText(), (int)HP.getSelectedItem(), (int)Ressources.getSelectedItem(), (int)id_Map.getSelectedItem());
//					  setVisible(false);
//					  dispose();
//				  }
//			  });

		  	panSetMap.add(mapLabel);
		  	panSetMap.add(id_Map);
		  	panSetMap.add(seeMapButton); 
		  //
		  	panSet.add(panSetMap);
		  //Settings - Option HP
		  	JPanel panSetHP = new JPanel();
		  	panSetHP.setPreferredSize(new Dimension(300, 60));
		  	panSetHP.setBorder(BorderFactory.createTitledBorder("Nombre de points de vie :"));
		  	JComboBox<Integer> HP = new JComboBox<Integer>();
		  	HP.addItem(10);
		  	HP.addItem(15);
		  	HP.addItem(20);
		  	HP.addItem(25);
		  	HP.addItem(30);
		  	HP.addItem(35);
		  	HP.addItem(40);
		  	HP.addItem(45);
		  	HP.addItem(50);
		  	JLabel HPLabel = new JLabel("Points de vie : ");
		  	
		  	panSetHP.add(HPLabel);
		  	panSetHP.add(HP);
		  //
		  	panSet.add(panSetHP);
		  //Settings - Ressources
		  	JPanel panSetRessources = new JPanel();
		  	panSetRessources.setPreferredSize(new Dimension(300, 60));
		  	panSetRessources.setBorder(BorderFactory.createTitledBorder("Nombre de points de ressources :"));
		  	JComboBox<Integer> Ressources = new JComboBox<Integer>();
		  	Ressources.addItem(10);
		  	Ressources.addItem(15);
		  	Ressources.addItem(20);
		  	Ressources.addItem(25);
		  	Ressources.addItem(30);
		  	Ressources.addItem(35);
		  	Ressources.addItem(40);
		  	Ressources.addItem(45);
		  	Ressources.addItem(50);
		  	JLabel ressourcesLabel = new JLabel("Ressources : ");
		  	
		  	panSetRessources.add(ressourcesLabel);
		  	panSetRessources.add(Ressources);
		  //
		  	panSet.add(panSetRessources);


		  //============================FIN SETTINGS=========================================================
		  	
		  	
		  //New-LoadGame
		  JPanel panNLG = new JPanel();
		  panNLG.setBorder(BorderFactory.createTitledBorder("Jeu"));
		  
		  JButton newGameButton = new JButton("Nouvelle Partie");
		  newGameButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  
				  System.out.println("Pseudo : "+pseudo.getText()+"\nNombre de Points de vie : "+HP.getSelectedItem()+"\nRessources : "+Ressources.getSelectedItem()+"\nN°Map :"+id_Map.getSelectedItem());
				  Main.launch(pseudo.getText(), (int)HP.getSelectedItem(), (int)Ressources.getSelectedItem(), (int)id_Map.getSelectedItem());
				  setVisible(false);
				  dispose();
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



////Debug ===================================================================================================================================================
//JPanel panDebug = new JPanel();
//panWel.setBorder(BorderFactory.createTitledBorder("Debug (A effacer par la suite)"));
//
//JButton startTemps = new JButton("Démarrage du temps");
//startTemps.addActionListener(new ActionListener(){
//	  public void actionPerformed(ActionEvent arg0) {
//			System.out.println("Démarrage du temps en cours ..");
//			runTimeStart();
//			
//		}
//	});
//JButton endTemps = new JButton("Fin du temps");
//endTemps.addActionListener(new ActionListener(){
//	  public void actionPerformed(ActionEvent arg0) {
//			System.out.println("Fin du temps en cours ..");
//			runTimeEnd();
//		}
//	});
//JButton affichageTemps = new JButton("Affichage du temps");
//affichageTemps.addActionListener(new ActionListener(){
//	  public void actionPerformed(ActionEvent arg0) {
//			System.out.println("Affichage du temps en cours...");
//			runTimeDisplay();
//		}
//	});
//	
//panDebug.add(startTemps);
//panDebug.add(endTemps);
//panDebug.add(affichageTemps);
////==============================================================================================================================================================
