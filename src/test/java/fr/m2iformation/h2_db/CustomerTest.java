package fr.m2iformation.h2_db;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
	@Test
	public void getCustomers() throws SQLException {
		List<Customer> customers = new CustomerDAO().getCustomers();

		// A partir du Java 8
		Map<Integer, Customer> map = customers.stream()
				.collect(Collectors.toMap(c -> c.getId() /* Customer::getId */, c -> c));

		// avant java 8
//		Map<Integer, Customer> map = new HashMap<>();
//		for (Customer c : customers) {
//			map.put(c.getId(), c);
//		}

		Customer ljoyeux = map.get(1);
		assert ljoyeux != null;

//		assert ljoyeux.getFirstName().equals("Laurent");
//		assert ljoyeux.getLastName().equals("Joyeux");

		Assert.assertEquals("Laurent", ljoyeux.getFirstName());
		Assert.assertEquals("Joyeux", ljoyeux.getLastName());
	}
}
