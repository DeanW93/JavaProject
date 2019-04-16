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

public class FileManager extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	static FileProcessor fp;
	JPanel header;
	JLabel headerText;
	JFileChooser fileChooser;
	JLabel sliderLabel;
	JSlider slider;
	
	public FileManager(String title)
	 {
		super(title);
		fp = new FileProcessor();
		
		setSize(550, 500);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		
		slider = new JSlider(0, 100);
		slider.setPaintTicks(true);
	    slider.setSnapToTicks(true);
	    slider.setMajorTickSpacing(25);
	    slider.setMinorTickSpacing(5);
	    slider.setPaintLabels(true);
	    slider.setLabelTable(labels);
		 
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		fileChooser = new JFileChooser();
		fileChooser.addActionListener(this);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(filter);
		
		
		
		add(header);
		header.add(headerText);
		add(sliderLabel);
		add(slider, "Snap to ticks");
		add(fileChooser);
	 }
	
	public void actionPerformed(ActionEvent actionEvent)
	{
		String command = actionEvent.getActionCommand();
		if (command.equals(JFileChooser.APPROVE_SELECTION))
		{
			File selectedFile = fileChooser.getSelectedFile();
			fp = new FileProcessor(selectedFile);
			fp.ReadData();
			System.out.println(" \n\nHOT =>" + fp.getTraining().hot + " \n\nNORMAL =>" + fp.getTraining().normal + " \n\nCOOL =>" + fp.getTraining().cool);
			System.out.println(" \n\nACHE =>" + fp.getTraining().ache + " \n\n NO ACHE =>" + fp.getTraining().no_ache);
			System.out.println(" \n\nSORE =>" + fp.getTraining().sore + " \n\n NOT SORE =>" + fp.getTraining().not_sore);
			
			Patient p1 = new Patient("hot", false, true);
			
			ProbabilityCalculator nb = new ProbabilityCalculator();
			
			nb.NaiveBayesAlgorithm(p1, fp.getTonsillitis_count(), fp.getHot_count(), fp.getNormal_count(), fp.getCool_count(), fp.getAche_count(), fp.getNo_ache_count(), 
									fp.getSore_count(), fp.getNot_sore_count(), fp.CheckDataSize(), fp.getTraining().hot, fp.getTraining().normal, fp.getTraining().cool, 
									fp.getTraining().ache, fp.getTraining().no_ache, fp.getTraining().sore, fp.getTraining().not_sore);
			
			JOptionPane.showMessageDialog(null, "File Processed!"
												+ "\n\n P(Tonsillitis | X) = " + nb.getPtonsillitis_given_instance()
												+ "\n\n P(No Tonsillitis | X) = " + nb.getPno_tonsillitis_given_instance());
		}
		else if (command.equals(JFileChooser.CANCEL_SELECTION))
		{
			hide();
		}
	}

}

