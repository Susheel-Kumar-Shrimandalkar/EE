package whitefeather.xedge.core;

import java.math.BigInteger;
import java.security.SecureRandom;

public class DataGenerator {
	
	public static String prospectEmail="";
	private static SecureRandom randomEmail = new SecureRandom();
	public static String randomEmailGenerator()
	{
		prospectEmail = new BigInteger(50, randomEmail).toString(32)+"@domain.in";;
		return prospectEmail;
	}
	
	public static long randomMobileNumberGenerator()
	{
		return (long) Math.floor(Math.random() * 1_000_000_000L) + 1_000_000_000L;
	}
	
	/*public static void main(String[] args) {
		System.out.println(DataGenerator.randomEmailGenerator());
		System.out.println(DataGenerator.randomMobileNumberGenerator());
	}*/

}
