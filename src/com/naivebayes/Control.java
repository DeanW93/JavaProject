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
	
	public static void main(String[] args)
	{
		
		
		FileProcessor fp = new FileProcessor("DataSet.txt");
		
		fp.ReadData();
		System.out.println(" \n\n" + fp.training.hot + " \n\n" + fp.training.normal + " \n\n" + fp.training.cool);
		
	}

}