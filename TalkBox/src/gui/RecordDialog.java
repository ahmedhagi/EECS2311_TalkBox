package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class RecordDialog extends JDialog {
	
	private JTextField audioFileName;
	private JToggleButton recordButton;
	
	public RecordDialog(JFrame parent) {
		super(parent, "Record...", false);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		audioFileName = new JTextField(10);
		recordButton = new JToggleButton("Record");
		
		
		
		gc.gridy = 0;
		
		
		/*First Row */
		gc.weighty = 1;
		gc.weightx = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(new JLabel("Name: "), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(audioFileName, gc);
		
		/* Next Row */
		
		gc.gridy++;
		gc.weighty = 1;
		gc.weightx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		
		add(recordButton, gc);
		
		
		
		
		
		
		
		setSize(400, 300);
		setLocationRelativeTo(parent);
		
	}
}
