package controller;

import java.awt.event.ActionEvent;
import java.nio.file.Path;
import java.util.List;

import model.TalkBox;

public class Controller {
	private TalkBox talkbox;
	//talkboc save to object  set audiofile and talbox create . 
	public Controller() {
		this.talkbox = new TalkBox();//initialize with talkbox setter method
		
		
	}
	public void StoreInfo(ActionEvent e) {
		// # drop down bar, # of items each set,  => keep linkedlist
		
	}
	public void addAudioSet(List<String> audioset) {
		talkbox.setAudioFileNames(audioset);
		
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
