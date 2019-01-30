
package BUA.RenewBooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RenewBooks
{

	public static void renew(WebDriver driver, String username, String password)
	{
	    String expectedString;

	    BUAPartialPage buaPO = (BUAPartialPage)PageFactory.initElements(driver, BUAPartialPage.class);
	    expectedString = "Biblioteca de la Universidad de Alicante. Biblioteca Universitaria";
	    
	    if (!buaPO.getTitle().contains(expectedString))
	    {
	    	System.err.println("ERROR (BUA): title does not contain the expected string.");
	    	System.err.println("Expected string: " + expectedString + "\n");
	    	System.err.println("This error has happened surely due to an update of the web page.");
	      
	    	System.exit(1);
	    }
	    
	    RenewLogInPartialPage renewLoginPO = buaPO.renew();
	    expectedString = "iLink Universidad de Alicante";
	    
	    if (!renewLoginPO.getTitle().contains(expectedString))
	    {
	    	System.err.println("ERROR (RenewLogIn): title does not contain the expected string.");
	    	System.err.println("Expected string: " + expectedString + "\n");
	    	System.err.println("This error has happened surely due to an update of the web page.");
	      
	    	System.exit(1);
	    }

	    expectedString = "Seleccionar algunos o todos los títulos para renovar";
	    
	    if (!renewLoginPO.getCharacteristicLabel().contains(expectedString))
	    {
	    	System.err.println("ERROR (RenewLogIn): characteristic label does not contain the expected string.");
	    	System.err.println("Expected string: " + expectedString + "\n");
	    	System.err.println("This error has happened surely due to an update of the web page.");
	      
	    	System.exit(1);
	    }
	    
	    RenewPartialPage renewPO = renewLoginPO.logIn(username, password);
	    expectedString = "iLink";
	    
	    if (renewPO.getTitle().equals(expectedString))
	    {
	    	// Username or password was wrong
	    	System.err.println("ERROR (LogIn): username or password was wrong.");
	    	
	    	System.exit(1);
	    }
	    
	    expectedString = "iLink Universidad de Alicante";
	    
	    if (!renewPO.getTitle().contains(expectedString))
	    {
	    	System.err.println("ERROR (Renew): title does not contain the expected string.");
	    	System.err.println("Expected string: " + expectedString + "\n");
	    	System.err.println("This error has happened surely due to an update of the web page.");
	      
	    	System.exit(1);
	    }

	    expectedString = "Seleccionar ítems para renovar";
	    
	    if (!renewPO.getCharacteristicLabel().contains(expectedString))
	    {
	    	System.err.println("ERROR (Renew): characteristic label does not contain the expected string.");
	    	System.err.println("Expected string: " + expectedString + "\n");
	    	System.err.println("This error has happened surely due to an update of the web page.");
	    	
	    	System.exit(1);
	    }
	    
	    BookRenewedPartialPage bookRenewedPO = renewPO.renewAllBooks();
	    expectedString = "iLink Universidad de Alicante";
	    
	    if (!bookRenewedPO.getTitle().contains(expectedString))
	    {
	    	System.err.println("ERROR (BookRenewed): title does not contain the expected string.");
	    	System.err.println("Expected string: " + expectedString + "\n");
	    	System.err.println("This error has happened surely due to an update of the web page.");
	      
	    	System.exit(1);
	    }

	    expectedString = "préstamos renovados";
	    
	    if (!bookRenewedPO.getCharacteristicLabel().contains(expectedString))
	    {
	    	System.err.println("ERROR (BookRenewed): characteristic label does not contain the expected string.");
	    	System.err.println("Expected string: " + expectedString + "\n");
	    	System.err.println("This error has happened surely due to an update of the web page.");
	    	
	    	System.exit(1);
	    }
	    
	    System.out.println(bookRenewedPO.toString());
	    
	    driver.quit();
	    System.exit(0);
	}
	
}
