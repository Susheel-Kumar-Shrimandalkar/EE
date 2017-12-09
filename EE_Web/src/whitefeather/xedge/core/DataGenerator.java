package whitefeather.xedge.core;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
	
	
	public static SecureRandom randomEmail = new SecureRandom();
	public static final String emailaddress=new BigInteger(50, randomEmail).toString(32)+"@domain.in";
	
	public static String randomEmailGenerator()
	{
		return emailaddress;
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
		return "AFLead_"+getDate()+"_"+getTime();
	}
	
	/*public static void main(String[] args) {
		System.out.println(DataGenerator.randomEmailGenerator());
		System.out.println(DataGenerator.randomMobileNumberGenerator());
	}*/
	
	public static int getRandomDayOfMonth()
	{
		Random twoDigit = new Random();
		return twoDigit.nextInt(29)+1;
	}

	public static int getRandomMonth()
	{
		Random twoDigit = new Random();
			return twoDigit.nextInt(11)+1;
	}
	
	public static int getRandomYear()
	{
//		return ThreadLocalRandom.current().nextInt(1980, 1995 + 1);
		return ThreadLocalRandom.current().nextInt(70, 80 + 1);
	}
	
	public static void main(String[] args) {
		System.out.println(emailaddress);
		System.out.println(getRandomDayOfMonth());
		System.out.println(getRandomMonth());
	}
}
