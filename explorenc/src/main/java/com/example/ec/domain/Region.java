package com.example.ec.domain;

public enum Region {

	RALEIGH("Raleigh"),
	CHARLOTTE("Charlotte"),
	GREENVILLE("Greenville"),
	ASHVILLE("Ashville"),
	DURHAM("Durham");
	
	
	private String label;
	
	private Region(String label) {this.label = label;}
	
	public static Region findByLabel(String byLabel)
	{
		for(Region r : Region.values()){
			if(r.label.equalsIgnoreCase(byLabel)){
				return r;
			}
		}
		
		return null;
	}
}
