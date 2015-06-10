package fr.tcpmfa.util;

public class Time {
	
	private long startWaveTime;
	private long endWaveTime;
	
	public void setStartWaveTime(long startWaveTime){
		this.startWaveTime=	System.currentTimeMillis();
	}
	
	public long getStartWaveTime(){
		return startWaveTime;
	}
	
	public void setEndWaveTime(long endWaveTime){
		this.endWaveTime = System.currentTimeMillis();
	}
	
	public long getEndWaveTime(){
		return endWaveTime;
	}
	
	public long getChrono(){
		return (endWaveTime-startWaveTime);
	}
	
	

}

//	new java.util.Date();
//	System.currentTimeMillis();