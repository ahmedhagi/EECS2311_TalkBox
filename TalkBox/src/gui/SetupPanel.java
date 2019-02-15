package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SetupPanel extends JPanel {
private JTextArea textArea;
	
	public SetupPanel() {
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		textArea.setEditable(false);
	}
	
	
	public void appendText (String text) {
		textArea.append(text);
	}
	
	public String getText() {
		return textArea.getText();
	}
}
