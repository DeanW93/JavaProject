/*
 * FileManager CLASS
 * Author: Dean Whelan
 * Date: 01/04/19
 * 
 * Description: 
 * 
 * 		This class displays the file manager for the user allowing the user to dynamiccaly train the software from a dataset.
 * 		
 * 		The user will be shown clear instructions on how to use this window, before the page displays. 
 * 
 * 		The user may use the slider provided to specify the percentage of the dataset they wish to use as "training data" and 
 * 		the user is informed that the remaining data will be used by the program to self evaluate itself.
 * 
 * 		The user may then select a dataset of their choice using a file chooser object. This displays a panel allowing the user to
 * 		browse their local directories and choose a file of their preference
 * 
 * 		NOTE: the file type is locked to .txt format, thsi prevents the user from selecting the wrong file type.
 */






package com.naivebayes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
	    slider.setValue(100);
		
	    //File chooser
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		fileChooser = new JFileChooser();
		fileChooser.addActionListener(this);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(filter);
		
		
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
			//File processor object
			fp = new FileProcessor(slider.getValue());
			GUI.patientEvalButton.setEnabled(true);
			File selectedFile = fileChooser.getSelectedFile();
			fp.setDataSet(selectedFile);
			fp.ReadData();
			System.out.println(" \n\nHOT =>" + Control.getTraining().hot + " \n\nNORMAL =>" + Control.getTraining().normal + " \n\nCOOL =>" + Control.getTraining().cool);
			System.out.println(" \n\nACHE =>" + Control.getTraining().ache + " \n\n NO ACHE =>" + Control.getTraining().no_ache);
			System.out.println(" \n\nSORE =>" + Control.getTraining().sore + " \n\n NOT SORE =>" + Control.getTraining().not_sore);
			
			//Evaluation of eval_patients
			
			//Number of times tonsillitis is predicted accurately
			double correct_predictions = 0;
			double predictions = fp.getEval_patients().length;
			double accuracy;
			
			/*
			 * Data evaluation loop
			 * 
			 * Description: This for loop iterates through each patient stored in the eval_patients array. 
			 * The algorithm tries to predict the final posterior probability of tonsillitis with given symptoms 
			 * and checks its results to see if it has predicted correctly.
			 * 
			 * EXAMPLE:
			 * 
			 * {
			 * 		If posterior probability of tonsillitis in eval_patient[1] is greater than posterior probability of no tonsillitis 
			 * 
			 * 		AND
			 * 
			 * 		If tonsillitis in that given patient is yes according to the dataset, then the correct_predictions variable is incremented.
			 * 
			 * 		From this we can evaluate the accuracy of the programn with given data by displaying the success rate(%) for the user. 
			 * }
			 * 
			 * 
			 * Success rate is simply: (correct_predictions / size of eval_patients[])
			 * 
			 * 
			 */
			for( int i = 0 ; i < fp.getEval_patients().length ; i++ )
			{
				//Object used to calculate probabilities
				ProbabilityCalculator nb = new ProbabilityCalculator();
				
				//Calls method of probability calculator to perform operations
				nb.NaiveBayesAlgorithm(fp.getEval_patient(i), FileManager.fp.getTonsillitis_count(), FileManager.fp.getHot_count(), FileManager.fp.getNormal_count(), FileManager.fp.getCool_count(), FileManager.fp.getAche_count(), FileManager.fp.getNo_ache_count(), 
												FileManager.fp.getSore_count(), FileManager.fp.getNot_sore_count(), FileManager.fp.CheckDataSize(), Control.getTraining().hot, Control.getTraining().normal, Control.getTraining().cool, 
												Control.getTraining().ache, Control.getTraining().no_ache, Control.getTraining().sore, Control.getTraining().not_sore);
				
				//Checks if prediction using final posterior probability was correct or accurate
				if(fp.getEval_patient(i).isTonsillitis() == true && nb.getPtonsillitis_given_instance() > nb.getPno_tonsillitis_given_instance())
				{
					correct_predictions++;
				}
				else if(fp.getEval_patient(i).isTonsillitis() == false && nb.getPtonsillitis_given_instance() < nb.getPno_tonsillitis_given_instance())
				{
					correct_predictions++;
				}
				
			}
			
			DecimalFormat df = new DecimalFormat("#.##");
			df.setRoundingMode(RoundingMode.CEILING);
			
			accuracy = (correct_predictions / predictions)*100;
			
			hide();
			if(slider.getValue() < 100)
			{
				JOptionPane.showMessageDialog(null, "File Processed!\n\n"
													+ slider.getValue() + "% of data was trained. Remaining data has been used for self evaluation."
													+ "\n\nResults:"
													+ "\n\nAlgorithm predicted tonsillitis status in each patient in the evaluation portion of the dataset with " + df.format(accuracy) + "% accuracy.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "File Processed!\n\n"
													+ "100% of data has been trained, no data remaining to self evaluate."
													+ "\n\nPlease use our patient evaluation feature from the main menu!");
										
			}
		}
		//When cancel is pressed weindow is hidden rather than closed
		else if (command.equals(JFileChooser.CANCEL_SELECTION))
		{
			hide();
		}
	}
}

