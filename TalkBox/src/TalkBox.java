import java.nio.file.Path;
import java.nio.file.Paths;

public class TalkBox implements TalkBoxConfiguration {

	private int numberofAudioButton;
	private int numberofAudiosets;
	private String[][] AudioFileNames;
	
	
	public void setNumberOfAudioButtons(int numberofAudioButton) {
		// TODO Auto-generated method stub
		this.numberofAudioButton=numberofAudioButton;
	}

	public void setNumberOfAudiosets(int NumberOfAudiosets) {
		// TODO Auto-generated method stub
		this.numberofAudiosets = NumberOfAudiosets;
	}

	public void setAudioFileNames(String[][] AudioFileNames) {
		// TODO Auto-generated method stub
		this.AudioFileNames= AudioFileNames;
	}

	@Override
	public int getNumberOfAudioButtons() {
		// TODO Auto-generated method stub
		return this.numberofAudioButton;
	}

	@Override
	public int getNumberOfAudioSets() {
		// TODO Auto-generated method stub
		return this.numberofAudiosets;
	}

	@Override
	public int getTotalNumberOfButtons() {
		// TODO Auto-generated method stub
		return this.numberofAudiosets*this.numberofAudioButton;
	}

	@Override
	public Path getRelativePathToAudioFiles() {
		// TODO Auto-generated method stub
		return Paths.get("data//audio//");
	}

	@Override
	public String[][] getAudioFileNames() {
		// TODO Auto-generated method stub
		return this.AudioFileNames;
	}

}
