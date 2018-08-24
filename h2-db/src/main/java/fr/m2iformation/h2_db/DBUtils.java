package fr.m2iformation.h2_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static final Connection CONNECTION;

	static {
		try {
			CONNECTION = DriverManager.getConnection(Constants.URL_JDBC, "sa", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
