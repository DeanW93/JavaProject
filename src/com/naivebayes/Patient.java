/*
 * PATIENT CLASS
 * Author: Dean Whelan
 * Date: 01/04/19
 * 
 * Description:
 * 
 * 	This is a patient object. It is instantiated and populated for every patient in the training patient array, 
 * 	as well as every patient in the evaluation patients array. This is also instantiated when a custom patient 
 * 	is tested on the Patent evaluation GUI page in the program.
 * 
 * 	Each patient object contains attributes for each symptom and wether they have tonsillitis or not  which allows the model
 * 	to analyse patterns most associated with tonsillitis.
 * 	
 * Constructors:
 * 
 * 	There is an empty constructor used to populate arrays and a custom instructor for the patient evaluation interface allowing for custom patients to be evaluated.
 * 
 * 
 */


package com.naivebayes;

public class Patient
{
	//Attributes
	private String temperature;
	private boolean aches;
	private boolean soreThroat;
	private boolean tonsillitis;
	
	//Constructors
	public Patient() {};
	public Patient(String temperature, boolean aches, boolean soreThroat)
	{
		this.temperature = temperature;
		this.aches = aches;
		this.soreThroat = soreThroat;
	}
	
	
	//Getters and setters
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public boolean isAches() {
		return aches;
	}
	public void setAches(boolean aches) {
		this.aches = aches;
	}
	public boolean isSoreThroat() {
		return soreThroat;
	}
	public void setSoreThroat(boolean soreThroat) {
		this.soreThroat = soreThroat;
	}
	public boolean isTonsillitis() {
		return tonsillitis;
	}
	public void setTonsillitis(boolean tonsillitis) {
		this.tonsillitis = tonsillitis;
	}
}