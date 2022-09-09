package com.pointofinterestclient.SpringPointOfInterestAPI;

//Creating an entity PointOfInterest
public class PointOfInterest {
	
	private Integer id;
	private String name;
	private Coordinate location;
	

	public PointOfInterest() {}
	

	public PointOfInterest(Integer id, String name, Coordinate location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinate getLocation() {
		return location;
	}
	
	public Double getLatitudeDouble() {
		return location.getLatitude();
	}
	
	public Double getLongitudeDouble() {
		return location.getLongitude();
	}
	
	public String getLatitude() {
		return String.valueOf(location.getLatitude());
	}
	
	public String getLongitude() {
		return String.valueOf(location.getLongitude());
	}

	public void setLocation(Coordinate location) {
		this.location = location;
	}
	
	public double calculateDistanceBetweenPoints(
			  double Originlatitude, 
			  double Originlongitude, 
			  double Destinationlatitude, 
			  double Destinationlongitude) {       
			    return Math.sqrt((Destinationlongitude - Destinationlatitude) * (Destinationlongitude - Destinationlatitude) + (Originlongitude - Originlatitude) * (Originlongitude - Originlatitude));
	}
	
	@Override
	public String toString() {
		return "PointOfInterest [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
} 
