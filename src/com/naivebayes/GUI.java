package com.naivebayes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener
{
	//Panels
	private JPanel header;
	
	//Labels
	private JLabel headerText;
	
	//Buttons
	private JButton fileManagerButton;
	static 	JButton patientEvalButton;
	private JButton helpPageButton;
	

	public GUI(String title)
	{
		super(title);
		
		//Page Layout and properties
	    setSize(800, 150);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
	    setVisible(true);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    
	    //Panel properties
	    header = new JPanel();
	    header.setPreferredSize(new Dimension(800,60));
	    header.setBackground(Color.cyan);
	    
	    //Label properties
	    headerText = new JLabel();
	    headerText.setText("Naive Bayes");
	    headerText.setFont(new Font("", Font.PLAIN, 35));
	    
	    //Button properties
	    fileManagerButton = new JButton();
	    fileManagerButton.setPreferredSize(new Dimension(257, 40));
	    fileManagerButton.setText("Train New Data Set");
	    fileManagerButton.addActionListener(this);
	    
	    patientEvalButton = new JButton();
	    patientEvalButton.setPreferredSize(new Dimension(257, 40));
	    patientEvalButton.setText("Patient Evaluation");
	    patientEvalButton.addActionListener(this);
	    patientEvalButton.setEnabled(false);
	    
	    helpPageButton = new JButton();
	    helpPageButton.setPreferredSize(new Dimension(257, 40));
	    helpPageButton.setText("Help");
	    helpPageButton.addActionListener(this);
	    
	    //Add components
	    header.add(headerText);
	    
	    add(header);
	    add(fileManagerButton);
	    add(patientEvalButton);
	    add(helpPageButton);
	}
	
	 public void actionPerformed(ActionEvent e)
	 {
		 //Access file browser window for selecting dataset tp train
		 if(e.getSource() == fileManagerButton)
		 {
			 JOptionPane.showMessageDialog(null, "Welcome to the Data Training Window! Please use the slider to select the ratio of your dataset to train. "
			 									+ "\n\n NOTE: "
			 									+ "\n\n- The remaining data will be used for self evaluation of the system."
					 							+ "\n- You may process multiple files, data will be added each time a file is processed."
					 							+ "\n- Yjou MUST restart the program to clear the dataset.");
			 
			 @SuppressWarnings("unused")
			FileManager fm = new FileManager("File Manager");
		 }
		 //Access patient evaluation page
		 else if(e.getSource() == patientEvalButton)
		 {
			 @SuppressWarnings("unused")
			PatientEvaluation pe = new PatientEvaluation("Patient Evaluation");
		 }
		 //Access help page
		 else if(e.getSource() == helpPageButton)
		 {
			 @SuppressWarnings("unused")
			HelpPage hp = new HelpPage("Help Page");
		 }
	 }

}
