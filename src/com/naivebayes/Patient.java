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

public class Patient {
	
	private String temperature;
	private boolean aches;
	private boolean sore_throat;
	private boolean tonsillitis;
	
	
	/*
	 * Constructor
	 */
	
	public Patient()
	{
		
	}
	
	
	/*
	 * Methods
	 */
	
	
	
	/*
	 * Getters / Setters 
	 */
	
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public boolean hasAches() {
		return aches;
	}
	public void setAches(boolean aches) {
		this.aches = aches;
	}
	public boolean hasSore_throat() {
		return sore_throat;
	}
	public void setSore_throat(boolean sore_throat) {
		this.sore_throat = sore_throat;
	}
	public boolean hasTonsillitis() {
		return tonsillitis;
	}
	public void setTonsillitis(boolean tonsillitis) {
		this.tonsillitis = tonsillitis;
	}

}
