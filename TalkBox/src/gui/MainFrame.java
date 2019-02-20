package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	
	private JFileChooser jfilechooser;
	private RecordDialog recordDialog;
	private JFrame reference;
	private final JPanel east_panel = new JPanel();
	
	public MainFrame() {
		super("TalkBox Configurator");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BorderLayout());
		setJMenuBar(createMenuBar());
		
		//Initialize
		audioSelectionPanel = new AudioSelectionPanel();
		audioSelectionPanel.def_audioset();
		toolBar = new ToolBar();
		setupPanel = new SetupPanel();
		controller = audioSelectionPanel.controller;
		audioPlayer = new Stereo();
		toolBarS = new ToolBarS();
		mfs = new MainFrameSim(controller);
		String s=System.getProperty("user.dir"); 
		jfilechooser = new JFileChooser(s);
		jfilechooser.addChoosableFileFilter(new ImportExtensionFilter());
		recordDialog = new RecordDialog(this);
		reference = this;
		toolBarS.turnOffStart();

	
		
		//Actions
		
		
		audioSelectionPanel.setSelectionListener(new SelectionListener() {
			public void setAudioSelection(int n) {
				refreshJList(n);
			  setupSim(n);
		      recordDialog.setAudioIndex(n);
		      toolBarS.turnOnStart();
			}
			
		});
		
		
		audioSelectionPanel.setPlayListener(new PlayListener() {
			
			public void setFileName(int idx, String fileName) {
				String path = controller.getPath().toString();
				String completePath = path +  "\\" + fileName; //**
				audioPlayer.playMusic(completePath);
			}
		});
		
		audioSelectionPanel.setSetListener(new SetListener() {
			public void setup(int idx, String fileName) {
				if (audioSelectionPanel.isChecked() && fileName != null) {
					setupPanel.appendText(fileName + "\n");
					if(!setupPanel.isEmpty()) {
						audioSelectionPanel.turnOnUndo();
					}
				} else {
					
				}
			}
			
		});
		
		audioSelectionPanel.setClearListener(new ClearListener() {

			public void clear(boolean b) {
				if (b) {
					setupPanel.removeText();
				}
			}
			
		});
		
		audioSelectionPanel.setRemoveListener(new RemoveListener() {

			@Override
			public void setRemoveInfo(int idx, String file) {
				controller.removeAudio(idx, file);
				refreshJList(idx);
				setupSim(idx);
			}
			
		});
		
		audioSelectionPanel.setAddListener(new AddListener() {
			public void clearSetup(boolean b) {
				if (b) {
					setupPanel.removeText();
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
		
		toolBar.setRecord(new InitiateSim() {
			@Override
			public void shouldStart(boolean b) {
				if (b) {
					recordDialog.setVisible(true);
				}
			}
		});
		
		recordDialog.setSetListener(new SetListener() {

			@Override
			public void setup(int idx, String fileName) {
				controller.addAudio(idx, fileName);
				refreshJList(idx);
				setupSim(idx);
			}
			
		});
		
		//Add
		getContentPane().add(audioSelectionPanel, BorderLayout.WEST);
		getContentPane().add(east_panel, BorderLayout.EAST);
		
		JButton btn1 = new JButton("New button");
		btn1.setPreferredSize(new Dimension(100, 100));
		east_panel.add(btn1);
		
		JButton btn2 = new JButton("New button");
		btn2.setPreferredSize(new Dimension(100, 100));
		east_panel.add(btn2);
		
		JButton btn3 = new JButton("New button");
		btn3.setPreferredSize(new Dimension(100, 100));
		east_panel.add(btn3);
		
		JButton btn4 = new JButton("New button");
		btn4.setPreferredSize(new Dimension(100, 100));
		east_panel.add(btn4);
		
		JButton btn5 = new JButton("New button");
		btn5.setPreferredSize(new Dimension(100, 100));
		east_panel.add(btn5);
		
		getContentPane().add(toolBar, BorderLayout.NORTH);
		getContentPane().add(setupPanel, BorderLayout.CENTER);
		getContentPane().add(toolBarS, BorderLayout.SOUTH);		
		
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
		importDataItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(jfilechooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.load(jfilechooser.getSelectedFile());
						audioSelectionPanel.refre_audio();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		exportDataItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(jfilechooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.save(jfilechooser.getSelectedFile());
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

				
	
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
	
	public void refreshJList(int idx) {
		String[][] audioFileSet = controller.getFileNames();
		String[] audioSet = audioFileSet[idx];
		audioSelectionPanel.setJList(audioSet); //setting 
	}
	
	public void setupSim(int n) {
		  mfs.setIdx(n);
		  mfs.setButtons(n);
	      mfs.setSwapButtons();
	}
	
}




