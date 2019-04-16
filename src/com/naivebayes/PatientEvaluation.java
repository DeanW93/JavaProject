package com.naivebayes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.SoftBevelBorder;

public class PatientEvaluation extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	JPanel header;
	JPanel dataline1;
	JPanel dataline2;
	JPanel dataline3;
	JPanel dataline4;
	JPanel dataline5;
	JPanel dataline6;
	JPanel dataline7;
	JPanel dataline8;
	
	JLabel headerText;
	JLabel instructionsText;
	
	JLabel tempLabel;
	JLabel hotLabel;
	JLabel normalLabel;
	JLabel coolLabel;
	
	JLabel acheLabel;
	JLabel acheyes;
	JLabel acheno;
	
	JLabel soreLabel;
	JLabel soreyes;
	JLabel soreno;
	
	
	JCheckBox hotbox;
	JCheckBox normbox;
	JCheckBox coolbox;
	JCheckBox acheYesbox;
	JCheckBox acheNobox;
	JCheckBox soreYesbox;
	JCheckBox soreNobox;
	
	JButton submit;

	public PatientEvaluation(String title)
	 {
		 super(title);
		 setSize(400, 485);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 setLayout(new FlowLayout());
		 setVisible(true);
		 setLocationRelativeTo(null);
		 setResizable(false);
		 
		 header = new JPanel();
		 header.setPreferredSize(new Dimension(400, 60));
		 header.setBackground(Color.cyan);
		 
		 dataline1 = new JPanel();
		 dataline1.setPreferredSize(new Dimension(400,70));
		 dataline1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		 
		 dataline2 = new JPanel();
		 dataline2.setPreferredSize(new Dimension(400,40));
		 dataline2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		 
		 dataline3 = new JPanel();
		 dataline3.setPreferredSize(new Dimension(400,40));
		 dataline3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		 
		 dataline4 = new JPanel();
		 dataline4.setPreferredSize(new Dimension(400,40));
		 dataline4.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		 
		 dataline5 = new JPanel();
		 dataline5.setPreferredSize(new Dimension(400,40));
		 dataline5.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		
		 
		 dataline6 = new JPanel();
		 dataline6.setPreferredSize(new Dimension(400,40));
		 dataline6.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		 
		 dataline7 = new JPanel();
		 dataline7.setPreferredSize(new Dimension(400,40));
		 dataline7.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		 
		 dataline8 = new JPanel();
		 dataline8.setPreferredSize(new Dimension(400,40));
		 dataline8.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		  
		 headerText = new JLabel();
		 headerText.setText("Patient Evaluation");
		 headerText.setFont(new Font("", Font.PLAIN, 35));
		 
		 instructionsText = new JLabel();
		 instructionsText.setText("<html>Please tick the relevant symptoms "
		 						+ "of the patient to be evaluated.<br/><br/> "
		 						+ "Press submit to continue.</html>");
		 
		 tempLabel = new JLabel();
		 tempLabel.setText("Temperature");
		 
		 hotLabel = new JLabel();
		 hotLabel.setText("Hot: ");
		 
		 normalLabel = new JLabel();
		 normalLabel.setText("Normal: ");
		 
		 coolLabel = new JLabel();
		 coolLabel.setText("Cool: ");
		 
		 acheLabel = new JLabel();
		 acheLabel.setText("Aches");
		 
		 soreLabel = new JLabel();
		 soreLabel.setText("Sore");
		 
		 yes = new JLabel();
		 yes.setText("Yes: ");
		 
		 no = new JLabel();
		 no.setText("No: ");
		 
		 submit = new JButton("Submit");
		 
		 
		 
		 
		 
		 add(header);
		 header.add(headerText);
		 
		 add(dataline1);
		 dataline1.add(instructionsText);
		 
		 add(dataline2);
		 dataline2.add(tempLabel);
		 
		 add(dataline3);
		 dataline3.add(hotLabel);
		 dataline3.add(normalLabel);
		 dataline3.add(coolLabel);
		 
		 add(dataline4);
		 dataline4.add(acheLabel);
		 
		 add(dataline5);
		 dataline5.add(yes);
		 dataline5.add(no);
		 
		 add(dataline6);
		 dataline6.add(soreLabel);
		 
		 add(dataline7);
		 dataline7.add(yes);
		 dataline7.add(no);
		 
		 add(dataline8);
		 dataline8.add(submit);
		 
	 }
}
