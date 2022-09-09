package com.pointofinterestclient.SpringPointOfInterestAPI;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

//api to return the nearest point of interest given a lat and long
public class NearestHighlightServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String requestUrl = request.getRequestURI();
		String coordinate = requestUrl.substring("/highlights/".length());
		String split[] = coordinate.split(",");
		Double latitude = Double.valueOf(split[0]);
		Double longitude = Double.valueOf(split[1]);
		
		LinkedList<PointOfInterest> poi = PointOfInterestDB.getInstance().getAllHighlights();
		
		PointOfInterest poiStore = new PointOfInterest();
		double bestDistance = 0;
		double distance = 0;
		
		for (PointOfInterest pointOfInterest : poi) {
			distance = pointOfInterest.calculateDistanceBetweenPoints(latitude, longitude, pointOfInterest.getLatitudeDouble(), pointOfInterest.getLongitudeDouble());
			
			if(distance < bestDistance) {
				bestDistance = distance;
				poiStore = pointOfInterest;
			}
		
		}
		
		if(poiStore != null){
			String json = "{\n";
			json += "\"name\": " + JSONObject.quote(poiStore.getName()) + ",\n";
			json += "\"latitude\": " + JSONObject.quote(poiStore.getLatitude()) + ",\n";
			json += "\"longitude\": " + JSONObject.quote(poiStore.getLongitude()) + ",\n";
			json += "}";
			response.getOutputStream().println(json);
		} 
			//That person wasn't found, so return an empty JSON object. We could also return an error.
			response.getOutputStream().println("{}");
		
	}
	}

