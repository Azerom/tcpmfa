package fr.tcpmfa.engine;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import fr.tcpmfa.util.Coordinate;

public class Tower extends Element {
	private final int cost;
	private final Type damageType;
	private int level;
	private int range;
	private int cooldown;
	private int countDown;
	private Ennemy focus;
	private static int id_Tower;

	public Tower(int nmdDamage, Type typeDamage, String name, Coordinate coord, Game game,int level,int range,int cost,int cooldown,int id_Tower){
		super(coord, nmdDamage, typeDamage, name, game);
		this.cost = cost;
		this.range=range;
		this.damageType = null;
		this.setImage("Tour_3.png");
		this.level=level;
		this.cooldown=cooldown;
		this.countDown = cooldown;
		this.focus = null;
		this.id_Tower=id_Tower;
	}

	@Override
	public void act() {

		if(countDown == 0){
			if(focus != null){
				if(isAtRange(focus) && focus.isAlive()){
					attack(focus);
				}
				else
					focus = null;
			}
			else{
				for(Ennemy e : game.getActualWave()){
					if(isAtRange(e)){
						focus = e;
					}
				}
			}
			countDown = cooldown;
		}
		else
			countDown--;
	}

	private boolean isAtRange(Ennemy e){
		int eX = e.getCoord().getX();
		int eY = e.getCoord().getY();

		int tX = this.coord.getX();
		int tY = this.coord.getY();

		int dX = Math.abs(eX - tX);
		int dY = Math.abs(eY - tY);

		if((dX <= this.range) && 
				(dY <= this.range)){

			if( ( (dX * dX) + (dY * dY) ) <= (range * range) ){
				return true;
			}

		}

		return false;
	}
	
	public static int getId_Tower(){
		return id_Tower;
	}

	public int getlevel(){
		return level;
	}
	
	public Type getType(){
		return typeDamage;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setType(Type type){
		this.typeDamage = type;
	}
	
	public void levelUp(){
		level++;
	}
	
	@Override
	public BufferedImage getImage(){
		
		

		
		
		BufferedImage image = new BufferedImage(range, range,BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		if( g instanceof Graphics2D ){
			Graphics2D g2d = (Graphics2D) g;
			// make sure the background is filled with transparent pixels when cleared !
			Composite original = g2d.getComposite();
			g2d.setBackground(new Color(0,0,0,0));
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 0.0f));
			g.clearRect(0, 0, image.getWidth(), image.getHeight());
			g2d.setComposite(original);
			}
		g.drawImage(this.image, (range/2)-15, (range/2)-15, 30, 30, null);
		g.setColor(Color.white);
		g.drawString(Integer.toString(level), 20, 20);
		
		
		if(focus != null){
			int eX = focus.getCoord().getX();
			int eY = focus.getCoord().getY();

			int tX = this.coord.getX();
			int tY = this.coord.getY();

			int dX = (eX - tX);
			int dY = (eY - tY);
			
			eX = (range/2) + dX;
			eY = (range/2) + dY;
			
			g.setColor(Color.red);
			g.drawLine((range/2), (range/2), eX, eY);
		}

		return image;
	}
}
