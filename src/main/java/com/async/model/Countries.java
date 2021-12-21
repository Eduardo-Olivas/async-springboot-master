package com.async.model;

import javax.persistence.Entity;

import javax.persistence.Id;



@Entity
public class Countries {
	
	@Id
	private String ID;
	private String Name;
	private String Capital;
	private int Population;
	private int LanguageID;
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCapital() {
		return Capital;
	}
	public void setCapital(String capital) {
		Capital = capital;
	}
	public int getPopulation() {
		return Population;
	}
	public void setPopulation(int population) {
		Population = population;
	}
	public int getLanguageID() {
		return LanguageID;
	}
	public void setLanguageID(int languageID) {
		LanguageID = languageID;
	}
	
	@Override
	public String toString() {
		return "Countries [ID=" + ID + ", Name=" + Name + ", Capital=" + Capital + ", Population=" + Population
				+ ", LanguageID=" + LanguageID + "]";
	}
	

	
	
}
