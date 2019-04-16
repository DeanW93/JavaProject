package com.naivebayes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.border.SoftBevelBorder;

public class PatientEvaluation extends JFrame implements ActionListener
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
		 
		 //PANELS
		 
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
		 
		 
		 //LABELS
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
		 soreLabel.setText("Sore Throat");
		 
		 acheyes = new JLabel();
		 acheyes.setText("Yes: ");
		 
		 acheno = new JLabel();
		 acheno.setText("No: ");
		 
		 soreyes = new JLabel();
		 soreyes.setText("Yes: ");
		 
		 soreno = new JLabel();
		 soreno.setText("No: ");
		 
		 submit = new JButton("Submit");
		 submit.addActionListener(this);
		 
		 //CHECKBOXES
		 hotbox = new JCheckBox();	 
		 hotbox.addActionListener(this);
		 
		 normbox = new JCheckBox();
		 normbox.addActionListener(this);
		 
		 coolbox = new JCheckBox();
		 coolbox.addActionListener(this);
		 
		 acheYesbox = new JCheckBox();
		 acheYesbox.addActionListener(this);
		 acheNobox = new JCheckBox();
		 acheNobox.addActionListener(this);
		 
		 soreYesbox = new JCheckBox();
		 soreYesbox.addActionListener(this);
		 soreNobox = new JCheckBox();
		 soreNobox.addActionListener(this);
		 
		 
		 
		 
		 
		 
		 //ADD COMPONENTS
		 
		 add(header);						//Page title
		 header.add(headerText);
		 
		 add(dataline1);					//Instructions
		 dataline1.add(instructionsText);
		 
		 add(dataline2);					//Temperature heading
		 dataline2.add(tempLabel);
		 
		 add(dataline3);					//Checkboxes with labels
		 dataline3.add(hotLabel);
		 dataline3.add(hotbox);
		 dataline3.add(normalLabel);
		 dataline3.add(normbox);
		 dataline3.add(coolLabel);
		 dataline3.add(coolbox);
		 
		 add(dataline4);					//Ache heading
		 dataline4.add(acheLabel);
		 
		 add(dataline5);					//Checkboxes with labels
		 dataline5.add(acheyes);
		 dataline5.add(acheYesbox);
		 dataline5.add(acheno);
		 dataline5.add(acheNobox);
		 
		 add(dataline6);					//Sore heading
		 dataline6.add(soreLabel);
		 
		 add(dataline7);					//Checkboxes with labels
		 dataline7.add(soreyes);
		 dataline7.add(soreYesbox);
		 dataline7.add(soreno);
		 dataline7.add(soreNobox);
		 
		 add(dataline8);					//Submit data button
		 dataline8.add(submit);
		 
	 }


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		if(e.getSource() == hotbox)
		{
			if(hotbox.isSelected())
			{
				normbox.setSelected(false);
				coolbox.setSelected(false);
			}
		}
		else if(e.getSource() == normbox)
		{
			if(normbox.isSelected())
			{
				hotbox.setSelected(false);
				coolbox.setSelected(false);
			}
		}
		else if(e.getSource() == coolbox)
		{
			if(coolbox.isSelected())
			{
				normbox.setSelected(false);
				hotbox.setSelected(false);
			}
		}	
		else if(e.getSource() == acheYesbox)
		{
			if(acheYesbox.isSelected())
			{
				acheNobox.setSelected(false);
			}
		}
		else if(e.getSource() == acheNobox)
		{
			if(acheNobox.isSelected())
			{
				acheYesbox.setSelected(false);
			}
		}	
		else if(e.getSource() == soreYesbox)
		{
			if(soreYesbox.isSelected())
			{
				soreNobox.setSelected(false);
			}
		}
		else if(e.getSource() == soreNobox)
		{
			if(soreNobox.isSelected())
			{
				soreYesbox.setSelected(false);
			}
		}
		else if(e.getSource() == submit)
		{
			Patient patient = new Patient();
			
			if(hotbox.isSelected())
			{
				patient.setTemperature("hot");
			}
			else if(normbox.isSelected())
			{
				patient.setTemperature("normal");
			}
			else if(coolbox.isSelected())
			{
				patient.setTemperature("cool");
			}
			
			if(acheYesbox.isSelected())
			{
				patient.setAches(true);
			}
			else if(acheNobox.isSelected())
			{
				patient.setAches(false);
			}
			
			if(soreYesbox.isSelected())
			{
				patient.setSoreThroat(true);
			}
			else if(soreNobox.isSelected())
			{
				patient.setSoreThroat(false);
			}
			
			ProbabilityCalculator nb = new ProbabilityCalculator();

			nb.NaiveBayesAlgorithm(patient, FileManager.fp.getTonsillitis_count(), FileManager.fp.getHot_count(), FileManager.fp.getNormal_count(), FileManager.fp.getCool_count(), FileManager.fp.getAche_count(), FileManager.fp.getNo_ache_count(), 
											FileManager.fp.getSore_count(), FileManager.fp.getNot_sore_count(), FileManager.fp.CheckDataSize(), FileManager.fp.getTraining().hot, FileManager.fp.getTraining().normal, FileManager.fp.getTraining().cool, 
											FileManager.fp.getTraining().ache, FileManager.fp.getTraining().no_ache, FileManager.fp.getTraining().sore, FileManager.fp.getTraining().not_sore);
			
			JOptionPane.showMessageDialog(null, "\n\n P(Tonsillitis | X) = " + nb.getPtonsillitis_given_instance()
												+ "\n\n P(No Tonsillitis | X) = " + nb.getPno_tonsillitis_given_instance());
		}
	}
	
	
}
