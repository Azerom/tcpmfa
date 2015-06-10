package fr.tcpmfa.util;

public class Time {
	
	public long startWaveTime;
	public long endWaveTime;
	public long chronoTotal;
	
	public void setStartWaveTime(){
		this.startWaveTime=	System.currentTimeMillis();
	}

	public void setEndWaveTime(){
		this.endWaveTime = System.currentTimeMillis();
	}
	
	public String getChrono(){
		int chronoWaveTotal = (int)(endWaveTime-startWaveTime)/1000;
		
		
		return ("Minutes : "+chronoWaveTotal/60+" "+"Secondes : "+chronoWaveTotal%60);
	}
	

}