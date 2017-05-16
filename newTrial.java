package newMember;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class newTrial {
	public static void main(String[] args) throws IOException{
		//setProperty(a,b): Ensure b is set to path of gecko driver
		//ClassLoader loader = ClassLoader.getSystemClassLoader();
        //URL path = loader.getResource("geckodriver.exe");
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		URL url = cl.getResource("geckodriver/geckodriver/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", url.getPath());

		//System.setProperty("webdriver.gecko.driver", "C:/Users/Sherlock Mind Palace/workspace/TrialRun/geckodriver/geckodriver.exe");
	   	WebDriver driver = new FirefoxDriver();
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        
    	//Go to testing site
    	driver.get("https://apptimize.com");
    	
    	//Click on Sign Up button
    	driver.findElement(By.xpath("//a[@href='/30-day-trial']")).click();
    	
    	//Search for id fname for 10 seconds before giving up
    	WebElement fname = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("fname")));
    	fname.sendKeys(member.fName);
    	
    	WebElement lname = driver.findElement(By.id("lname"));
    	lname.sendKeys(member.lName);
    	
    	//Fill in email field 
    	WebElement email = driver.findElement(By.id("email"));
    	email.sendKeys(member.eMail);
    	
    	//Fill in Company name
    	WebElement cname = driver.findElement(By.id("company"));
    	cname.sendKeys("Apptimize Candidate");
    	
    	//Fill in Phone and Job field
    	WebElement phone = driver.findElement(By.id("phone"));
    	phone.sendKeys(member.pNumber);
    	
    	WebElement jtitle = driver.findElement(By.id("jobtitle"));
    	jtitle.sendKeys(member.jTitle);
    	
    	//Create password
    	WebElement password = driver.findElement(By.id("password"));
    	password.sendKeys(member.pWord);
    	
    	//Select No to software radio question
    	WebElement rNo = driver.findElement(By.xpath("//input[@name='purchased' and @value='No']"));
    	rNo.click();
   
    	//Select End User License Agreement Checkbox
    	WebElement read = driver.findElement(By.id("eula"));
    	read.click();
    	
    	//WebElement submit = driver.findElement(By.id("submit"));
    	//submit.click();
    	
    	System.out.println("You successfully signed up for trial account.");
        	
    	driver.quit();
   
    }

}
