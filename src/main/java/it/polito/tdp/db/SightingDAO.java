package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {
	
	//DAO è un pattern
	
	public List <String> readShapes(){
	
		try {
			
		String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=dario";
		
		Connection conn = DBConnect.getConnection(); //ottengo la connessione 
			
			//Statement st = conn.createStatement();  //ottengo lo statement -->canale, tunnel
		String sql = "SELECT DISTINCT shape "
				+ "FROM sighting "
				+ "WHERE shape<>'' "
				+ "ORDER BY shape ASC";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet res = st.executeQuery();
		
		List <String> formeUFO = new ArrayList <String> ();

		while (res.next()) {
			String forma = res.getString("shape");
			formeUFO.add(forma);
		}
		
		st.close();
		
		return formeUFO;
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public int countByShape(String shape) {
		try {
			String sql2 = "SELECT COUNT(*) AS cnt FROM sighting WHERE shape = ?";
		
			
			//String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=dario";
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement st2 = conn.prepareStatement(sql2);
			st2.setString(1, shape);
			ResultSet res2 = st2.executeQuery();
			res2.first();
			int count = res2.getInt("cnt");
			st2.close();
			conn.close();
			
			
			return count;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		

	}
}
