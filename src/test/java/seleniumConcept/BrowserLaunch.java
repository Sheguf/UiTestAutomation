package seleniumConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

	public static void main(String[] args) {

		BrowserLaunch b = new BrowserLaunch();
		b.initialisation();

	}

	public void initialisation() {

		WebDriverManager.chromedriver().setup(); // browser version and system version match

		WebDriver driver = new ChromeDriver(); // chrome browser launch

		driver.get("https://www.saucedemo.com/");// Launch browser
		driver.manage().window().maximize();

		WebElement userName = driver.findElement(By.cssSelector("input#user-name")); // element identify
		userName.sendKeys("standard_user");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");

		WebElement loginBtn = driver.findElement(By.cssSelector("input#login-button"));
		loginBtn.click();

	}

}
