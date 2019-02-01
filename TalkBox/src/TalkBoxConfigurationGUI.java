import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	/**
	 * Create the frame.
	 */
	public TalkBoxConfigurationGUI(TalkBoxSimulatorGUI gui) {
		gui.setVisible(false);
		setVisible(true);
		setTitle("Configuration");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
				gui.setVisible(false);
			}
		});

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

		JButton btn_save = new JButton("save the setting");
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add_Object();
			}
		});
		panel.add(btn_save);
	}

	public void add_Object() {
		
		try {
			 Calendar cal = Calendar.getInstance();
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm"); 
			 String filename = dateFormat.format(cal.getTime());
			File f = new File("data/tbcfiles/config"+filename+".tbc");
			FileOutputStream fileOutputStream = new FileOutputStream(f);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(make_object());
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private TalkBox make_object() {
		/* just demo talkbox instance ... get talkbox info from user*/
		
		TalkBox talkbox = new TalkBox();
		talkbox.setNumberOfAudioButtons(6);
		talkbox.setNumberOfAudiosets(1);
		String[][] audioFileNames = new String[talkbox.getNumberOfAudioSets()][talkbox.getNumberOfAudioButtons()];
		audioFileNames[0][0] = "data\\audio\\test1.wav";
		audioFileNames[0][1] = "data\\audio\\ShakeYourBootay.wav";
		audioFileNames[0][2] = "data\\audio\\MoodyLoop.wav";
		audioFileNames[0][3] = "data\\audio\\UpBeatFunk.wav";
		audioFileNames[0][4] = "data\\audio\\no.wav";
		talkbox.setAudioFileNames(audioFileNames);
		return talkbox;
	}

}
