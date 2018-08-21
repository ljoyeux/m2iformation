package fr.m2iformation.h2_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class AppTest {

	@Test
	public void dummy() {
		System.out.println("coucou");
	}


//	@Test
	public void connectToDB() throws SQLException {
		try (final Connection connection = DriverManager.getConnection(Constants.URL_JDBC, "sa", "")) {
			assert connection != null;
		}
	}

	@Test
	public void connectToDBV2() {
		assert DBUtils.CONNECTION != null;
	}
}
