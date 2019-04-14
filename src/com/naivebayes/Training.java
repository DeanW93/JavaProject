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
	
	//Patient list
	Patient[] patient;
	
	
	
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
			int i=0;
			int j=-1;
			
			while(ReadData.hasNextLine()) 
			{
				if(i > 3)
				{
					i = 0;
				}
				
				if(i == 0)
				{
					j++;
				}
				
				switch(i)
				{
					//Temperature check
					case 0:
					{
							switch(ReadData.next())
							{
								case "hot":
									
									break;
								
								case "normal":
									
									break;
									
								case "cool":
									
									break;
									
								default:
									
									break;
							}		
							
					}
					//Aches check
					case 1:
						{
							switch(ReadData.next())
							{
							case "yes":
								
								break;
							
							case "no":
								
								break;
								
							default:
								break;
							}
							
							
						}
					//Sore throat check
					case 2:
						{
							switch(ReadData.next())
							{
							case "yes":
								
								break;
							
							case "no":
								
								break;
								
							default:
								break;
							}
							
							
						}
					//tonsillitis check
					case 3:
						{
							switch(ReadData.next())
							{
							case "yes":
								
								break;
							
							case "no":
								
								break;
								
							default:
								break;
							}
							
							
						}
					
					System.out.println(ReadData.next());
				
				}//end outer switch(i)
			
			
			}//end while
			
			ReadData.close();
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
