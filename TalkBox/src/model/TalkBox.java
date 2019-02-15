package model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class TalkBox implements TalkBoxConfiguration {

	private List<List<String>> audioFileNames;
	
	public TalkBox() {
		audioFileNames = new LinkedList<>();
		setAudioFileNames();
	}
	
	public void setAudioFileNames() {
		//Set 1
		List<String> set1 = new LinkedList<>();
		set1.add("hi.wav");
		set1.add("goodbye.wav");
		set1.add("excuseme.wav");
		set1.add("time.wav");
		set1.add("thankyou.wav");
		audioFileNames.add(0, set1);
		
		//Set 2
		List<String> set2 = new LinkedList<>();
		set2.add("Yes.wav");
		set2.add("No.wav");
		set2.add("Maybe.wav");
		set2.add("Sometimes.wav");
		set2.add("Ok.wav");
		audioFileNames.add(1, set2);
		
		//Set 3
		List<String> set3 = new LinkedList<>();
		set3.add("Happy.wav");
		set3.add("Sad.wav");
		set3.add("Hungry.wav");
		set3.add("Bored.wav");
		set3.add("Tired.wav");
		audioFileNames.add(2, set3);
		
		//Set 4
		List<String> set4 = new LinkedList<>();
		set4.add("Cool.wav");
		set4.add("Sucks.wav");
		set4.add("Like.wav");
		set4.add("Dont Like.wav");
		set4.add("Alright.wav");
		audioFileNames.add(3, set4);
	}
	@Override
	public int getNumberOfAudioButtons() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getNumberOfAudioSets() {
		return audioFileNames.size();
	}

	@Override
	public int getTotalNumberOfButtons() {
		// TODO Auto-generated method stub
		int total = 0;
		for (int i = 0; i < audioFileNames.size(); i ++) {
			for (int j = 0; j < audioFileNames.get(i).size(); j++) {
				total++;
			}
		}
		return total;
	}

	@Override
	public Path getRelativePathToAudioFiles() {
		return Paths.get("src//audio//");
		
	}

	@Override
	public String[][] getAudioFileNames() {
		int n = getNumberOfAudioSets();
		String[][] fileNames = new String[n][];
		
		for (int i = 0; i < n; i++) {
			fileNames[i] = new String[audioFileNames.get(i).size()];
			for (int j = 0; j < audioFileNames.get(i).size(); j++) {
				fileNames[i][j] = audioFileNames.get(i).get(j);
			}
		}
		
		return fileNames;
		
	}

}
