package com.naivebayes;

import java.io.File;
import java.util.ArrayList;

public class ProbabilityCalculator extends Training
{
	
	
	private Patient userinput;
	private File DataSet;
	
	/*
	 * Probability Variables
	 * 
	 * 	NOTE: Variable name with yes represents the probability of patient having symptom true OR false AND having tonsillitis according to the data set, 
	 * 	it does not imply the symptom is true or false.
	 * 
	 * 	Example: If patient being evaluated has no aches, pache_yes represents the probability of the patient having no aches AND having tonsillitis 
	 * 	according to the data set.
	 */
	
	private double p_yes;
	private double p_no;
	private double ptemp_yes;
	private double ptemp_no;
	private double pache_yes;
	private double pache_no;
	private double psore_yes;
	private double psore_no;
	
	
	public ProbabilityCalculator() 
	{
		
	}
	
	public void NaiveBayesAlgorithm(Patient patient, int tonsillitis_count, int num_of_patients, ArrayList<Boolean> hot, ArrayList<Boolean> normal, ArrayList<Boolean> cool, 
									ArrayList<Boolean> ache, ArrayList<Boolean> no_ache, ArrayList<Boolean> sore, ArrayList<Boolean> no_sore)
	{
		p_yes = tonsillitis_count / num_of_patients;
		p_no = (tonsillitis_count - num_of_patients) / num_of_patients;
		
		switch(patient.getTemperature())
		{
			case "hot":
			{
				ptemp_yes = hot_With_tonsillitis(hot) / tonsillitis_count;
				ptemp_no = hot_Without_tonsillitis(hot) / tonsillitis_count;
			}
			case "normal":
			{
				
			}
			case "cool":
			{
				
			}
			default:
			{
				
			}
		}
	}
	
	
	/*
	 * 	The methods below use for loops to step through the training data and count how many times a given symptom occurs WITH tonsillitis
	 * 	and how many times a symptom occurs WITHOUT tonsillitis. This data is used in the Naive Bayes algorithm in the instanceEvaluator method.
	 */
	
	public int hot_With_tonsillitis(ArrayList<Boolean> hot)
	{
		int counter = 0;
		
		for(int i=0 ; i<hot.size() ; i++)
		{
			if(hot.get(i))
			{
				counter++;
			}
			else
			{
				
			}
			
		}
		
		return counter;
	}
	
	public int hot_Without_tonsillitis(ArrayList<Boolean> hot)
	{
		int counter = 0;
		
		for(int i=0 ; i<hot.size() ; i++)
		{
			if(hot.get(i))
			{
				
			}
			else
			{
				counter++;
			}
		}
		
		return counter;
	}
	
	public int cool_with_tonsillitis(ArrayList<Boolean> cool)
	{
		int counter = 0;
		
		for(int i=0 ; i<cool.size() ; i++)
		{
			if(cool.get(i))
			{
				counter++;
			}
			else
			{
				
			}
			
		}
		
		return counter;
	}
	
	public int cool_Without_tonsillitis(ArrayList<Boolean> cool)
	{
		int counter = 0;
		
		for(int i=0 ; i<cool.size() ; i++)
		{
			if(cool.get(i))
			{
				
			}
			else
			{
				counter++;
			}
			
		}
		
		return counter;
	}
	
	public int normal_with_tonsillitis(ArrayList<Boolean> normal)
	{
		int counter = 0;
		
		for(int i=0 ; i<normal.size() ; i++)
		{
			if(normal.get(i))
			{
				counter++;
			}
			else
			{
				
			}
			
		}
		
		return counter;
	}
	
	public int normal_Without_tonsillitis(ArrayList<Boolean> normal)
	{
		int counter = 0;
		
		for(int i=0 ; i<normal.size() ; i++)
		{
			if(normal.get(i))
			{
				
			}
			else
			{
				counter++;
			}
			
		}
		
		return counter;
	}
	
	public int ache_With_tonsillitis(ArrayList<Boolean> ache)
	{
		int counter = 0;
		
		for(int i=0 ; i<ache.size() ; i++)
		{
			if(ache.get(i))
			{
				counter++;
			}
			else
			{
				
			}
			
		}
		
		return counter;
	}
	
	public int ache_Without_tonsillitis(ArrayList<Boolean> ache)
	{
		int counter = 0;
		
		for(int i=0 ; i<ache.size() ; i++)
		{
			if(ache.get(i))
			{
				
			}
			else
			{
				counter++;
			}
			
		}
		
		return counter;
	}
	
	public int no_ache_with_tonsillitis(ArrayList<Boolean> no_ache)
	{
		int counter = 0;
		
		for(int i=0 ; i<no_ache.size() ; i++)
		{
			if(no_ache.get(i))
			{
				counter++;
			}
			else
			{
				
			}
			
		}
		
		return counter;
	}
	
	public int no_ache_Without_tonsillitis(ArrayList<Boolean> no_ache)
	{
		int counter = 0;
		
		for(int i=0 ; i<no_ache.size() ; i++)
		{
			if(no_ache.get(i))
			{
				
			}
			else
			{
				counter++;
			}
			
		}
		
		return counter;
	}
	
	public int sore_With_tonsillitis(ArrayList<Boolean> sore)
	{
		int counter = 0;
		
		for(int i=0 ; i<sore.size() ; i++)
		{
			if(sore.get(i))
			{
				counter++;
			}
			else
			{
				
			}
			
		}
		
		return counter;
	}
	
	public int sore_Without_tonsillitis(ArrayList<Boolean> sore)
	{
		int counter = 0;
		
		for(int i=0 ; i<sore.size() ; i++)
		{
			if(sore.get(i))
			{
				
			}
			else
			{
				counter++;
			}
			
		}
		
		return counter;
	}
	
	public int not_sore_with_tonsillitis(ArrayList<Boolean> not_sore)
	{
		int counter = 0;
		
		for(int i=0 ; i<not_sore.size() ; i++)
		{
			if(not_sore.get(i))
			{
				counter++;
			}
			else
			{
				
			}
			
		}
		
		return counter;
	}
	
	public int not_sore_Without_tonsillitis(ArrayList<Boolean> not_sore)
	{
		int counter = 0;
		
		for(int i=0 ; i<not_sore.size() ; i++)
		{
			if(not_sore.get(i))
			{
				
			}
			else
			{
				counter++;
			}
			
		}
		
		return counter;
	}
	
	
}
