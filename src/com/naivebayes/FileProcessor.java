package com.naivebayes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor
{
	private File DataSet;
	Training training;
	
	public FileProcessor(String DataSet)
	{
		setDataSet(DataSet);
		training = new Training();
	}
	
	public void setDataSet(String DataSet)
	{
		this.DataSet = new File(DataSet);
	}
	
	public void ReadData()
	{
		try 
		{
			Scanner ReadData = new Scanner(DataSet);
			/*	
			 * 		i variable: Index for matching switch to the index on the data set file, example: 
			 * 					if index is on a temperature token, i will be 0, thus the temperature 
			 * 					case will be active within that iteration of the while loop below.
			 * 
			 * 		j variable: Index for patient list. This list contains each line as a patient object,
			 * 					storing the relevant data in attributes for later use.
			 */
			int i=0;	
			int j=0;
			
			while(ReadData.hasNextLine()) 
			{
				
				if(i > 3)
				{
					i = 0;
				}
				
				
				
				if(i == 0)
				{
					
					System.out.println("Creating patient...");
					Control.patients[j] = new Patient();
				}
				
				
				
				switch(i)
				{
					//Temperature check
					case 0:
					{
							switch(ReadData.next())
							{
								case "hot":
								{
									Control.patients[j].setTemperature("hot");
									break;
								}
								case "normal":
								{	
									Control.patients[j].setTemperature("normal");
									break;
								}	
								case "cool":
								{	
									Control.patients[j].setTemperature("cool");
									break;
								}	
								default:
								{	
									System.out.println("Error: ReadData() Nested switch case 0 index out of range, please contact program administrator.");
								}	
							}
							
							break;
							
					}
					//Aches check
					case 1:
					{
						switch(ReadData.next())
						{
							case "Yes":
							{
								Control.patients[j].setAches(true);
								break;
							}
							case "yes":
							{
								Control.patients[j].setAches(true);
								break;
							}
							case "No":
							{	
								Control.patients[j].setAches(false);
								break;
							}
							case "no":
							{	
								Control.patients[j].setAches(false);
								break;
							}	
							default:
							{
								System.out.println("Error: ReadData() Nested switch case 1 index out of range, please contact program administrator.");
							}
						}
						
						break;
							
							
					}
					//Sore throat check
					case 2:
					{
						switch(ReadData.next())
						{
							case "Yes":
							{
								Control.patients[j].setSoreThroat(true);
								
								break;
							}
							case "yes":
							{
								Control.patients[j].setSoreThroat(true);
								
								break;
							}
							
							case "No":
							{	
								Control.patients[j].setSoreThroat(false);
								break;
							}
							case "no":
							{	
								Control.patients[j].setSoreThroat(false);
								break;
							}	
							default:
							{
								System.out.println("Error: ReadData() Nested switch case 2 index out of range, please contact program administrator.");
							}
						}
						
						break;
							
							
					}
					//tonsillitis check
					case 3:
					{
						switch(ReadData.next())
						{
							case "Yes":
							{
								Control.patients[j].setTonsillitis(true);
								break;
							}
							case "yes":
							{
								Control.patients[j].setTonsillitis(true);
								break;
							}
							case "No":
							{	
								Control.patients[j].setTonsillitis(false);
								break;
							}	
							case "no":
							{	
								Control.patients[j].setTonsillitis(false);
								break;
							}	
							default:
							{
								System.out.println("Error: ReadData() Nested switch case 3 index out of range, please contact program administrator.");
							}
						}
						break;
						
						
					}
					default:
					{
						System.out.println("Error: ReadData() Outer switch index out of range, please contact program administrator.");
					}	
				
				}//end outer switch(i)
				
				
				
				/*
				 * The if() statements below populate the training attributes. This will help us calculate how many 
				 * patients Have symptom x WITH tonsillitis or symptom x with NO tonsillitis for use with the 
				 * Naive Bayes Algorithm.
				 * 
				 * (i == 3) is true once a full line has been scanned, then our program is ready to use this data 
				 * to populate the training attribute arrays before scanning the next line
				 */
			
				
				if(i == 3)
				{

					//POPULATE TEMPERATURE TRAINING ARRAYS
					if(Control.patients[j].isTonsillitis())
					{
						if(Control.patients[j].getTemperature() == "hot")			//Patient is hot, HAS tonsillitis
						{
							training.hot.add(true);
						}
						else if(Control.patients[j].getTemperature() == "normal")	//Patient is normal, HAS tonsillitis
						{
							training.normal.add(true);
						}
						else if(Control.patients[j].getTemperature() == "cool")		//Patient is cool, HAS tonsillitis
						{
							training.cool.add(true);
						}
					}
					else
					{
						if(Control.patients[j].getTemperature() == "hot")			//Patient is hot, NO tonsillitis
						{
							training.hot.add(false);
						}
						else if(Control.patients[j].getTemperature() == "normal")	//Patient is normal, NO tonsillitis
						{
							training.normal.add(false);
						}
						else if(Control.patients[j].getTemperature() == "cool")		//Patient is cool, NO tonsillitis
						{
							training.cool.add(false);
						}
					}
					
					//POPULATE ACHES TRAINING ARRAYS
					if(Control.patients[j].isTonsillitis())
					{
						if(Control.patients[j].isAches())							
						{
							training.ache.add(true);											//Patient has aches, HAS tonsillitis
						}
						else
						{
							training.no_ache.add(true);										//Patient has no aches, HAS tonsillitis
						}
					}
					else
					{
						if(Control.patients[j].isAches())
						{
							training.ache.add(false);										//Patient has aches, NO tonsillitis
						}
						else
						{
							training.no_ache.add(false);										//Patient has no aches, NO tonsillitis
						}
					}
					
					//POPULATE SORE THROAT ARRAYS
					if(Control.patients[j].isTonsillitis())
					{
						if(Control.patients[j].isSoreThroat())
						{
							training.sore.add(true);											//Patient has sore throat, HAS tonsillitis
						}
						else
						{
							training.not_sore.add(true);										//Patient has no sore throat, HAS tonsillitis
						}
					}
					else
					{
						if(Control.patients[j].isSoreThroat())
						{
							
							training.sore.add(false);										//Patient has sore throat, NO tonsillitis
						}
						else
						{
							training.not_sore.add(false);									//Patient has no sore throat, NO tonsillitis
						}
					}
				}
				
				if(i > 2)
				{
					System.out.println(Control.patients[j].getTemperature() + " " + Control.patients[j].isAches() + " " + Control.patients[j].isSoreThroat() + " " + Control.patients[j].isTonsillitis() );
					j++;
				}
				i++;
				
				
				
			}//end while
			
			
			ReadData.close();
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
