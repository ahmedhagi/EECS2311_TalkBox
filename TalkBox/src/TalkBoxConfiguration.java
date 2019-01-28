import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuBar;

public class TalkBoxConfiguration extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TalkBoxConfiguration frame = new TalkBoxConfiguration();
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
	public TalkBoxConfiguration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnRecordAudio = new JButton("Record Audio");
		panel.add(btnRecordAudio);
		
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
