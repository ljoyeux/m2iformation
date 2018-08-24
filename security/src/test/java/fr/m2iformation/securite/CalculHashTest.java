package fr.m2iformation.securite;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.GeneralSecurityException;

import org.junit.Assert;
import org.junit.Test;

public class CalculHashTest {
	@Test
	public void md5Fichier() throws IOException, GeneralSecurityException {
		try (InputStream is = CalculHashTest.class.getResourceAsStream("/fichier.txt")) {
			Assert.assertNotNull("Flux d'entree nul", is);
			System.out.println(CalculHash.calculMD5(is));
		}
	}

//	@Test
	public void md5Internet() throws IOException, GeneralSecurityException {
		URL url = new URL("http://www.lemonde.fr:80");

		try (InputStream is = url.openStream()) {
			Assert.assertNotNull("Flux d'entree nul", is);
			System.out.println("md5 le monde: " + CalculHash.calculHash("MD5", is));
		}
	}

//	@Test
	public void sha512Tomcat901() throws IOException, GeneralSecurityException {
		try (InputStream is = CalculHashTest.class.getResourceAsStream("/apache-tomcat-9.0.11.zip")) {
			Assert.assertNotNull("Flux d'entree nul", is);
			String sha512 = "aba6e28a1193d6280558717a47ea1ea4f36b225740a5031a3abb863f73ddf075ab4e7ec"
					+ "9a0c61fddf56c2293d46020400592d60dfbb96b6323e642d644c241fd";
			long begin = System.currentTimeMillis();
			Assert.assertEquals(sha512, CalculHash.calculHash("SHA-512", is));
			long end = System.currentTimeMillis();
			
			System.out.println("Temps en millisecondes : " + (end - begin));
		}
	}

//	@Test
	public void md5String() throws IOException, GeneralSecurityException {
		try (InputStream is = new ByteArrayInputStream("Laurent Joyeux".getBytes())) {
			Assert.assertNotNull("Flux d'entree nul", is);
			System.out.println("md5 sur une chaine de caractere: " + CalculHash.calculHash("MD5", is));
		}
	}

//	@Test
	public void md5Password() throws IOException, GeneralSecurityException {
		System.out.println("===============================");

		System.out.println("MD5 Mot de passe");
		String password = "scKd5fL2"; // NON STOCKE EN BDD
		String passwordMD5; // Stocke en base de données

		try (InputStream is = new ByteArrayInputStream(password.getBytes())) {
			Assert.assertNotNull("Flux d'entree nul", is);
			passwordMD5 = CalculHash.calculHash("MD5", is);
		}

		String passwordTest = "dffgdfccxcgsdfgsgtrfszrt-yhszrtgfn srt hyjzrtsh  qhrt jezytj qrdtf hsrtyj ety ";
		String passwordMD5Test;
		try (InputStream is = new ByteArrayInputStream(passwordTest.getBytes())) {
			Assert.assertNotNull("Flux d'entree nul", is);
			passwordMD5Test = CalculHash.calculHash("MD5", is);
		}

		System.out.println("md5 mot de passe stocke en base de donnee : " + passwordMD5);
		System.out.println("md5 mot de passe a tester : " + passwordMD5Test);
		System.out.println("===============================");
	}
}
