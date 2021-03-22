package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	//classe che fa il lavoro riguardante la connessione e fornisce il metodo per la connessione stessa;
	
	
	
	public static Connection getConnection () throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=dario";
		return DriverManager.getConnection(jdbcURL);
		
	}
}
