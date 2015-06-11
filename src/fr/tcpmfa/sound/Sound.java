package fr.tcpmfa.sound;

public class Sound extends Thread {
	private String audioFile;
	public Sound(String audioFile){
		this.audioFile = audioFile;
		
		this.start();
	}
	public void run(){
		AudioPlayer audio = new AudioPlayer();
		audio.play(audioFile);
	}
}
