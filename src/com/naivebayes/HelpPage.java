package com.naivebayes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

public class HelpPage extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	JPanel header;
	JPanel dataline1;
	JPanel dataline2;
	
	JLabel headerText;

	public HelpPage(String title)
	 {
		 super(title);
		 setSize(400, 300);
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
		
		 
		 headerText = new JLabel();
		 headerText.setText("Help Page");
		 headerText.setFont(new Font("", Font.PLAIN, 35));
		 
		 add(header);
		 header.add(headerText);
		 
		 add(dataline1);
		 
		 add(dataline2);
	 }
}
