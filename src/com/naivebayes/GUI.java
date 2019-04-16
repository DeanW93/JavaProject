package com.naivebayes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JPanel header;
	JLabel headerText;
	JButton fileManagerButton;
	JButton patientEvalButton;
	JButton helpPageButton;
	JDialog fm_dialog;
	

	public GUI(String title)
	{
		super(title);
		
	    setSize(800, 150);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
	    setVisible(true);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    
	    header = new JPanel();
	    header.setPreferredSize(new Dimension(800,60));
	    header.setBackground(Color.cyan);
	   
	    headerText = new JLabel();
	    headerText.setText("Naive Bayes");
	    headerText.setFont(new Font("", Font.PLAIN, 35));
	    
	    fileManagerButton = new JButton();
	    fileManagerButton.setPreferredSize(new Dimension(257, 40));
	    fileManagerButton.setText("Train from Data Set");
	    fileManagerButton.addActionListener(this);
	    
	    patientEvalButton = new JButton();
	    patientEvalButton.setPreferredSize(new Dimension(257, 40));
	    patientEvalButton.setText("Patient Evaluation");
	    patientEvalButton.addActionListener(this);
	    
	    helpPageButton = new JButton();
	    helpPageButton.setPreferredSize(new Dimension(257, 40));
	    helpPageButton.setText("Help");
	    helpPageButton.addActionListener(this);
	    
	    header.add(headerText);
	    
	    add(header);
	    add(fileManagerButton);
	    add(patientEvalButton);
	    add(helpPageButton);
	}
	
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource() == fileManagerButton)
		 {
			 dialog
			 FileManager fm = new FileManager("File Manager");
		 }
		 else if(e.getSource() == patientEvalButton)
		 {
			 PatientEvaluation pe = new PatientEvaluation("Patient Evaluation");
		 }
		 else if(e.getSource() == helpPageButton)
		 {
			 HelpPage hp = new HelpPage("Help Page");
		 }
	 }
}
