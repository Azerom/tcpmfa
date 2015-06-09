package fr.tcpmfa.engine;

import java.util.ArrayList;
import java.util.Random;

import fr.tcpmfa.util.Coordinate;

public class Point extends Coordinate {
	public Point(int x, int y) {
		super(x, y);
		CheckPointList = new ArrayList<CheckPoint>();
	}

	private ArrayList<CheckPoint> CheckPointList;
	
	public CheckPoint getCheckPoint(){
		Random random = new Random();
		return CheckPointList.get(random.nextInt(CheckPointList.size()));
	}
	
	public void addCheckPoint(CheckPoint checkPoint){
		this.CheckPointList.add(checkPoint);
	}
}
