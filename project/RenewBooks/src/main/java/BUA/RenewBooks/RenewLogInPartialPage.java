package BUA.RenewBooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RenewLogInPartialPage
{

	WebDriver driver;
	@FindBy(css=".pagecontainer > table:nth-child(5) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > input:nth-child(1)")
	WebElement usernameWE;
	@FindBy(css=".pagecontainer > table:nth-child(5) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > input:nth-child(1)")
	WebElement passwordWE;
	@FindBy(xpath="/html/body/div/table[4]/tbody/tr/td/form/table/tbody/tr[3]/td/input[1]")
	WebElement submit;
	private String username;
	private String password;
  
	public RenewLogInPartialPage(WebDriver driver)
	{
		this.driver = driver;
	}
  
	public RenewPartialPage logIn(String username, String password)
	{
		this.username = username;
		this.password = password;
		
		return this.logIn();
	}
  
	public RenewPartialPage logIn()
	{
		this.usernameWE.sendKeys(new CharSequence[] { this.username });
		this.passwordWE.sendKeys(new CharSequence[] { this.password });
		this.submit.click();
		
		return (RenewPartialPage)PageFactory.initElements(this.driver, RenewPartialPage.class);
	}
  
	public String getCharacteristicLabel()
	{
		return this.driver.findElement(By.xpath("/html/body/div/table[4]/tbody/tr/td/form/table/tbody/tr[1]/td")).getText();
	}
	
	public String getTitle()
	{
		return this.driver.getTitle();
	}
  
}
