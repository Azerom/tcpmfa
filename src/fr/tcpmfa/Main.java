package fr.tcpmfa;


import javax.swing.JComboBox;
import javax.swing.JTextField;

import fr.tcpmfa.engine.Game;
import fr.tcpmfa.launcher.Launcher;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world !");
		
		new Launcher(null, "Launcher", true);
		//Test code : remove ASAP !
		//------------------------
		Game game = new Game(15, 15, 15);

		for(int i = 0; i < 100; i++){
			game.turn();
			
		}
	}
	
	public static void launch(JTextField pseudo, JComboBox<String> HP, JComboBox<String> Ressources ,JComboBox<String> id_Map){
		System.out.println("======== ENTREE LAUNCH ==========");
		System.out.println("Pseudo : "+pseudo+"\nNombre de Points de vie : "+HP+"\nRessources :"+Ressources+"\nN°Map : "+id_Map);

	}
	
	public static void launch(int idSave){
		System.out.println(idSave);
	}

}


//public Game(int hp, int ressource, int id_Map){