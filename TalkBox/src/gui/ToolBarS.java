package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBarS extends JPanel implements ActionListener {
	private JButton configButton;
	private InitiateSim is;

	
	public ToolBarS() {
		
		setBorder(BorderFactory.createEtchedBorder());
		configButton = new JButton("Start");
		configButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(configButton);
	}
	
	public void setInitListener(InitiateSim listener) {
		this.is = listener;
	}
	
	public void turnOffStartButton() {
		this.configButton.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == configButton) {
			if (is != null) {
				is.shouldStart(true);
			}
		}
		
	}
}
