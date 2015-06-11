package fr.tcpmfa.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import fr.tcpmfa.engine.Tower;

public  class OverlayPanel extends JPanel implements MouseListener{
	
	private int x = 0;
	private int y = 0;
	public static void Overlay(MouseEvent Up){ 

		
		if (Up.getButton() == MouseEvent.BUTTON1){
			System.out.println("HERE----------------------------------\n------------------------------------"
					+ "\n-----------------------------------------------------------------------------------");
		}
		else{

		}

	}
	
	public OverlayPanel(){
		super();
		this.setBackground(new Color(0,0,0,0));
	}
	
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.fillRect(x, y, 50, 50);
	}
	
	public void addOver(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {


			System.out.println("--------------------------------------------------------------------------\n"
					+ "");

		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}