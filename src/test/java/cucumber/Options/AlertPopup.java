package cucumber.Options;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopup {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.manage().window().maximize();
		
		   WebElement clickMeBtn= driver.findElement(By.cssSelector("button#promptBox"));
		   clickMeBtn.click();
		   
		   Alert a = driver.switchTo().alert();
		  // a.dismiss();
		   
	String s= a.getText();
	System.out.println(s);
		   
		   a.sendKeys("Test Automation");
		   a.accept();
	}

}
