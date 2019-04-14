/*
 * TRAINING CLASS
 * Author: Dean Whelan
 * Date: 01/04/19
 * 
 * Description:
 * 
 * 
 */

package com.naivebayes;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Training {
	
	/*
	 * 	Attributes:
	 * 
	 * 	boolean: true implies tonsillitis, false implies no tonsillitis
	 */
	
	//Temperature:
	
	boolean[] hot; 
	boolean[] normal;
	boolean[] cool;
	
	//Aches
	
	boolean[] ache;
	boolean[] no_ache;
	
	//Sore Throat
	boolean[] sore;
	boolean[] not_sore;
	
	//Patient list
	List<Patient> patientlist = new ArrayList<Patient>(18);
	
	
	
	//Ratio variable indicates percentage of data set to be used for training, remainder will be used for testing
	private double ratio; 
	
	
	/*
	 * Constructor
	 */
	
	
	public Training()
    {
		
       
    }
	
	
	/*
	 * Methods
	 */
	
	
	
	
	
	
	
	
	/*
	 * GETTERS / SETTERS
	 */


	public double getRatio() {
		return ratio;
	}


	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	

}
