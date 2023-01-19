import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			String input = scan.nextLine();
			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				try {
					byte[] hash = digest.digest(input.getBytes("UTF-8"));
					System.out.println(bytesToHex(hash));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuilder result = new StringBuilder();
		for (byte b : bytes)
			result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		return result.toString();
	}
}
