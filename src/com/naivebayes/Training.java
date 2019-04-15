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

import java.util.ArrayList;

public class Training {
	
	/*
	 * 	Attributes:
	 * 
	 * 	boolean: true implies instance of attribute with tonsillitis, false implies instance with no tonsillitis
	 */
	
	//Temperature:
	
	ArrayList<Boolean> hot;
	ArrayList<Boolean> normal;
	ArrayList<Boolean> cool;
	
	//Aches
	
	ArrayList<Boolean> ache;
	ArrayList<Boolean> no_ache;
	
	//Sore Throat
	
	ArrayList<Boolean> sore;
	ArrayList<Boolean> not_sore;
	
	
	
	//Ratio variable indicates percentage of data set to be used for training, remainder w
	
	


	public Training()
    {
		hot = new ArrayList<>(); 
		normal = new ArrayList<>(); 
		cool = new ArrayList<>(); 
		
		ache  = new ArrayList<>();
		no_ache = new ArrayList<>();
		
		sore  = new ArrayList<>(); 
		not_sore  = new ArrayList<>();
    }

}
