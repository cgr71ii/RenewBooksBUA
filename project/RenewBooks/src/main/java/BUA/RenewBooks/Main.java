package BUA.RenewBooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Main
{
  
	public static void printErrorMessageAndExit(int status)
	{
		System.err.println("Syntax: java -jar RenewBooksBUA.jar [--visual] --username <username> --password <password>\n");
		System.err.println("If you use --visual it will be used Firefox as browser (geckodriver is needed).");
		System.exit(status);
	}
  
	// Args: [--visual] --username <username> --password <password>
	public static void main(String[] args)
	{
		if ((args.length != 4) && (args.length != 5))
		{
			printErrorMessageAndExit(1); 
		}
		
		WebDriver driver;
		
		if (args.length == 5)
		{
			int count = 0;
			
			for (String s : args)
			{
				if (s.equals("--visual"))
				{
					count++;
				}
			}
			
			if (count != 1)
			{
				printErrorMessageAndExit(1);
			}
			
			// Geckodriver is needed for this option.
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new HtmlUnitDriver();
		}
		
		String username = null;
		String password = null;
		
		for (int i = 0; i < args.length; i++)
		{
			if ((args[i].equals("--username")) && (i + 1 != args.length))
			{
				username = args[(i + 1)];
			}
			else if ((args[i].equals("--password")) && (i + 1 != args.length))
			{
				password = args[(i + 1)];
			}
		}
		
		if ((username == null) || (password == null))
		{
			printErrorMessageAndExit(1);
		}
		
		RenewBooks.renew(driver, username, password);
	}
	
}
