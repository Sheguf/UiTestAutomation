package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;


public class LoginPage extends Base {
	

	
public void user_Login_Application() {
		
		 WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
		   userName.sendKeys(prop.getProperty("username"));
		   
		   WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		   password.sendKeys(prop.getProperty("password"));
		}
		public void user_click_on_button() {
		    WebElement loginBtn= driver.findElement(By.xpath("//input[@id='login-button']"));
		    loginBtn.click();
		    
		  WebElement test = driver.findElement(By.xpath(""));
		    mouseHover(test);
		  List<WebElement>list= (List<WebElement>) driver.findElement(By.xpath(""));
		    selectBootstrapDropDown(list,"India");

	}
		public boolean validate_successful_login() {
		return driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();  //assert condition tells validation
		}
}
