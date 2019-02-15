package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class AudioSelectionPanel extends JPanel {
	private JComboBox audioSelection;
	private JList audioList;
	private JButton playButton;
	private JButton setButton;
	private SelectionListener selectionListener;
	private PlayListener playListener;
	private SetListener setListener;
	private JCheckBox checkBox;
	private boolean isChecked;
	

	
	public AudioSelectionPanel() {
		//initialize
		audioSelection = new JComboBox();
		audioList = new JList();
		playButton = new JButton("Play"); 
		setButton = new JButton("Set");
		checkBox = new JCheckBox();
		setButton.setEnabled(false);
		isChecked = false;
		
		
		//Setup Combo Box
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
		comboModel.addElement("");
		comboModel.addElement("Audio Set 1");
		comboModel.addElement("Audio Set 2");
		comboModel.addElement("Audio Set 3");
		comboModel.addElement("Audio Set 4");
		audioSelection.setModel(comboModel);
		audioSelection.setSelectedIndex(1);
		
		
		
		//Actions
		audioSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectionListener != null) {
					int selection = audioSelection.getSelectedIndex();
					if (selection > 0) {
						selectionListener.setAudioSelection(audioSelection.getSelectedIndex() - 1);
					}
				}
			}
		});
		
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = (String) audioList.getSelectedValue();
				int idx = audioSelection.getSelectedIndex();
				if (playListener != null && idx > 0) {
					playListener.setFileName(idx, selection);
				}
			}
			
		});
		
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isChecked = checkBox.isSelected();	
				setButton.setEnabled(isChecked);
			}
			
		});
		setButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = (String) audioList.getSelectedValue();
				int idx = audioSelection.getSelectedIndex();
				if (setListener != null) {
					setListener.setup(idx, selection);
				}
			}
			
		});
		

		
			
		Border innerBorder = BorderFactory.createTitledBorder("Select Audio");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		layoutComponents();
		
		
	}
	
	
	public void setSelectionListener(SelectionListener listener) {
		this.selectionListener = listener;
	}
	
	public void setPlayListener(PlayListener listener) {
		this.playListener = listener;
	}
	
	public void setSetListener(SetListener listener) {
		this.setListener = listener;
	}
	
	public boolean isChecked() {
		return checkBox.isSelected();
	}
	
	private void layoutComponents() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		/* First Row */
		gc.gridy = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(audioSelection, gc);
	
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(audioList, gc);
		
		/*Next Row */
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(playButton, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(setButton, gc);
		
		/*Next Row */
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Create Custom Audio Set: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(checkBox, gc);
		
		
	}


	public void setJList(String[] audioSet) {
		
		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < audioSet.length; i++) {
			listModel.addElement(audioSet[i]);
		}
		audioList.setModel(listModel);
		//audioList.setPreferredSize(new Dimension(110, 68));
		audioList.setBorder(BorderFactory.createEtchedBorder());
		audioList.setSelectedIndex(0);

	}
	
	
	
}
