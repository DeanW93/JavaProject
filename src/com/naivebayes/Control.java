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

import java.util.ArrayList;

public class Control
{
	private static Training training =  new Training();
	//static Patient[] patients = new Patient[20];
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		GUI menu = new GUI("Naive Bayes");	
		
//		FileProcessor fp = new FileProcessor("DataSet.txt");
//		
//		fp.ReadData();
//		System.out.println(" \n\nHOT =>" + fp.getTraining().hot + " \n\nNORMAL =>" + fp.getTraining().normal + " \n\nCOOL =>" + fp.getTraining().cool);
//		System.out.println(" \n\nACHE =>" + fp.getTraining().ache + " \n\n NO ACHE =>" + fp.getTraining().no_ache);
//		System.out.println(" \n\nSORE =>" + fp.getTraining().sore + " \n\n NOT SORE =>" + fp.getTraining().not_sore);
//		
//		Patient p1 = new Patient("hot", false, true);
//		
//		ProbabilityCalculator nb = new ProbabilityCalculator();
//		
//		nb.NaiveBayesAlgorithm(p1, fp.getTonsillitis_count(), fp.getHot_count(), fp.getNormal_count(), fp.getCool_count(), fp.getAche_count(), fp.getNo_ache_count(), 
//								fp.getSore_count(), fp.getNot_sore_count(), fp.CheckDataSize(), fp.getTraining().hot, fp.getTraining().normal, fp.getTraining().cool, 
//								fp.getTraining().ache, fp.getTraining().no_ache, fp.getTraining().sore, fp.getTraining().not_sore);
//		
//		System.out.println(" \n\n P(Tonsillitis | X) = " + nb.getPtonsillitis_given_instance());
//		System.out.println(" \n\n P(No Tonsillitis | X) = " + nb.getPno_tonsillitis_given_instance());
	}

	public static Training getTraining() {
		return training;
	}

	public static void setTraining(Training training) {
		Control.training = training;
	}


}