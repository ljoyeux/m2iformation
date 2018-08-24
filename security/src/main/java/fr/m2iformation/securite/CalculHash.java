package fr.m2iformation.securite;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public class CalculHash {
	public static String calculHash(String method, InputStream is) throws GeneralSecurityException, IOException {
		// Obtention de calculateur de hashage en de la methode
		MessageDigest messageDigest = MessageDigest.getInstance(method);

		// Creation d'un systeme de calcul de hashage sur un flux de donnees
		DigestInputStream digestInputStream = new DigestInputStream(is, messageDigest);

		// Calcul du hash sur le flux de donnees : on lit par bloc de 4096
		byte[] buffer = new byte[128];
		for (;;) {
			int i = digestInputStream.read(buffer);
			System.out.println("Taille lue: " + i);
			if (!(i > -1)) {
				break;
			}
			System.out.println(new String(buffer, 0, i));
		}
//		while (digestInputStream.read(buffer) > -1) {
//		}

		//
		MessageDigest digest = digestInputStream.getMessageDigest();
		digestInputStream.close();
		byte[] md5 = digest.digest();
		StringBuilder sb = new StringBuilder();
		for (byte b : md5) {
			int h = b & 0xff;
			String hexa = String.format("%02X", h);
			sb.append(hexa);
//			System.out.println(sb.toString() + " | " + hexa + " | " + Integer.toHexString(h) + " | " + b);
		}
		return sb.toString().toLowerCase();
	}

	public static String calculMD5(InputStream is) throws GeneralSecurityException, IOException {
		return calculHash("MD5", is);
	}

	public static String calculSHA512(InputStream is) throws GeneralSecurityException, IOException {
		return calculHash("SHA-512", is);
	}
}
