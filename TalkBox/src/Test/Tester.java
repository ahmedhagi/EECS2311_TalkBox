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
	
	public List<String> setupTestSet() {
		List<String> testSet = new LinkedList<>();
		testSet.add("hi.wav");
		testSet.add("goodbye.wav");
		testSet.add("excuseme.wav");
		testSet.add("time.wav");
		testSet.add("thankyou.wav");
		
		return testSet;
	}
	
	@Test
	public void test_model_getAudioList() {
		setup();
		List<String> tester = setupTestSet();
		assertEquals(talkbox.getAudioList(0), tester, "default test set was not successfully added");
	}
	
	@Test
	public void test_model_getNumberOfAudioButtons() {
		setup();
		assertEquals(talkbox.getNumberOfAudioButtons(), 5, "number of buttons should be 5");
	}
	
	@Test
	public void test_model_getNumberOfAudioSets() {
		setup();
		List<String> tester = setupTestSet();
		setupTestSet();
		assertEquals(talkbox.getNumberOfAudioSets(), 4);
	}
	
	@Test
	public void test_model_setAudioFileNames() {
		setup();
		List<String> tester = setupTestSet();
		setupTestSet();
		talkbox.setAudioFileNames(tester);
		assertEquals(talkbox.getNumberOfAudioSets(), 5, "audioFileNames did not grow when set was added");
		assertEquals(talkbox.getAudioList(4).contains("hi.wav"), true, "audioFileNames should contain hi.wav at the last index");
	}
	
	@Test
	public void test_controller_addAudioSet() {
		Controller controller = new Controller();
		List<String> tester = new LinkedList<>();
		int oldCount = controller.getNumberOfAudioSets();
		controller.addAudioSet(tester);
		assertEquals(oldCount + 1, controller.getNumberOfAudioSets(), 
				"controller did not grow audioFileNames");
		assertEquals(controller.getAudioList(4), tester, 
				"controller did not add tester successfully");	
	}
	
	@Test
	public void test_controller_addAudio() {
		Controller controller = new Controller();
		controller.addAudio(0, "testFile");
		assertEquals(controller.getAudioList(0).contains("testFile"), true, 
				"tester should contain testFile");
	}
	
	@Test
	public void test_controller_removeAudio() {
		Controller controller = new Controller();
		controller.removeAudio(0, "hi.wav");
		assertEquals(controller.getAudioList(0).contains("hi.wav"), false, 
				"hi.wav should have been removed from audioFileNames[0]");
		
	}
	@Test
	public void test_controller_getNumberOfButtons() {
		Controller controller = new Controller();
		assertEquals(controller.getNumberOfButtons(), 5);
	}
	
	@Test
	public void testGUI() throws AWTException {
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
		try {Thread.sleep(2000);}catch (InterruptedException e) {}
		assertEquals(mainframe.getToolBarS().getStarted(), true, 
				"start button was not pressed");
		assertEquals(mainframe.getMainFrameSim().getSoundPlayed(), true, 
				"sound button was not pressed");
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
