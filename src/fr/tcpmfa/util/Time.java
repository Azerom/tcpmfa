package fr.tcpmfa.util;

public class Time {
	
	public long startTime;
	public long endTime;
	public long chrono;
	
	public void setStartTime(){
		this.startTime=	System.currentTimeMillis();
	}

	public void setEndTime(){
		this.endTime = System.currentTimeMillis();
	}
	
	public String getChrono(){
		int chronoTotal = (int)(endTime-startTime)/1000;
		
		return ("Minutes : "+chronoTotal/60+" "+"Secondes : "+chronoTotal%60);
	}

}