/*
 * CONTROL CLASS
 * Author: Dean Whelan
 * Date: 01/04/19
 * 
 * Description:
 * 
 * 
 */

package com.naivebayes;


public class Control
{
	
	static Training training =  new Training();
	//static Patient[] patients = new Patient[20];
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		
		
		FileProcessor fp = new FileProcessor("DataSet.txt");
		
		fp.ReadData();
		System.out.println(" \n\nHOT =>" + fp.getTraining().hot + " \n\nNORMAL =>" + fp.getTraining().normal + " \n\nCOOL =>" + fp.getTraining().cool);
		System.out.println(" \n\nACHE =>" + fp.getTraining().ache + " \n\n NO ACHE =>" + fp.getTraining().no_ache);
		System.out.println(" \n\nSORE =>" + fp.getTraining().sore + " \n\n NOT SORE =>" + fp.getTraining().not_sore);
		
		
	}

}