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
	static Patient[] patients = new Patient[20];
	static Training training =  new Training();
	
	public static void main(String[] args)
	{
		FileProcessor fp = new FileProcessor("DataSet.txt");
		
		fp.ReadData();
		
	}

}