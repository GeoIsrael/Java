package example.base64;

import java.util.Base64;

public class Base64Example {

	public static void main(String[] args) {

		String str = "Hello my friend";
	
		// Encode data on your side using BASE64
		byte[] bytesEncoded = Base64.getEncoder().encode(str.getBytes());	
		System.out.println("encoded value is " + new String(bytesEncoded));

		// Decode data on other side, by processing encoded data
		System.out.println("Decoded value is " + new String(Base64.getDecoder().decode(bytesEncoded)));

	}

}
