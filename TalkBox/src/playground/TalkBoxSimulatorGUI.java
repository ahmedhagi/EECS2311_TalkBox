package playground;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class TalkBoxSimulatorGUI extends JFrame {
	private JPanel panel;
	private JFrame f;
	private JButton btn1, btn2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				TalkBoxSimulatorGUI frame = new TalkBoxSimulatorGUI();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TalkBoxSimulatorGUI() {
		f = new JFrame();
		f.setVisible(true);
		f.setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init_GUI();
		
		
	}

	public void gotoConfigure() {
		TalkBoxConfigurationGUI gui = new TalkBoxConfigurationGUI(this);
	}

	public void init_GUI() {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
	
		btn1 = new JButton("Configuration");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gotoConfigure();
			}
		});

		btn2 = new JButton("Click me to see User manual");
		/* user manual for creating configuration*/
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().open(new File("data//Documents//Demo.txt"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		c.gridx = 0;
		c.gridy = 0;
		panel.add(btn1, c);
		c.gridx = 2;
		c.gridy = 0;
		panel.add(btn2, c);
		f.add(panel,BorderLayout.SOUTH);
	}
	public void create_bnt() {
		
	}

}
