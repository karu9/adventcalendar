package day4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part1 {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String key = "ckczppom";
		int answer = 0;
		String hashtext = getHash(key + String.valueOf(answer));
		while(!hashtext.startsWith("000000")){
			answer++;
			hashtext = getHash(key + String.valueOf(answer));
		}
		System.out.println(answer);
	}
	
	public static String getHash(String string) throws NoSuchAlgorithmException{
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(string.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
		}
		return hashtext;
	}

}
