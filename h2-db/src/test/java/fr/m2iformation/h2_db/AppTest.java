package fr.m2iformation.h2_db;

import org.junit.Test;

public class AppTest {

	@Test
	public void connectToDBV2() {
		assert DBUtils.CONNECTION != null;
	}
}
