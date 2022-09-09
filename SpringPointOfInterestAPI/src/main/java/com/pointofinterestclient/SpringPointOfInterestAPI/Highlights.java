package com.pointofinterestclient.SpringPointOfInterestAPI;

import java.util.ArrayList;
import java.util.List;

public class Highlights {
	// Class to store the list of
	// all the points of interest in an
	// Array List

	  
	    private List<PointOfInterest> pointOfInterestList;
	  
	    // Method to return the list
	    // of point of interest
	    public List<PointOfInterest> getPointOfInterestList() {
	  
	        if (pointOfInterestList == null) {
	  
	        	pointOfInterestList
	                = new ArrayList<>();
	  
	                   
	        }
	  
	        return pointOfInterestList;
	  
	           
	    }
	  
	    public void
	    setPointOfInterestList(
	        List<PointOfInterest> pointOfInterestList)
	    {
	        this.pointOfInterestList
	            = pointOfInterestList;
	    }
}

