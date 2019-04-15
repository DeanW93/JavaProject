package com.naivebayes;



import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {
	
	private JPanel panel1;
	
	private JButton button1;
	
	private JLabel label1;
	
	private GridBagConstraints m;
	private GridBagConstraints b;
	private GridBagConstraints p;
	private GridBagConstraints l;
	
	public MainMenu(String title)
	{
		super(title);
		setLayout(new GridBagLayout());
		
		m = new GridBagConstraints();
		m.gridheight = 3;
		m.gridwidth = 3;
		m.gridx = 0;
		m.gridy = 0;
		
		panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		panel1.setBackground(Color.RED);
		
		p = new GridBagConstraints();
		p.fill = GridBagConstraints.HORIZONTAL;
		p.gridx = 0;
		p.gridy = 0;
		p.weightx = 0.75;
        p.weighty = 1;
        p.gridheight = 1;
        p.gridwidth = 3;
        p.anchor = GridBagConstraints.FIRST_LINE_START;
        
		add(panel1, p);

		button1 = new JButton("Read Data set");
        
        b = new GridBagConstraints();
        b.fill = GridBagConstraints.BOTH;
		b.anchor = GridBagConstraints.PAGE_START;
        b.weightx = 1;
        b.weighty = 1;
        b.gridx = 1;
        b.gridy = 0;
        
        panel1.add(button1, b);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true); Fullscreen
		setVisible(true);
		
	}
	
	
	
	
	
	/*
	 * Getters / Setters
	 */
	
	public JPanel getPanel1() {
		return panel1;
	}
	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}
	public JButton getButton1() {
		return button1;
	}
	public void setButton1(JButton button1) {
		this.button1 = button1;
	}



	public JLabel getLabel1() {
		return label1;
	}



	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}



}
