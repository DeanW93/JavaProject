/*
 * TRAINING CLASS
 * Author: Dean Whelan
 * Date: 
 * 
 * Description:
 * 
 * 
 */

package com.naivebayes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Training {
	
	/*
	 * 	Attributes:
	 * 
	 * 	boolean true implies tonsillitis, false implies no tonsillitis
	 */
	
	//Temperature:
	
	boolean[] hot; 
	boolean[] normal;
	boolean[] cool;
	
	//Aches
	
	boolean[] ache;
	
	//Sore Throat
	boolean[] sore;
	
	
	
	
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
	
	public void ReadData()
	{
		File DataSet = new File("DataSet.txt");

	
		
		
				
		try 
		{
			Scanner ReadData = new Scanner(DataSet);
			while(ReadData.hasNextLine()) {
			System.out.println(ReadData.next());
		}
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
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
