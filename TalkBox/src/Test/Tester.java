package Test;

import org.junit.jupiter.api.*;

import controller.Controller;
import gui.MainFrame;
import model.TalkBox;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

public class Tester {
	
	private MainFrame mainframe;
	private TalkBox talkbox;
	
	public void setup() {
		mainframe = new MainFrame();
		talkbox = new TalkBox();
	}
	
	@Test
	public void testAudioSelectionPanel() {
		
	}
	
	@Test
	public void testTalkBox() {
		setup();
		List<String> testSet = new LinkedList<>();
		testSet.add("hi.wav");
		testSet.add("goodbye.wav");
		testSet.add("excuseme.wav");
		testSet.add("time.wav");
		testSet.add("thankyou.wav");
		assertEquals(talkbox.getAudioList(0), testSet, "default test set was not successfully added");
		assertEquals(talkbox.getNumberOfAudioButtons(), 5, "number of buttons should be 5");
		assertEquals(talkbox.getNumberOfAudioSets(), 4);
		talkbox.setAudioFileNames(testSet);
		assertEquals(talkbox.getNumberOfAudioSets(), 5, "audioFileNames did not grow when set was added");
	}
	
	@Test
	public void testController() {
		
		Controller controller = new Controller();
		List<String> tester = new LinkedList<>();
		int oldCount = controller.getNumberOfAudioSets();
		controller.addAudioSet(tester);
		assertEquals(controller.getNumberOfAudioSets(), oldCount + 1, "controller did not grow audioFileNames");
		assertEquals(controller.getAudioList(4), tester, "controller did not add tester successfully");	
		controller.addAudio(4, "testFile");
		assertEquals(controller.getAudioList(4).contains("testFile"), true, "tester should contain testFile");
		controller.removeAudio(4, "testFile");
		assertEquals(controller.getAudioList(4).contains("testFile"), false, "tester should not contain testFile");
		assertEquals(controller.getNumberOfButtons(), 5);
	
	}

}
