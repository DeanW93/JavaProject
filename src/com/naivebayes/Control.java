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

public class Control {

	public static void main(String[] args) {
		
		FileProcessor fp = new FileProcessor("DataSet.txt");
		Training TrData = new Training();
		fp.ReadData();

	}

}
