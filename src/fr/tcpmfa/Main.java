package fr.tcpmfa;


import fr.tcpmfa.engine.CheckPoint;
import fr.tcpmfa.engine.Ennemy;
import fr.tcpmfa.engine.Game;
import fr.tcpmfa.engine.Point;
import fr.tcpmfa.util.Coordinate;
import fr.tcpmfa.util.Direction;
import fr.tcpmfa.dataBase.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world !");
		
//		new Launcher(null);
		//Test code : remove ASAP !
		//------------------------
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
