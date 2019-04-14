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
	
	
	
	//Ratio variable indicates percentage of data set to be used for training, remainder w
	
	


	public Training()
    {
		hot = new boolean[100]; 
		normal = new boolean[100]; 
		cool = new boolean[100]; 
		
		ache  = new boolean[100];
		no_ache = new boolean[100];
		
		sore  = new boolean[100]; 
		not_sore  = new boolean[100]; ;
    }

}
