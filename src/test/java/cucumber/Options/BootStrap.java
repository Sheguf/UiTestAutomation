package cucumber.Options;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BootStrap {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html#");
		driver.manage().window().maximize();
		
		WebElement dropDownBtn= driver.findElement(By.cssSelector("button#menu1"));
		dropDownBtn.click();

		List<WebElement> dropDownElement=driver.findElements(By.cssSelector("ul.dropdown-menu li a"));
		
		int sizeOfList= dropDownElement.size();
		System.out.println(sizeOfList);
		
		for(WebElement e: dropDownElement) {
			
			String value= e.getText();
			System.out.println(value);
			
			if (value.equals("JavaScript")){
				e.click();
				break;
			}
		}
	}

}
