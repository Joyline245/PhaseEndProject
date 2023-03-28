package AmazonTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//Maximize
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement Searchtxt = driver.findElement(By.id("twotabsearchtextbox"));
		Searchtxt.sendKeys("Samsung Mobile");
		
		WebElement SearchBtn = driver.findElement(By.id("nav-search-submit-button"));
		SearchBtn.click();
		
					
		//======================== Count & Display =====================================
		
		List<WebElement> mobileName = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		List<WebElement> mobilePrice = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//div[contains(@class,'price')]//span[@class='a-price-whole']"));
		List<WebElement> Currency = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//div[contains(@class,'price')]//span[@class='a-price-symbol']"));
		
		for(int i=0; i<mobileName.size();i++) {
			
			System.out.println("List of Products: " + mobileName.get(i).getText());
			System.out.println(" Price - " +Currency.get(i).getText()+ " " +mobilePrice.get(i).getText());
		}
			
		//============ScreenShot=====================
		TakesScreenshot tsObj =(TakesScreenshot) driver;
		
		//Create method 
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("ScreenSHot.png"); // we can set location  
		
		FileUtils.copyFile(fileObj, screenshotObj);
		
		
		//======================Close the Tab=========================================
		driver.close();
		
		
	}

}
