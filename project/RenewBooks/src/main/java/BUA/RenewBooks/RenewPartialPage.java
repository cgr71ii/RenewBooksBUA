package BUA.RenewBooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RenewPartialPage
{

	WebDriver driver;
	@FindBy(id="renew_all")
	WebElement renewAll;
	@FindBy(xpath="/html/body/div/table[4]/tbody/tr/td/form/table/tbody/tr[11]/td/input[1]")
	WebElement submit;
  
	public RenewPartialPage(WebDriver driver)
	{
		this.driver = driver;
	}
  
	public BookRenewedPartialPage renewAllBooks()
	{
		this.renewAll.click();
		this.submit.click();
		
		return (BookRenewedPartialPage)PageFactory.initElements(this.driver, BookRenewedPartialPage.class);
	}
  
	public String getTitle()
	{
		return this.driver.getTitle();
	}
	
	public String getCharacteristicLabel()
	{
		return this.driver.findElement(By.xpath("/html/body/div/table[4]/tbody/tr/td/form/table/tbody/tr[1]/td")).getText();
	}
	
	public String getInvalidLogInLabel()
	{
		return this.driver.findElement(By.xpath("/html/body/div/table[3]/tbody/tr/td/table/tbody/tr[1]/td/p[2]/strong")).getText();
	}

}
