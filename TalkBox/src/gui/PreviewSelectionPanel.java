package gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PreviewSelectionPanel extends JPanel {


	private JButton button1, button2, button3, button4, button5;
	private Dimension buttonSize;
	
	public PreviewSelectionPanel() {
	
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		buttonSize = new Dimension(100, 100);
		button1.setPreferredSize(buttonSize);
		button2.setPreferredSize(buttonSize);
		button3.setPreferredSize(buttonSize);
		button4.setPreferredSize(buttonSize);
		button5.setPreferredSize(buttonSize);
		this.setPreferredSize(new Dimension(600, 100));
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
	}
	
	public PreviewSelectionPanel(ArrayList<String> newAudioSet) {
		button1 = new JButton(newAudioSet.get(0));
		button2 = new JButton(newAudioSet.get(1));
		button3 = new JButton(newAudioSet.get(2));
		button4 = new JButton(newAudioSet.get(3));
		button5 = new JButton(newAudioSet.get(4));
		buttonSize = new Dimension(100, 100);
		button1.setPreferredSize(buttonSize);
		button2.setPreferredSize(buttonSize);
		button3.setPreferredSize(buttonSize);
		button4.setPreferredSize(buttonSize);
		button5.setPreferredSize(buttonSize);
		this.setPreferredSize(new Dimension(600, 100));
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
	}

}
