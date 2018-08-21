package fr.m2iformation.h2_db;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import fr.m2iformation.h2_db.misc.Factoriel;

public class FactorielTest {
	@Test
	public void test() {
		Factoriel factoriel = Mockito.mock(Factoriel.class);

		Mockito.when(factoriel.factoriel(2)).thenReturn(2L);
		Mockito.when(factoriel.factoriel(5)).thenReturn(120L);
		Mockito.when(factoriel.factoriel(4)).thenReturn(24L);

		Assert.assertEquals(120, factoriel.factoriel(5));
		Assert.assertEquals(24, factoriel.factoriel(4));

		System.out.println("5: " + factoriel.factoriel(5));
		System.out.println("10: " + factoriel.factoriel(10));
	}
}
