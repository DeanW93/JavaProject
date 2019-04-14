package com.naivebayes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {
	
	File DataSet;
	
	public FileProcessor(String filepath)
	{
		 DataSet = new File(filepath);
	}
	
	/*
	 * ReadData():
	 * Description:
	 */
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
					Patient patient = new Patient();
					patientlist.add(patient);
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
									patientlist.get(j).setTemperature("hot");
									break;
								}
								case "normal":
								{	
									patientlist.get(j).setTemperature("normal");
									break;
								}	
								case "cool":
								{	
									patientlist.get(j).setTemperature("cool");
									break;
								}	
								default:
								{	
									System.out.println("Error: ReadData() Nested switch index out of range, please contact program administrator.");
									break;
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
								patientlist.get(j).setAches(true);
								break;
							}
							case "No":
							{	
								patientlist.get(j).setAches(false);
								break;
							}	
							default:
							{
								System.out.println("Error: ReadData() Nested switch index out of range, please contact program administrator.");
								break;
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
								patientlist.get(j).setSore_throat(true);
								
								break;
							}
							case "No":
							{	
								patientlist.get(j).setSore_throat(false);
								break;
							}	
							default:
							{
								System.out.println("Error: ReadData() Nested switch index out of range, please contact program administrator.");
								break;
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
								patientlist.get(j).setTonsillitis(true);
								break;
							}
							case "No":
							{	
								patientlist.get(j).setTonsillitis(false);
								break;
							}	
							default:
							{
								System.out.println("Error: ReadData() Nested switch index out of range, please contact program administrator.");
								break;
							}
						}
						break;
						
						
					}
					default:
					{
						System.out.println("Error: ReadData() Outer switch index out of range, please contact program administrator.");
						break;
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
					
					if(patientlist.get(j).hasTonsillitis())
					{
						if(patientlist.get(j).getTemperature() == "hot")			//Patient is hot, HAS tonsillitis
						{
							hot[j] = true;
						}
						else if(patientlist.get(j).getTemperature() == "normal")	//Patient is normal, HAS tonsillitis
						{
							normal[j] = true;
						}
						else if(patientlist.get(j).getTemperature() == "cool")		//Patient is cool, HAS tonsillitis
						{
							cool[j] = true;
						}
					}
					else
					{
						if(patientlist.get(j).getTemperature() == "hot")			//Patient is hot, NO tonsillitis
						{
							hot[j] = false;
						}
						else if(patientlist.get(j).getTemperature() == "normal")	//Patient is normal, NO tonsillitis
						{
							normal[j] = false;
						}
						else if(patientlist.get(j).getTemperature() == "cool")		//Patient is cool, NO tonsillitis
						{
							cool[j] = false;
						}
					}
					
					//POPULATE ACHES TRAINING ARRAYS
					
					if(patientlist.get(j).hasTonsillitis())
					{
						if(patientlist.get(j).hasAches())							//Patient has aches, HAS tonsillitis
						{
							ache[j] = true;
						}
						else
						{
							no_ache[j] = true;										//Patient has no aches, HAS tonsillitis
						}
					}
					else
					{
						if(patientlist.get(j).hasAches())
						{
							ache[j] = false;										//Patient has aches, NO tonsillitis
						}
						else
						{
							no_ache[j] = false;										//Patient has no aches, NO tonsillitis
						}
					}
					
					//POPULATE SORE THROAT ARRAYS
					
					if(patientlist.get(j).hasTonsillitis())
					{
						if(patientlist.get(j).hasSore_throat())
						{
							sore[j] = true;											//Patient has sore throat, HAS tonsillitis
						}
						else
						{
							not_sore[j] = true;										//Patient has no sore throat, HAS tonsillitis
						}
					}
					else
					{
						if(patientlist.get(j).hasSore_throat())
						{
							sore[j] = false;										//Patient has sore throat, NO tonsillitis
						}
						else
						{
							not_sore[j] = false;									//Patient has no sore throat, NO tonsillitis
						}
					}
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
