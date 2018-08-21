package fr.m2iformation.h2_db;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

public class CustomerTest {
	@Test
	public void getCustomers() throws SQLException {
		List<Customer> customers = new CustomerDAO().getCustomers();

		System.out.println(customers);
	}
}
