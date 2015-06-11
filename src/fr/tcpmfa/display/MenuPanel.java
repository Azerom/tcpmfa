package fr.tcpmfa.display;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{

	public MenuPanel(){
		JLabel image = new JLabel( new ImageIcon("Images/Map1F.png"));
		
		this.add(image);
	}
}

/*
* - Temps en direct
* - Nombre de ressources
* - Score en fonction du temps
* - Bouton sauvegarde & quit
*/
