package fr.m2iformation.securite;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Crypto {
	// generation des clefs asymetrique

	public static KeyPair buildKeyPair(final int keySize) throws NoSuchAlgorithmException {
		final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(keySize);

		return keyPairGenerator.genKeyPair();
	}

	public static SecretKey buildSymetricKey(final String algo, final int keySize) throws GeneralSecurityException {
		final KeyGenerator keyGen = KeyGenerator.getInstance(algo);
		keyGen.init(keySize);
		return keyGen.generateKey();
	}

	// chiffrage et dechiffrage
	public static byte[] dechriffre(final Cipher cipher, final byte[] data) throws GeneralSecurityException {
		return cipher.doFinal(data);
	}

	public static byte[] chriffre(final Cipher cipher, final byte[] data) throws GeneralSecurityException {
		return cipher.doFinal(data);
	}

	//
	public static Cipher getInstance(final String algo, final int mode, final Key key) throws GeneralSecurityException {
		final Cipher cipher = Cipher.getInstance(algo);
		cipher.init(mode, key);

		return cipher;
	}
}
