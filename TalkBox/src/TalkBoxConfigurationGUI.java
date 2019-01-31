import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuBar;

public class TalkBoxConfigurationGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TalkBoxConfigurationGUI frame = new TalkBoxConfigurationGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TalkBoxConfigurationGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JToggleButton record = new JToggleButton("Record");
		record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if (record.isSelected()) {
                     Helpers.startRecording();
                     record.setText("Stop");
                 } else {
                     Helpers.stopRecording();
                     record.setText("Record");
                 }
			}
		});
		panel.add(record);
		
		JMenu mnNewMenu_2 = new JMenu("Load Audio Button 1");
		panel.add(mnNewMenu_2);
		
		JMenu mnNewMenu = new JMenu("Load Audio Button 2");
		panel.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Load Audio Button 3");
		panel.add(mnNewMenu_1);
		
		JMenu mnNewMenu_3 = new JMenu("Load Audio Button 4");
		panel.add(mnNewMenu_3);
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar);
	}

}
