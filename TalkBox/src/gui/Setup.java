package gui;

public class Setup {
	private int audioSet;
	private String fileName;
	
	public Setup(int idx, String fileName) {
		this.audioSet = idx;
		this.fileName = fileName;
	}

	public int getAudioSet() {
		return audioSet;
	}

	public String getFileName() {
		return fileName;
	}
	
	
}
