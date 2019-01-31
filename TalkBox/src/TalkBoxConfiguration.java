
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.io.Serializable;
import java.nio.file.Path;

/**
 * This interface represents the configuration of a particular TalkBox device.
 * Each TalkBox device has a number of audio buttons, followed by a number of swap buttons.
 * An audio button plays an audio file when pressed.
 * A swap button associates the audio buttons with a new set of audio files when pressed.
 * Swap button 1 selects audio set 1, Swap button 2 selects audio set 2 etc.
 * If there are not enough swap buttons for each audio set, then the last swap button cycles through all remaining audio sets.
 * 
 * @author bil
 *
 */
public interface TalkBoxConfiguration extends Serializable {

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

    /**
     * Returns the number of physical buttons that when pressed will play an audio file.
     * 
     * @return int A positive integer
     */
    public int getNumberOfAudioButtons();
    
    /**
     * Returns the number of sets of audio files that this configuration supports.
     * 
     * @return int A positive integer
     */
    public int getNumberOfAudioSets();
    
    /**
     * Returns the total number of buttons in this TalkBox. 
     * 
     * @return int A positive integer
     */
    public int getTotalNumberOfButtons();
    
    /**
     * Returns a Path relative to this configuration object where all audio files can be found
     * @return Path A Path object that identifies the directory that contains the audio files
     */
    public Path getRelativePathToAudioFiles();
    
    /**
     * Returns a 2-dimensional array of Strings that contains the names of all audio files.
     * Each row of the array is an audio set.
     * The dimensions of the array are given by {@link #getNumberOfAudioButtons() getNumberOfAudioButtons}
     * and {@link #getNumberOfAudioSets() getNumberOfAudioSets}
     * @return A 2-dimensional array of Strings
     */
    public String[][] getAudioFileNames();
    
}

