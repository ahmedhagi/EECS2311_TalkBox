

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sound extends JFrame {

	private JPanel contentPane;
	private File soundfilein;
	private String name;
	private AudioInputStream audioIn;
	private Clip clip = null;
	private ButtonGroup btngroup1;
	/**
	 * @wbp.nonvisual location=-38,419
	 */
	private final JTextField textField = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sound frame = new Sound();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Sound() {
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 100, 0, 100, 0, 100, 0, 100, 0, 100, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 100, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 2;
		gbc_btn1.gridy = 1;
	
		
		JToggleButton btn1 = new JToggleButton("toggle 1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn1.isSelected()){
					lblNewLabel.setText("button1 clicked");
					playMusic("data\\audio\\test1.wav");
	            }
	            else {
	            	//stop the music
	          }
			}
		});
		contentPane.add(btn1, gbc_btn1);
		
		
		JToggleButton btn2 = new JToggleButton("toggle2");
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 4;
		gbc_btn2.gridy = 1;
		contentPane.add(btn2, gbc_btn2);
		
		JToggleButton btn3 = new JToggleButton("toggle 3");
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 6;
		gbc_btn3.gridy = 1;
		contentPane.add(btn3, gbc_btn3);

		
		JToggleButton btn4 = new JToggleButton("toggle4");
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 8;
		gbc_btn4.gridy = 1;
		contentPane.add(btn4, gbc_btn4);
		
		
		btngroup1 = new ButtonGroup();
		addGroup(btngroup1,btn1);
		addGroup(btngroup1,btn2);
		addGroup(btngroup1,btn3);
		addGroup(btngroup1,btn4);
		
	}
	
	public void addGroup(ButtonGroup btngroup,JToggleButton btn) {
		btngroup.add(btn);
	}
	
	private void playMusic(String SoundFile) {
		try {
			clip = AudioSystem.getClip(); 
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		soundfilein = new File(SoundFile);
		
		try {
			audioIn = AudioSystem.getAudioInputStream(soundfilein.toURI().toURL());
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException ee) {
			ee.printStackTrace();
		} catch (IOException ee) {
			ee.printStackTrace();
		} catch (LineUnavailableException ee) {
			ee.printStackTrace();
		}
	}


}
