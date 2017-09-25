package whitefeather.xedge.testcases;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import whitefeather.xedge.facilitator.HelperHand;

public class EndTesting extends HelperHand
{

	@AfterClass(alwaysRun = true)
	@Test
	public void endTestSuite() throws IOException, InterruptedException
	{
		setDownTestSuit();
	}
}
