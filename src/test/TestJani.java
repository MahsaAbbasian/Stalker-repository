package test;

import java.sql.SQLException;
import java.util.ArrayList;

public class TestJani {
	
	
	
	String column = "";
	static String username = "jani.pasanen@student.gu.se";
	static String table = "TripData";
	
	static String date1 = "";//"2012-03-10"; 
	static String date2 = "";//"2012-04-12";
	
	
	/*
	 * Added by Jani
	 */
	static String startKilometerText = "1001";
	static String endKilometerText = "1002";
	static String from = "Göteborg";
	static String to = "Örnsköldsvik";
	static String reasonForTrip = "Factory visit";
// here would like to have static String username = ""; // Jani
	static String name = "Jani Pasanen";
	static String car = "ABC123";
	static String date = "2013-11-14";
	
	static String typeOfCost = "Food";
	static String cost = "120";
	static String file = null;
	
	
	/*
	 * End of code added by Jani
	 */

	public static void main(String[] args) throws SQLException {
		
//		new GUI();
		DatabaseConnectorJani dc = new DatabaseConnectorJani();
		
		//dc.querieAll(table);
		// dc.insertTripData(startKilometerText, endKilometerText, from, to, reasonForTrip, username, name, car, date);
		dc.insertExtraCost(typeOfCost, cost, file, date);
	}
	
	public static String stringify(ArrayList<String> ar){
		String listString ="";
		for (String s : ar){
		    listString += s + ", ";
		}
		return listString;
	}
}
