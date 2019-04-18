/*
 * CONTROL CLASS
 * Author: Dean Whelan
 * Date: 01/04/19
 * 
 * Description:
 * 
 * This class contains a static training object which stores the training data 
 * from the dataset to be used in the NaiveBayesAlgorithm() method.
 * 
 * This class also runs the implemented GUI interface for using the program.
 * 
 * 
 */

package com.naivebayes;

public class Control
{
	//Training data object
	private static Training training =  new Training();
	
	
	//GUI main menu interface
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		GUI menu = new GUI("Naive Bayes");	
	}
	
	
	
	//Training getters and setters
	
	public static Training getTraining() {
		return training;
	}

	public static void setTraining(Training training) {
		Control.training = training;
	}


}