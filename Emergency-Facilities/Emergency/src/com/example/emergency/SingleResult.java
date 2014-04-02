package com.example.emergency;

public class SingleResult {

	private String name;
	private String distance;
	private String matched;
	
	public SingleResult(String name, String distance, String matched)  {
		
		this.name = name;
		this.distance = distance;
		this.matched = matched;
    }
	 public String getname() {
	        return name;
	    }

//	    public void setname(String name) {
//	        this.name = name;
//	    }

	    public String getdistance() {
	        return distance;
	    }

	    public String getmatched() {
	        return matched;
	    }


}
