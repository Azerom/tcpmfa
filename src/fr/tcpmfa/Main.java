package fr.tcpmfa;


import fr.tcpmfa.engine.Game;
import fr.tcpmfa.engine.WaveEnnemy;
import fr.tcpmfa.launcher.Launcher;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world !");
		
		new Launcher(null, "Launcher", true);
		

	}
	
	public static void launch(String pseudo, int HP, int ressources ,int id_Map){
		System.out.println("======== ENTREE LAUNCH ==========");
		System.out.println("Pseudo : "+pseudo+"\nNombre de Points de vie : "+HP+"\nRessources :"+ressources+"\nN°Map : "+id_Map);

		new Thread(){
			public void run(){
				Game game = new Game(HP, ressources, id_Map);

				System.out.println("Test");
				while(true){
					game.turn();
					
				}
			}
		}.start();


	}
	
	public static void launch(){
		
		launch("inconnu", 15, 15, 1);

	}
	
	public static void launch(int idSave){
		System.out.println(idSave);
	}

}


//public Game(int hp, int ressource, int id_Map){
