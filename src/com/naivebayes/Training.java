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

public class Training {
	
	/*
	 * Symptom Counter variables
	 */
	
	private int i;
	private int temp_hot;
	private int temp_normal;
	private int temp_cool;
	private int ache_yes;
	private int ache_no;
	private int sore_yes;
	private int sore_no;
	private int tons_yes;
	private int tons_no;
	
	//Ratio variable indicates percentage of data set to be used for training, remainder will be used for testing
	private double ratio; 
	
	
	/*
	 * Constructor
	 */
	
	
	public Training()
    {
		int i = 0;
		int temp_hot = 0;
		int temp_normal = 0;
		int temp_cool = 0;
		int ache_yes = 0;
		int ache_no = 0;
		int sore_yes = 0;
		int sore_no = 0;
		int tons_yes = 0;
		int tons_no = 0;
		double ratio = 0.75;
       
    }
	
	
	/*
	 * Methods
	 */
	
	public void ReadData()
	{
		
	}
	
	
	
	
	
	
	
	
	/*
	 * GETTERS / SETTERS
	 */
	
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	
	/*--------------------------------------------*/
	
	
	public int getTemp_hot() {
		return temp_hot;
	}
	public void setTemp_hot(int temp_hot) {
		this.temp_hot = temp_hot;
	}
	
	
	/*--------------------------------------------*/
	
	
	public int getTemp_normal() {
		return temp_normal;
	}
	public void setTemp_normal(int temp_normal) {
		this.temp_normal = temp_normal;
	}
	
	
	/*--------------------------------------------*/
	
	
	public int getTemp_cool() {
		return temp_cool;
	}
	public void setTemp_cool(int temp_cool) {
		this.temp_cool = temp_cool;
	}
	
	
	/*--------------------------------------------*/
	
	
	public int getAche_no() {
		return ache_no;
	}
	public void setAche_no(int ache_no) {
		this.ache_no = ache_no;
	}
	
	
	/*--------------------------------------------*/
	
	
	public int getAche_yes() {
		return ache_yes;
	}
	public void setAche_yes(int ache_yes) {
		this.ache_yes = ache_yes;
	}
	
	
	/*--------------------------------------------*/
	
	
	public int getSore_yes() {
		return sore_yes;
	}
	public void setSore_yes(int sore_yes) {
		this.sore_yes = sore_yes;
	}
	
	
	/*--------------------------------------------*/
	
	
	public int getSore_no() {
		return sore_no;
	}
	public void setSore_no(int sore_no) {
		this.sore_no = sore_no;
	}
	
	
	/*--------------------------------------------*/
	
	
	public int getTons_yes() {
		return tons_yes;
	}
	public void setTons_yes(int tons_yes) {
		this.tons_yes = tons_yes;
	}
	
	
	/*--------------------------------------------*/
	
	
	public int getTons_no() {
		return tons_no;
	}
	public void setTons_no(int tons_no) {
		this.tons_no = tons_no;
	}
	
	
	/*--------------------------------------------*/


	public double getRatio() {
		return ratio;
	}


	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	

}
