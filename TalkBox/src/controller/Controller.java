package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.List;

import model.TalkBox;

public class Controller {
	private TalkBox talkbox;
	//talkboc save to object  set audiofile and talbox create . 
	public Controller() {
		this.talkbox = new TalkBox();//initialize with talkbox setter method
		
		
	}
	
	public void removeAudioSet(int n) {
		talkbox.removeAudioFile(n);
		
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
	public void save(File file) throws Exception {
		FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        try {
			objectOutputStream.writeObject(talkbox);
			objectOutputStream.flush();
		    objectOutputStream.close();
		        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	}
	public void load(File file) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        this.talkbox= (TalkBox) objectInputStream.readObject();
        objectInputStream.close();
     
	}
}
