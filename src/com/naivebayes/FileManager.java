package com.naivebayes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileManager extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	JPanel header;
	JLabel headerText;
	JFileChooser fileChooser;
	
	public FileManager(String title)
	 {
		 super(title);
		 setSize(550, 450);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 setLayout(new FlowLayout());
		 setVisible(true);
		 setLocationRelativeTo(null);
		 setResizable(false);
		 
		 header = new JPanel();
		 header.setPreferredSize(new Dimension(550, 60));
		 header.setBackground(Color.cyan);
		 
		 headerText = new JLabel();
		 headerText.setText("File Manager");
		 headerText.setFont(new Font("", Font.PLAIN, 35));
		 
		 FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		 fileChooser = new JFileChooser();
		 fileChooser.addActionListener(this);
		 fileChooser.setAcceptAllFileFilterUsed(false);
		 fileChooser.setFileFilter(filter);
		 
		 add(header);
		 header.add(headerText);
		 add(fileChooser);
		 
	 }
	
	public void actionPerformed(ActionEvent actionEvent)
	{
		String command = actionEvent.getActionCommand();
		if (command.equals(JFileChooser.APPROVE_SELECTION))
		{
			File selectedFile = fileChooser.getSelectedFile();
			FileProcessor fp = new FileProcessor(selectedFile);
			fp.ReadData();
			JOptionPane.showMessageDialog(null, "File Processed!");
		}
		else if (command.equals(JFileChooser.CANCEL_SELECTION))
		{
			dispose();
		}
	}
}

