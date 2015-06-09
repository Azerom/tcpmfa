package fr.tcpmfa;


import fr.tcpmfa.engine.Game;
import fr.tcpmfa.dataBase.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world !");
		
//		new Launcher(null);
		
		Game game = new Game(15, 20);
		DBTDConnexion bdd = new DBTDConnexion();
		
		for(int i = 0; i < 10; i++){
			game.turn();
		}
	}
	
	public static void launch(){

	}
	
	public static void launch(int idSave){
		
	}

}
