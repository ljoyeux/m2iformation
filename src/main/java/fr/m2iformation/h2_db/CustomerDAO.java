package fr.m2iformation.h2_db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

	public List<Customer> getCustomers() throws SQLException {
		final List<Customer> customers = new ArrayList<>();
		try (Statement statement = DBUtils.CONNECTION.createStatement();
				ResultSet results = statement.executeQuery("SELECT * FROM CUSTOMER")) {

			while (results.next()) {
				final Number id = (Number) results.getObject(1);
				final String firstName = results.getString(2);
				final String lastName = results.getString(3);

				final Customer customer = new Customer();
				customer.setId(id.intValue());
				customer.setFirstName(firstName);
				customer.setLastName(lastName);

				customers.add(customer);
			}

			return customers;
		}
	}
}
