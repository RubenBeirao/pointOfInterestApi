package com.pointofinterestclient.SpringPointOfInterestAPI;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

//api receives the startingPoint and the EndPoint and returns a list of highlights

public class HighlightsServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String requestUrl = request.getRequestURI();
		String coordinate = requestUrl.substring("/highlights/".length());
		String split[] = coordinate.split(",");
		Double originlatitude = Double.valueOf(split[0]);
		Double originlongitude = Double.valueOf(split[1]);
		Double destinationlatitude = Double.valueOf(split[2]);
		Double destinationlongitude = Double.valueOf(split[3]);
		
		LinkedList<PointOfInterest> poi = PointOfInterestDB.getInstance().getAllHighlights(originlatitude, originlongitude, destinationlatitude, destinationlongitude);
		
		for (PointOfInterest pointOfInterest : poi) {
			if(poi != null){
				String json = "{\n";
				json += "\"name\": " + JSONObject.quote(pointOfInterest.getName()) + ",\n";
				json += "\"latitude\": " + JSONObject.quote(pointOfInterest.getLatitude()) + ",\n";
				json += "\"longitude\": " + JSONObject.quote(pointOfInterest.getLongitude()) + ",\n";
				json += "}";
				response.getOutputStream().println(json);
		
		}
		else{
			//That person wasn't found, so return an empty JSON object. We could also return an error.
			response.getOutputStream().println("{}");
		}
	}
	}
}
