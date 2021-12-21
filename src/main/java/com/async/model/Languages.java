package com.async.model;

import javax.persistence.Entity;

import javax.persistence.Id;



@Entity
public class Languages {
	
	@Id
	private int ID;
	private String Name;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return "Languages [ID=" + ID + ", Name=" + Name + "]";
	}
	
	
	
	
	
}
