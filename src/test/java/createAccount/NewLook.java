package createAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewLook {

	public static void main(String[] args) {
		
		NewLook l = new NewLook();
		l.constructor();

	}
	
	
	public void constructor() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.newlook.com/uk/login/");
		driver.manage().window().maximize();
		
		WebElement Cookies = driver.findElement(By.cssSelector("body#body"));
		Cookies.click();
		
		WebElement Create_account = driver.findElement(By.cssSelector("[data-ng-click='registerTabs = true']"));
		Create_account.click();
		
		WebElement Email_address = driver.findElement(By.cssSelector("input#email"));
		Email_address.sendKeys("xyz@gmail.com");
		
		WebElement Password = driver.findElement(By.cssSelector("input#pwd"));
		Password.sendKeys("xyz");
		
		WebElement First_name = driver.findElement(By.cssSelector("input#firstName"));
		First_name.sendKeys("Shegufa");
		
		WebElement Last_name = driver.findElement(By.cssSelector("input#lastName"));
		Last_name.sendKeys("Ansari");
		
		WebElement Above_18 = driver.findElement(By.cssSelector("label.checkbox__label"));
		Above_18.click();
		
		WebElement Create_my_account = driver.findElement(By.cssSelector("[type='submit']"));
		Create_my_account.click();
		
	}

}
