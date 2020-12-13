package com.ss.asgn5.brokenSingleton;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleSingleton {

	// must be volatile to prevent CPU caching inconsistencies
	private static volatile Connection conn = null;
	private static volatile SampleSingleton instance = null;
	
	// added private constructor to prevent instantiation
	private SampleSingleton() {}
	
	// added double lock checking to method
	public static SampleSingleton getInstance() throws SQLException {
		if (instance == null) {
			synchronized (SampleSingleton.class) {
				if (instance == null) {
					instance = new SampleSingleton();
					
					// added connection double locking to prevent multiple connections
					conn = DriverManager.getConnection("url of database");
				}
			}
		}
		return instance;
	}
	
	// should not be a static method since the DB connection relies on instantiation
	public void databaseQuery(BigDecimal input) {
		// added error checking for SQLExceptions
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select id from table");
			// x should be a BigDecimal since we are multiplying BigDecimals
			BigDecimal x = new BigDecimal(0);
			while (rs.next()) {
				x = new BigDecimal(rs.getInt(1)).multiply(input);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
