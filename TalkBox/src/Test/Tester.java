package Test;

import org.junit.jupiter.api.*;

import controller.Controller;
import gui.MainFrame;
import model.TalkBox;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.List;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

public class Tester {
	
	private MainFrame mainframe;
	private TalkBox talkbox;
	private Robot bot;
	private boolean startPressed;
	
	public void setup() {
		talkbox = new TalkBox();
	}
	
	public void setupGUI() throws AWTException {
		mainframe = new MainFrame();
		mainframe.showIt();
		bot = new Robot();
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
	
	@Test
	public void testGUI() throws AWTException {
		boolean simulatorStarted = false;
		setupGUI();
		Robot bot = new Robot();
		bot.mouseMove(100, 140);
		mouseClick();
		bot.mouseMove(100, 170);
		mouseClick();
		bot.mouseMove(950, 120);
		mouseClick();
		bot.mouseMove(120, 110);
		mouseClick();
		bot.mouseMove(100, 560);
		try {Thread.sleep(5000);}catch (InterruptedException e) {}
		assertEquals(mainframe.getToolBarS().getStarted(), true, "start button pressed");
		assertEquals(mainframe.getMainFrameSim().getSoundPlayed(), true, "sound played");
	}
	
	// bot helper class
	public void mouseClick() {
		try {Thread.sleep(100);}catch (InterruptedException e) {}
		bot.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(100);}catch (InterruptedException e) {}
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(100);}catch (InterruptedException e) {}
	}
}
