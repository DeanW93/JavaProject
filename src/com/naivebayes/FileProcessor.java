package com.naivebayes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor
{
	//Training attributes
	private File DataSet;
	private Training training;
	private Patient[] patients;
	
	//Symptom counters
	private double tonsillitis_count;
	private double hot_count;
	private double normal_count;
	private double cool_count;
	private double ache_count;
	private double no_ache_count;
	private double sore_count;
	private double not_sore_count;
	
	public FileProcessor(String DataSet)
	{
		setDataSet(DataSet);
		setTraining(new Training());
	}
	
	public FileProcessor(File chosenFile)
	{
		setDataSet(chosenFile);
		setTraining(new Training());
	}
	
	public FileProcessor() {}
	
	
	//Methods:
	
	
	/*
	 * Check Data size method:
	 * 
	 * Description: Counts how many patient entries are in the given data set
	 * 
	 */
	
	public double CheckDataSize()
	{
		double count_lines = 0;
		
		try
		{
			Scanner ReadData = new Scanner(DataSet);
			while(ReadData.hasNextLine())
			{
				System.out.println(ReadData.nextLine());
				count_lines++;
				System.out.println("\n\nline " + count_lines + " counted...");
			}
			ReadData.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count_lines;
		
	}
	
	
	/*
	 * Read Data method:
	 * 
	 * Description:
	 * 
	 */
	public void ReadData()
	{
		
		
		patients = new Patient[(int) CheckDataSize()];
		
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
			 * 
			 * 		tonsillitis_count: Initializes a counter for the total number of patients with tonsillitis 
			 * 							in the data set, used later in the NAive Bayes Algorithm
			 */
			int i=0;	
			int j=0;
			setTonsillitis_count(0);
			
			while(ReadData.hasNextLine()) 
			{
				
				if(i > 3)
				{
					i = 0;
				}
				
				
				
				if(i == 0)
				{
					
					System.out.println("Creating patient...");
					patients[j] = new Patient();
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
									hot_count++;
									patients[j].setTemperature("hot");
									break;
								}
								case "normal":
								{	
									normal_count++;
									patients[j].setTemperature("normal");
									break;
								}	
								case "cool":
								{	
									cool_count++;
									patients[j].setTemperature("cool");
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
								ache_count++;
								patients[j].setAches(true);
								break;
							}
							case "yes":
							{
								ache_count++;
								patients[j].setAches(true);
								break;
							}
							case "No":
							{	
								no_ache_count++;
								patients[j].setAches(false);
								break;
							}
							case "no":
							{	
								no_ache_count++;
								patients[j].setAches(false);
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
								setSore_count(getSore_count() + 1);
								patients[j].setSoreThroat(true);
								
								break;
							}
							case "yes":
							{
								setSore_count(getSore_count() + 1);
								patients[j].setSoreThroat(true);
								
								break;
							}
							
							case "No":
							{	
								setNot_sore_count(getNot_sore_count() + 1);
								patients[j].setSoreThroat(false);
								break;
							}
							case "no":
							{	
								setNot_sore_count(getNot_sore_count() + 1);
								patients[j].setSoreThroat(false);
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
								tonsillitis_count++;
								patients[j].setTonsillitis(true);
								break;
							}
							case "yes":
							{
								tonsillitis_count++;
								patients[j].setTonsillitis(true);
								break;
							}
							case "No":
							{	
								patients[j].setTonsillitis(false);
								break;
							}	
							case "no":
							{	
								patients[j].setTonsillitis(false);
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
					if(patients[j].isTonsillitis())
					{
						if(patients[j].getTemperature() == "hot")			//Patient is hot, HAS tonsillitis
						{
							Control.getTraining().hot.add(true);
						}
						else if(patients[j].getTemperature() == "normal")	//Patient is normal, HAS tonsillitis
						{
							Control.getTraining().normal.add(true);
						}
						else if(patients[j].getTemperature() == "cool")		//Patient is cool, HAS tonsillitis
						{
							Control.getTraining().cool.add(true);
						}
					}
					else
					{
						if(patients[j].getTemperature() == "hot")			//Patient is hot, NO tonsillitis
						{
							Control.getTraining().hot.add(false);
						}
						else if(patients[j].getTemperature() == "normal")	//Patient is normal, NO tonsillitis
						{
							Control.getTraining().normal.add(false);
						}
						else if(patients[j].getTemperature() == "cool")		//Patient is cool, NO tonsillitis
						{
							Control.getTraining().cool.add(false);
						}
					}
					
					//POPULATE ACHES TRAINING ARRAYS
					if(patients[j].isTonsillitis())
					{
						if(patients[j].isAches())							
						{
							Control.getTraining().ache.add(true);											//Patient has aches, HAS tonsillitis
						}
						else
						{
							Control.getTraining().no_ache.add(true);										//Patient has no aches, HAS tonsillitis
						}
					}
					else
					{
						if(patients[j].isAches())
						{
							Control.getTraining().ache.add(false);										//Patient has aches, NO tonsillitis
						}
						else
						{
							Control.getTraining().no_ache.add(false);										//Patient has no aches, NO tonsillitis
						}
					}
					
					//POPULATE SORE THROAT ARRAYS
					if(patients[j].isTonsillitis())
					{
						if(patients[j].isSoreThroat())
						{
							Control.getTraining().sore.add(true);											//Patient has sore throat, HAS tonsillitis
						}
						else
						{
							Control.getTraining().not_sore.add(true);										//Patient has no sore throat, HAS tonsillitis
						}
					}
					else
					{
						if(patients[j].isSoreThroat())
						{
							
							Control.getTraining().sore.add(false);										//Patient has sore throat, NO tonsillitis
						}
						else
						{
							Control.getTraining().not_sore.add(false);									//Patient has no sore throat, NO tonsillitis
						}
					}
				}
				
				if(i > 2)
				{
					System.out.println(patients[j].getTemperature() + " " + patients[j].isAches() + " " + patients[j].isSoreThroat() + " " + patients[j].isTonsillitis() );
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
	
	/*
	 * Getters and Setters
	 */
	
	public void setDataSet(String DataSet)
	{
		this.DataSet = new File(DataSet);
	}
	
	public void setDataSet(File chosenFile)
	{
		this.DataSet = chosenFile;
	}


	public Training getTraining() {
		return training;
	}


	public void setTraining(Training training) {
		this.training = training;
	}


	public double getTonsillitis_count() {
		return tonsillitis_count;
	}


	public void setTonsillitis_count(double tonsillitis_count) {
		this.tonsillitis_count = tonsillitis_count;
	}

	public double getHot_count() {
		return hot_count;
	}

	public void setHot_count(double hot_count) {
		this.hot_count = hot_count;
	}

	public double getNormal_count() {
		return normal_count;
	}

	public void setNormal_count(double normal_count) {
		this.normal_count = normal_count;
	}

	public double getCool_count() {
		return cool_count;
	}

	public void setCool_count(double cool_count) {
		this.cool_count = cool_count;
	}

	public double getAche_count() {
		return ache_count;
	}

	public void setAche_count(double ache_count) {
		this.ache_count = ache_count;
	}

	public double getNo_ache_count() {
		return no_ache_count;
	}

	public void setNo_ache_count(double no_ache_count) {
		this.no_ache_count = no_ache_count;
	}

	public double getSore_count() {
		return sore_count;
	}

	public void setSore_count(double sore_count) {
		this.sore_count = sore_count;
	}

	public double getNot_sore_count() {
		return not_sore_count;
	}

	public void setNot_sore_count(double not_sore_count) {
		this.not_sore_count = not_sore_count;
	}
}
