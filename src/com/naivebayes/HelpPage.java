package com.naivebayes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpPage extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	JPanel header;
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
		 
		 headerText = new JLabel();
		 headerText.setText("Help Page");
		 headerText.setFont(new Font("", Font.PLAIN, 35));
		 
		 add(header);
		 header.add(headerText);
	 }
}
