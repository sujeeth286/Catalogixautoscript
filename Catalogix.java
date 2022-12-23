package Automation;



	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.util.List;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

	public class  Catalogix
	{
		public static WebDriver driver;
		public static WebDriver driver1;
		public static String sent_workspacename= "December12";
		public static String catalogix_URL="https://staging.catalogix.ai/";
		public static String outlook_URL="https://outlook.office365.com";
		public static String catalogix_email="sujeeth@streamoid.com";
		public static String password="Mysuruarsikere@12";
		public static String catalogix_supporttext="support@streamoid.com";
		
		/*
		public static void all() throws InterruptedException, AWTException
		{
			
			loginCatalogix();
			Thread.sleep(2000);
			copyOTP();
			Thread.sleep(2000);
			validateLogin();
			createWorkspace();
			Thread.sleep(2000);
			validateWorkspace();
			Thread.sleep(2000);
				
		}
		*/
		@Test
		
		public static void loginCatalogix() throws InterruptedException
		{

			System.setProperty("webdriver.gecko.driver", "./Software/geckodriver.exe");
			driver= new FirefoxDriver();
			Thread.sleep(2000);
			driver.get(catalogix_URL);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='name@company.com']")).sendKeys(catalogix_email);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[.='Sign In']")).click();
			Thread.sleep(2000);
		
			
		}
		@Test(priority=1)
		public static void copyOTP() throws InterruptedException, AWTException
		{
			System.setProperty("webdriver.gecko.driver", "./Software/geckodriver.exe");
			 driver1= new FirefoxDriver();
			driver1.get(outlook_URL);
			Thread.sleep(2000);
			driver1.findElement(By.xpath("//input[@placeholder='Email, phone, or Skype']")).sendKeys(catalogix_email);
			Thread.sleep(2000);
			driver1.findElement(By.xpath("//input[@value='Next']")).click();
			Thread.sleep(2000);
			driver1.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
			driver1.findElement(By.xpath("//input[@value='Sign in']")).click();
			Thread.sleep(2000);
			driver1.findElement(By.xpath("//input[@value='Yes']")).click();
			Thread.sleep(2000);
			List<WebElement> mails = driver1.findElements(By.className("hcptT"));
			Thread.sleep(2000);
			for(int i=0;i<mails.size();i++)
			{
			
			mails.get(i).click();
		
			
			Thread.sleep(2000);
			
			
			mails.get(0).click();
			Thread.sleep(2000);
			Reporter.log("Valid mail selected",true);
				
			WebElement address = driver1.findElement(By.xpath("//div[@class='x_main'] /p[2]/b"));
			Thread.sleep(2000);
			Actions selection = new Actions(driver1);
			selection.doubleClick(address).perform();
			selection.contextClick(address ).perform();
			Robot copy= new Robot();
			Thread.sleep(2000);
			copy.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			copy.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			break;
			}
			 driver.findElement(By.xpath("//input[@id='input-1']")).sendKeys(Keys.CONTROL+"v");
			 driver1.close();	
			}
		
		@Test(priority=2)
		public static void validateLogin()
		{	
			
			driver.findElement(By.xpath("//span[.='My Profile']")).click();
			WebElement email_id = driver.findElement(By.xpath("//input[@disabled='']"));
			String actual_email = email_id.getAttribute("value");
			if(actual_email.equals(catalogix_email))
			{
				Reporter.log("Login validation is successful ",true);
				
			}
			
			else
			{
				Reporter.log("Login validation is failed",true);
			}
		}
		@Test(priority=3)
			
		public static void createWorkspace() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@class='_2BbadYBf--arrow-icon']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[.='New Workspace']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(sent_workspacename);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[.='Proceed']")).click();
			
		}
		@Test(priority=4)
		public static void validateWorkspace() throws InterruptedException
		{
			Thread.sleep(2000);
			
			List<WebElement> allworkspaces = driver.findElements(By.xpath("//div[@class='_30TbbGIr--workspace-item']"));
			
		int latest = allworkspaces.size()-2;
		Thread.sleep(2000);
		allworkspaces.get(latest).click();
		Thread.sleep(2000);
		
		WebElement workspace_location = driver.findElement(By.xpath("//div[@class='_1KjflpEV--workspace-name']/span[2]"));
		String actual_workspacename = workspace_location.getText();
		Thread.sleep(2000);
		Reporter.log(actual_workspacename,true);
		if(sent_workspacename.equals(actual_workspacename))
		{
			Reporter.log("Workspace validation is successful",true);
		}
		else
		{
			Reporter.log("Workspace validation is failed",true);
			
		}
		
		
		
			
		}
	
		

	}






