package BUA.RenewBooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookRenewedPartialPage
{

	WebDriver driver;
  
	public BookRenewedPartialPage(WebDriver driver)
	{
		this.driver = driver;
	}
  
	public Integer getRenewedBooks()
	{
		return Integer.valueOf(Integer.parseInt(this.driver.findElement(By.xpath("/html/body/div/table[3]/tbody/tr/td/table/tbody/tr[1]/td/strong")).getText()));
	}
  
	public String getCharacteristicLabel()
	{
		return this.driver.findElement(By.xpath("/html/body/div/table[3]/tbody/tr/td/table/tbody/tr[1]/td")).getText();
	}
  
	public String getTitle()
	{
		return this.driver.getTitle();
	}

	public String toString()
	{
		Integer books = this.getRenewedBooks();
		String result = "";
		
		for (int i = 1; i <= books.intValue(); i++)
		{
			result = result + "\nBook Renewed:\n";
			result = result + "-------------\n";
			result = result + " " + this.driver.findElement(By.xpath(new StringBuilder().append("/html/body/div/table[3]/tbody/tr/td/table/tbody/tr[2]/td/dl[").append(i).append("]/dd").toString())).getText();
			result = result + "\n-------------\n";
		}
		
		return result;
	}
  
}
