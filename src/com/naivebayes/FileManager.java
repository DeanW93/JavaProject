package com.naivebayes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Hashtable;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class FileManager extends JFrame implements ActionListener
{
	//Static file processor object
	static FileProcessor fp;
	
	//Panels
	JPanel header;
	
	//Labels
	JLabel headerText;
	JLabel sliderLabel;
	
	//File chooser
	JFileChooser fileChooser;
	
	//Slider
	JSlider slider;
	
	
	//Page constructor
	public FileManager(String title)
	 {
		super(title);
		fp = new FileProcessor();
		
		//Page properties
		setSize(550, 500);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//Panels
		header = new JPanel();
		header.setPreferredSize(new Dimension(550, 60));
		header.setBackground(Color.cyan);
		
		//Labels
		headerText = new JLabel();
		headerText.setText("File Manager");
		headerText.setFont(new Font("", Font.PLAIN, 35));
		
		sliderLabel = new JLabel();
		sliderLabel.setText("Training Ratio");
		sliderLabel.setFont(new Font("", Font.PLAIN, 20));
		sliderLabel.setPreferredSize(new Dimension(125, 40));
		
		Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(0, new JLabel("0%"));
        labels.put(25, new JLabel("25%"));
        labels.put(50, new JLabel("50%"));
        labels.put(75, new JLabel("75%"));
        labels.put(100, new JLabel("100%"));
		
        //Slider
		slider = new JSlider(0, 100);
		slider.setPaintTicks(true);
	    slider.setSnapToTicks(true);
	    slider.setMajorTickSpacing(25);
	    slider.setMinorTickSpacing(5);
	    slider.setPaintLabels(true);
	    slider.setLabelTable(labels);
		
	    //File chooser
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		fileChooser = new JFileChooser();
		fileChooser.addActionListener(this);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(filter);
		
		//File processor object
		fp = new FileProcessor();
		
		
		//Add components
		add(header);
		header.add(headerText);
		add(sliderLabel);
		add(slider, "Snap to ticks");
		add(fileChooser);
	 }
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent actionEvent)
	{
		String command = actionEvent.getActionCommand();
		
		//When data set is chosena and opened, data is processed in file processor object and training data is populated. Results are printed in the console.
		if (command.equals(JFileChooser.APPROVE_SELECTION))
		{
			GUI.patientEvalButton.setEnabled(true);
			File selectedFile = fileChooser.getSelectedFile();
			fp.setDataSet(selectedFile);
			fp.ReadData();
			System.out.println(" \n\nHOT =>" + Control.getTraining().hot + " \n\nNORMAL =>" + Control.getTraining().normal + " \n\nCOOL =>" + Control.getTraining().cool);
			System.out.println(" \n\nACHE =>" + Control.getTraining().ache + " \n\n NO ACHE =>" + Control.getTraining().no_ache);
			System.out.println(" \n\nSORE =>" + Control.getTraining().sore + " \n\n NOT SORE =>" + Control.getTraining().not_sore);
					
			JOptionPane.showMessageDialog(null, "File Processed!");
		}
		//When cancel is pressed weindow is hidden rather than closed
		else if (command.equals(JFileChooser.CANCEL_SELECTION))
		{
			hide();
		}
	}

}

