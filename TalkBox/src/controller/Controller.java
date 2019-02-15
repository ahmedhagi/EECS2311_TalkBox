package controller;

import java.nio.file.Path;

import model.TalkBox;

public class Controller {
	private TalkBox talkbox;
	
	public Controller() {
		this.talkbox = new TalkBox();
	}
	
	public Path getPath() {
		return talkbox.getRelativePathToAudioFiles();
	}
	
	public String[][] getFileNames() {
		return talkbox.getAudioFileNames();
	}
	
	public int getNumberOfAudioSets() {
		return talkbox.getNumberOfAudioSets();
	}
	
	public int getNumberOfButtons() {
		return talkbox.getNumberOfAudioButtons();
	}
}
