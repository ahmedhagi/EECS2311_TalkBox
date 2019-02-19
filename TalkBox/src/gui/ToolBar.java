package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener {
	JButton recordButton;
	InitiateSim sim;
	
	public ToolBar() {
		setBorder(BorderFactory.createEtchedBorder());
		recordButton = new JButton("Record New Sound");
		recordButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(recordButton);
	}
	
	public void setRecord (InitiateSim sim) {
		this.sim = sim;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == recordButton) {
			if (this.sim != null) {
				sim.shouldStart(true);
			}
			
		}
		
	}
}
