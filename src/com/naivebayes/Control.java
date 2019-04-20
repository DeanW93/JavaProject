/*
 * CONTROL CLASS
 * Author: Dean Whelan
 * Date: 01/04/19
 * 
 * 
 * Program Description:
 * 		
 * 
 * 		This program uses a Naive Bayes machine learning algorithm to predict the likelyhood of a patient having contracted tonsillitis with given symptoms.
 * 
 * 		The program uses a simple GUI to allow the user to train the program using a given dataset 
 * 		The user may manually enter patient symptoms and evaluate the probability of tonsillitis with custom symptoms.
 * 		The symptoms used in the evaluation are constrained to temperature / aches / sore throat. 
 * 
 *  	The program may dynamically train itself using a percentage of the dataset specified by the user and will evaluate itself with the remaining data.
 *  
 * 
 *  
 * 
 * 
 * Class Description:
 * 
 * 		This class contains a static training object which stores the training data 
 * 		from the dataset to be used in the NaiveBayesAlgorithm() method.
 * 
 * 		This class also runs the implemented GUI interface for using the program.
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
	
	public static Training getTraining() 
	{
		return training;
	}

	public static void setTraining(Training training) 
	{
		Control.training = training;
	}
	

}