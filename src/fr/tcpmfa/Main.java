package fr.tcpmfa;


import fr.tcpmfa.dataBase.DBTDConnexion;
import fr.tcpmfa.engine.Game;
import fr.tcpmfa.launcher.Launcher;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world !");
		
		new Launcher(null, "Launcher", true);
		//Test code : remove ASAP !
		//------------------------
		Game game = new Game(15, 20);

		DBTDConnexion bdd = new DBTDConnexion();
		bdd.open();
		bdd.getMap(2);
		bdd.close();
		
		for(int i = 0; i < 100; i++){
			game.turn();
			
		}
	}
	
	public static void launch(){

	}
	
	public static void launch(int idSave){
		System.out.println(idSave);
	}

}
