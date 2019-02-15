package playground;
import java.awt.Color;
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
import javax.swing.SwingConstants;

public class Sound extends JFrame {

	private JToggleButton btn1, btn2, btn3, btn4;
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
		
		setClip();
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 2;
		gbc_btn1.gridy = 1;
	
		
		JToggleButton btn1 = new JToggleButton("Sound 1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn1.isSelected()){
					lblNewLabel.setText(getName("data\\audio\\test1.wav")+" is now playing");
					playMusic("data\\audio\\test1.wav");
	            }
	            else {
	            
	          }
			}
		});
		
		
		JLabel talkbox = new JLabel("TalkBox1.0");
		GridBagConstraints gbc_talkbox = new GridBagConstraints();
		gbc_talkbox.insets = new Insets(0, 0, 5, 5);
		gbc_talkbox.gridx = 6;
		gbc_talkbox.gridy = 0;
		contentPane.add(talkbox, gbc_talkbox);
		contentPane.add(btn1, gbc_btn1);
		talkbox.setForeground(Color.blue);
	
		JToggleButton btn2 = new JToggleButton("Sound 2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btn2.isSelected()){
					lblNewLabel.setText(getName("data\\audio\\ShakeYourBootay.wav")+" is now playing");
					playMusic("data\\audio\\ShakeYourBootay.wav");
	            }
	            else {
	            	
	          }
			}
				
		});
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 4;
		gbc_btn2.gridy = 1;
		contentPane.add(btn2, gbc_btn2);
		
		JToggleButton btn3 = new JToggleButton("Sound 3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn3.isSelected()){
					lblNewLabel.setText(getName("data\\audio\\MoodyLoop.wav") +" is now playing");
					playMusic("data\\audio\\MoodyLoop.wav");
	            }
	            else {
	            	
	          }
			}
		});
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 6;
		gbc_btn3.gridy = 1;
		contentPane.add(btn3, gbc_btn3);

		
		JToggleButton btn4 = new JToggleButton("Sound 4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn4.isSelected()){
					lblNewLabel.setText(getName("data\\audio\\UpBeatFunk.wav")+" is now playing");
					playMusic("data\\audio\\UpBeatFunk.wav");
	            }
	            else {
	            	
	          }
				
			}
		});
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 8;
		gbc_btn4.gridy = 1;
		contentPane.add(btn4, gbc_btn4);
		
     	//button group 1 add//
		btngroup1 = new ButtonGroup();
		btngroup1.add(btn1);
		btngroup1.add(btn2);
		btngroup1.add(btn3);
		btngroup1.add(btn4);
		
		
		
		JToggleButton btn5 = new JToggleButton("Pause/Resume");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btn5.isSelected()){
					 lblNewLabel.setText("Pause");
					clip.stop();
	            }
	            else {
	            	
	            	clip.start();
	          }
			}
		});
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 9;
		gbc_btn5.gridy = 1;
		contentPane.add(btn5, gbc_btn5);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 lblNewLabel.setText("Stop");
				clip.stop();
				clip.close();
			}
		});
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop.gridx = 10;
		gbc_btnStop.gridy = 1;
		contentPane.add(btnStop, gbc_btnStop);
		

   
	}
	
   
	
	public void addGroup(ButtonGroup btngroup,JToggleButton btn) {
		btngroup.add(btn);
	}
	
	private void setClip() {
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void playMusic(String SoundFile) {
		
		
		clip.stop();
		clip.close();
		
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
	public String getName(String str) {
		StringBuffer s1 = new StringBuffer(str);
		StringBuffer s2= new StringBuffer();;
		char [] temp  = s1.substring(11).toCharArray();
	    for(int i=0;i<temp.length-4;i++) {
	    	s2.append(temp[i]);
	    }
	    return s2.toString();
	}


}

