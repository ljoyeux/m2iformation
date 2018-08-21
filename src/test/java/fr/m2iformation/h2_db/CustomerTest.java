package fr.m2iformation.h2_db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class CustomerTest {
	@Test
	public void getCustomers() throws SQLException {

		CustomerDAO customerDAO = Mockito.mock(CustomerDAO.class);

		List<Customer> customersMockito = new ArrayList<>();
		customersMockito.add(new Customer(3, "m2i", "formation"));
		Mockito.when(customerDAO.getCustomers()).thenReturn(customersMockito);

		List<Customer> customers = customerDAO.getCustomers();

		System.out.println(customers);
	}
}
