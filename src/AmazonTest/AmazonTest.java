package AmazonTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class AmazonTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		
		WebElement fname = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		fname.sendKeys("samsung mobile");
		
		WebElement search_button = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
		search_button.click();
		
		List<WebElement> product_name = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		
		
		List<WebElement> Product_price = driver.findElements(By.xpath("//div[@class='a-section']//span[@class='a-price-whole']"));
		
		WebElement currency = driver.findElement(By.xpath("//span[@class=\"a-price-symbol\"]"));
		System.out.println("currency: " +currency.getText());


			

		for(WebElement productname : product_name)
		{
			
			for(WebElement price : Product_price)
			{
			System.out.println("product name: "+productname.getText() );
			System.out.println("product price: " +price.getText());
			
		}

	}
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("amazon.png");
		
		FileUtils.copyFile(fileObj,screenshotObj);
		driver.close();


}
}
