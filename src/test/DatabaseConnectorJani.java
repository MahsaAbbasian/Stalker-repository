package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseConnectorJani {

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	ResultSet rsupdate = null; // ********  TODO Check if it is ok to do like this  /// ******  Jani *******
	ResultSet rsecupdate = null; // ********  TODO Check if it is ok to do like this  /// ******  Jani *******

	public DatabaseConnectorJani() throws SQLException {

		con = DriverManager.getConnection("jdbc:mysql://localhost/StalkerDB",
				"Dyrnwyn", "Dyrnwyn!");
		System.out.println("Database connected");

		stmt = con.createStatement();

	}

	public String inputTest() {
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		return inp;

	}

	public void querieAll(String table) throws SQLException {

		rs = stmt.executeQuery("SELECT * from " + table + ";");
		java.sql.ResultSetMetaData rsmd = rs.getMetaData();

		int columnsNumber = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				String columnValue = rs.getString(i);
				System.out.print(columnValue + " ");
			}
			System.out.println("");
		}
		con.close();
	}

	public void querieSpecific(String table, String username, String date1,
			String date2) throws SQLException {
		String and = "";

		if (!username.equals("")) {
			username = "Username = " + "'" + username + "'";
		}
		if (!date1.equals("")) {
			date1 = "`Date` between " + "'" + date1 + "'";
		}
		if (!date2.equals("")) {
			date2 = " and " + "'" + date2 + "'";
		}
		if (!username.equals("") && (!date1.equals(""))) {
			and = " and ";
		}

		rs = stmt.executeQuery("SELECT * from " + table + " WHERE " + username
				+ and + date1 + date2 + ";");

		java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				String columnValue = rs.getString(i);
				System.out.print(columnValue + " ");
			}
			System.out.println("");
		}
		con.close();
	}

	public void querieColumn(String table, String column) throws SQLException {

		if (inputTest().equals("Locations")) {
			table = "Locations";
			if (inputTest().equals("City")) {
				column = "City";
			} else if (inputTest().equals("Street")) {
				column = "Street";
			}
		}

		if (inputTest().equals("ExtraCostTypes")) {
			table = "ExtraCostTypes";
			column = "ExtraCostTypes";
		}

		rs = stmt.executeQuery("SELECT " + column + " FROM " + table + ";");

		while (rs.next())
			System.out.println(rs.getString(1));

		con.close();

	}

	/*
	 * Added code by Jani from the DatabaseConnectors class
	 */

	public void insertExtraCost(String typeOfCost, String cost, String file, String date) throws SQLException {
		
		
		int rsecupdate = stmt.executeUpdate("INSERT INTO ExtraCosts"
			+ "(`TypeOfCost`, `Cost`, `File`, `Date`)"
			+ " VALUES " + "('" + typeOfCost + "','" +  cost + "','" + file + "','" 
			+ date + "')" );

	}
	
	
	public void insertTripData(String startKilometerText, String endKilometerText, String from, String to, String reasonForTrip, String username, String name, String car, String date) throws SQLException {
		
		
		int rsupdate = stmt.executeUpdate("INSERT INTO TripData"
			+ "(`StartingKm`, `EndingKm`, `From`, `To`, `ReasonOfTrip`, `Username`, `Name`, `RegistryNumber`, `Date`)"
			+ " VALUES " + "('" + startKilometerText + "','" + endKilometerText + "','" + from + "','" + to + "','" 
			+ reasonForTrip + "','" + username + "','" + name + "','" + car + "','" + date + "')" );

	}
}
