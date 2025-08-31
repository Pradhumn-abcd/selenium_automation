package common;

import java.util.Random;

public class UtilityMethods {
	
	
	public static int genrateRandomNumber(int limit)
	{
		return 0;
	}
	
	
	 public static String generateRandomString(int limit) {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                          + "abcdefghijklmnopqrstuvwxyz"
	                          + "0123456789";

	        StringBuilder result = new StringBuilder(limit);
	        Random random = new Random();

	        for (int i = 0; i < limit; i++) {
	            int index = random.nextInt(characters.length());
	            result.append(characters.charAt(index));
	        }

	        return result.toString();
	    }
	
	public static void main(String[] args) {
	String str=	generateRandomString(5);
	System.out.println(str);
	}

}
