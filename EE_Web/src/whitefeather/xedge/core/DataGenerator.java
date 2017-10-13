package whitefeather.xedge.core;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataGenerator {
	
	
	public static SecureRandom randomEmail = new SecureRandom();
	public static String randomEmailGenerator()
	{
		return new BigInteger(50, randomEmail).toString(32)+"@domain.in";
	
	}
	
	public static long randomMobileNumberGenerator()
	{
		return (long) Math.floor(Math.random() * 1_000_000_000L) + 1_000_000_000L;
	}
	
	public static String getDate()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = dateFormat.format(new Date());
		return date;
	}
	
	
	public static String getTime()
	{
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH_mm_ss"));
	}
	
	public static String generateFirstName()
	{
		return "LeadName_"+getDate()+"_"+getTime();
	}
	
	/*public static void main(String[] args) {
		System.out.println(DataGenerator.randomEmailGenerator());
		System.out.println(DataGenerator.randomMobileNumberGenerator());
	}*/

}
