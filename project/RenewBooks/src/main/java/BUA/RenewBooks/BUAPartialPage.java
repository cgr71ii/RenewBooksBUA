package BUA.RenewBooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BUAPartialPage
{

	WebDriver driver;
	@FindBy(xpath="/html/body/div[3]/div[4]/div/div[2]/p[4]/a[1]")
	WebElement renewBooks;
  
	public BUAPartialPage(WebDriver driver)
	{
		this.driver = driver;
		this.driver.get("https://biblioteca.ua.es/es/biblioteca-de-la-universidad-de-alicante.html");
	}
  
	public RenewLogInPartialPage renew()
	{
		this.renewBooks.click();
		
		return (RenewLogInPartialPage)PageFactory.initElements(this.driver, RenewLogInPartialPage.class);
	}
  
	public String getTitle()
	{
		return this.driver.getTitle();
	}

}
