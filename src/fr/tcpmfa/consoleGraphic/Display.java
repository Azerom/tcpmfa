package fr.tcpmfa.consoleGraphic;

import java.util.ArrayList;


public class Display {
	
	
	private char[][] liste;
	private ArrayList<GraphicalElement> elements;
	
	public Display(){
		elements = new ArrayList<GraphicalElement>();
		liste = new char[50][50];
		emptyListe();
	}
	
	public void addGraphicalElement(GraphicalElement element){
		elements.add(element);
		
	}
	
	public void display(){
		renew();
		for(int i = 0; i < liste.length; i++){
			for(int j = 0; j < liste[i].length; j++){
				System.out.print(liste[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	private void renew(){
		emptyListe();
		for(GraphicalElement e : elements){
			liste[e.getCoord().getY()][e.getCoord().getX()] =  e.getImage();
		}
	}
	
	private void emptyListe(){
		for(int i = 0; i < liste.length; i++){
			for(int j = 0; j < liste[i].length; j++){
				liste[i][j] = ' ';
			}
		}
	}
}
