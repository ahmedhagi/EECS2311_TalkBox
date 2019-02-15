package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controller.Controller;
import utils.Stereo;

public class MainFrame extends JFrame {
	private AudioSelectionPanel audioSelectionPanel;
	private ToolBar toolBar;
	private SetupPanel setupPanel;
	private ToolBarS toolBarS;
	private Controller controller;
	private Stereo audioPlayer;
	private MainFrameSim mfs;
	
	public MainFrame() {
		super("TalkBox Configurator");
		setLayout(new BorderLayout());
		setJMenuBar(createMenuBar());
		
		//Initialize
		audioSelectionPanel = new AudioSelectionPanel();
		toolBar = new ToolBar();
		setupPanel = new SetupPanel();
		controller = new Controller();
		audioPlayer = new Stereo();
		toolBarS = new ToolBarS();
		mfs = new MainFrameSim();

		
		//Actions
		
	
		audioSelectionPanel.setSelectionListener(new SelectionListener() {
			public void setAudioSelection(int n) {
				String[][] audioFileSet = controller.getFileNames();
				String[] audioSet = audioFileSet[n];
				audioSelectionPanel.setJList(audioSet);
				mfs.setIdx(n);
				mfs.setButtons(n);
				mfs.setSwapButtons();
			}
			
		});
		
		audioSelectionPanel.setPlayListener(new PlayListener() {
			
			public void setFileName(int idx, String fileName) {
				String path = controller.getPath().toString();
				String completePath = path + "\\" + "set" + idx + "\\" + fileName;
				audioPlayer.playMusic(completePath);
			}
		});
		
		audioSelectionPanel.setSetListener(new SetListener() {
			public void setup(int idx, String fileName) {
				if (audioSelectionPanel.isChecked()) {
					setupPanel.appendText(fileName + "\n");
				} else {
					
				}
			}
			
		});
		
		toolBarS.setInitListener(new InitiateSim() {
			public void shouldStart(boolean b) {
				if (b) {
					mfs.showIt();
					MainFrame.this.setVisible(false);
					toolBarS.turnOffStartButton();
					
				}
			}
		});
		
		//Add
		add(audioSelectionPanel, BorderLayout.WEST);
		add(toolBar, BorderLayout.NORTH);
		add(setupPanel, BorderLayout.CENTER);
		add(toolBarS, BorderLayout.SOUTH);		
	}
	
	
	

	public void showIt() {
		setSize(500,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Exit?", "Yes", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
				
			}
		});
		
		return menuBar;
	}
	
}




