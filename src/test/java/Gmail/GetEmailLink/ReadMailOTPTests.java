package Gmail.GetEmailLink;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ReadMailOTPTests {
	
	public static void main(String args[]) throws InterruptedException, IOException, GeneralSecurityException {
		
		System.getProperty("webdriver.chrome.driver", "chromedriver");
		ChromeOptions handlingSSL = new ChromeOptions();

		// Using the accept insecure cert method with true as parameter to accept the
		// untrusted certificate
		handlingSSL.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(handlingSSL);
		driver.get("https://dashboard.podop.com/");
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Forgot Password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("beingdeepurajagopal@gmail.com");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Send Reset Link']")).click();
		Thread.sleep(10000);
		
		System.out.println("Clicked");
		
		Thread.sleep(2000);
		
		GMail.sendGmailData();
		
	    String location = "file:/Users/deepurajagopal/Desktop/test.html";
		
		driver.get(location);
		
		String fgtPassURL = driver.findElement(By.xpath("(//a)[1]")).getAttribute("href");
		
		driver.navigate().to(fgtPassURL);
		
		driver.findElement(By.xpath("(//input)[1]")).sendKeys("deepu@123");
		driver.findElement(By.xpath("(//input)[2]")).sendKeys("deepu@123");
		
		driver.findElement(By.xpath("//button[text()='Reset Password']")).click();
		
		
		System.out.println("Received");
		
		driver.quit();
	}

}
