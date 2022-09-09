package com.pointofinterestclient.SpringPointOfInterestAPI;
import java.util.LinkedList;

import org.springframework
.stereotype
.Repository;

@Repository
// Class to create a list
// of points of interest
/**
 * class that provides access to user data.
 * Pretend this class accesses a database.
 */
public class PointOfInterestDB {

	//Map of names to Person instances.
		private LinkedList<PointOfInterest> pois = new LinkedList<>();
		
		private static PointOfInterestDB instance = new PointOfInterestDB();
		public static PointOfInterestDB getInstance(){
			return instance;
		}	
	
		//private constructor so people know to use the getInstance() function instead
		private PointOfInterestDB(){
			// Creating a few pois
						// and adding them to the list
						pois.add(new PointOfInterest(
								1,
								"Terreiro do Paço",
								new Coordinate(38.708442, -9.136822)));

						pois.add(new PointOfInterest(
								2,
								"Castelo Sao Jorge",
								new Coordinate(38.713909, -9.133476)));
						
						pois.add(new PointOfInterest(
								3,
								"Parque Eduardo VII",
								new Coordinate(38.728298, -9.152683)));

		}



		// Method to return the list with all pois
		public LinkedList<PointOfInterest> getAllHighlights(double startLatitude, double startLongitude,
				double endLatitude, double endLongitude)
		{

			return pois;
		}

		// Method to return the list with all pois
				public LinkedList<PointOfInterest> getAllHighlights()
				{

					return pois;
				}
		 
}

