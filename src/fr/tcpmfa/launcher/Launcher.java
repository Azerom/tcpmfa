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



public class Launcher extends JDialog {

	private static final long serialVersionUID = 1L;

	  public Launcher(JFrame parent, String title, boolean modal){

			//On appelle le constructer de JDialog correspondant, on lui sp�cifie une taille, la position, la boite n'est pas redimensionnable, on affiche ensuite
			super(parent, title, modal);
			this.setSize(800, 500);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			
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
			  
		  panSet.add(settingTest);
		  //
		  
		  
		  //New-LoadGame
		  JPanel panNLG = new JPanel();
		  panNLG.setBorder(BorderFactory.createTitledBorder("Jeu"));
		  
		  JButton newGameButton = new JButton("Nouvelle Partie");
		  newGameButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  System.out.println("Nouvelle Partie Commenc�e");
			  }
		  });
		  
		  JButton loadGameButton = new JButton("Charger une partie");
		  loadGameButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  System.out.println("Chargement de la partie");
				  int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Veuillez entrer le num�ro de votre sauvegarde :", "Chargement de la partie", JOptionPane.QUESTION_MESSAGE));
				  System.out.println(id);
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