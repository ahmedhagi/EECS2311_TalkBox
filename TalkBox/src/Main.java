import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createSetting();
		
	}
	public static void createSetting() {
	      TalkBox talkbox = new TalkBox();
	      talkbox.setNumberOfAudioButtons(6);
	      talkbox.setNumberOfAudiosets(1);
	      String [][] audioFileNames = new String[talkbox.getNumberOfAudioSets()][talkbox.getNumberOfAudioButtons()];
	      audioFileNames[0][0] = "data\\audio\\test1.wav";
	      audioFileNames[0][1] = "data\\audio\\ShakeYourBootay.wav";
	      audioFileNames[0][2] = "data\\audio\\MoodyLoop.wav";
	      audioFileNames[0][3] = "data\\audio\\UpBeatFunk.wav";
	      
	      talkbox.setAudioFileNames(audioFileNames);
	      
	      try {
	         FileOutputStream fileOutputStream = new FileOutputStream("data/configure.tbc");
	          ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	          objectOutputStream.writeObject(talkbox);
	          objectOutputStream.flush();
	          objectOutputStream.close();
	           
	          
	          
	          FileInputStream fileInputStream = new FileInputStream("data/configure.tbc");
	          ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	          TalkBox t = (TalkBox) objectInputStream.readObject();
	          objectInputStream.close();
	      } catch (IOException | ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	   }

}
