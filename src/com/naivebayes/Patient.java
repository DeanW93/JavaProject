/*
 * PATIENT CLASS
 * Author: Dean Whelan
 * Date: 01/04/19
 * 
 * Description:
 * 
 * 
 */


package com.naivebayes;

public class Patient
{
	private String temperature;
	private boolean aches;
	private boolean soreThroat;
	private boolean tonsillitis;
	
	public Patient() {};
	public Patient(String temperature, boolean aches, boolean soreThroat)
	{
		this.temperature = temperature;
		this.aches = aches;
		this.soreThroat = soreThroat;
	}
	
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