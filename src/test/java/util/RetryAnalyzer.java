package util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
	
	
	private int retrycount = 0;
	private int maxretrycount = 3;
	public boolean retry(ITestResult result)
	{
		if(retrycount<maxretrycount)
		{
			retrycount++;
			return true;
		}
		
	
	return false;
}
}

