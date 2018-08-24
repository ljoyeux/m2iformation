package fr.m2iformation.securite;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import org.junit.Assert;
import org.junit.Test;

public class CipherTest {

//	@Test
	public void rsa() throws GeneralSecurityException {
		final KeyPair keyPair = Crypto.buildKeyPair(1024);

		final PrivateKey privateKey = keyPair.getPrivate();
		final PublicKey publicKey = keyPair.getPublic();

		final byte[] privateKeyBytes = privateKey.getEncoded(); // PKCS8EncodedKeySpec ?
		final byte[] publicKeyBytes = publicKey.getEncoded(); // X509EncodedKeySpec ?

		System.out.println("Taille de la clef private encoded : " + privateKeyBytes.length);
		System.out.println("Taille de la clef public encoded : " + publicKeyBytes.length);

		final String chaine = "Laurent Joyeux";

		final Cipher chiffrage = Crypto.getInstance("RSA", Cipher.ENCRYPT_MODE, privateKey);
		final Cipher dechiffrage = Crypto.getInstance("RSA", Cipher.DECRYPT_MODE, privateKey);

		final byte[] crypte = Crypto.chriffre(chiffrage, chaine.getBytes());
		final byte[] decrypte = Crypto.chriffre(dechiffrage, crypte);

		final String chaineChiffreeDechriffee = new String(decrypte);

		Assert.assertEquals(chaine, chaineChiffreeDechriffee);
		System.out.println(chaine.length());
		System.out.println(chaine);
		System.out.println(chaineChiffreeDechriffee);
		System.out.println(crypte.length * 8 + " | " + new String(crypte));
	}

	@Test
	public void aes() throws GeneralSecurityException {
		final SecretKey key = Crypto.buildSymetricKey("AES", 256);

		final byte[] encodedKey = key.getEncoded();
		System.out.println(encodedKey.length * 8);

		final String chaine = "Laurent Joyeux";

		final Cipher chiffrage = Crypto.getInstance("AES", Cipher.ENCRYPT_MODE, key);
		final Cipher dechiffrage = Crypto.getInstance("AES", Cipher.DECRYPT_MODE, key);

		final byte[] crypte = Crypto.chriffre(chiffrage, chaine.getBytes());
		final byte[] decrypte = Crypto.chriffre(dechiffrage, crypte);

		final String chaineChiffreeDechriffee = new String(decrypte);

		Assert.assertEquals(chaine, chaineChiffreeDechriffee);
		System.out.println(crypte.length * 8 + " | " + new String(crypte));
	}
}
