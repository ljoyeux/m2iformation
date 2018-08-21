package fr.m2iformation.h2_db;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDAO {

	public List<Customer> getCustomers() throws SQLException {
		// utilisation de la connexion
		final Statement statement = DBUtils.CONNECTION.createStatement();

		throw new UnsupportedOperationException();
	}
}
