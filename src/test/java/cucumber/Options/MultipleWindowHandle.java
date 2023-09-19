package cucumber.Options;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandle {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html#google_vignette");
		driver.manage().window().maximize();
		
	 String parentId= driver.getWindowHandle();
	 System.out.println(parentId);
	 
	 WebElement btn1= driver.findElement(By.cssSelector("button#newTabsBtn"));
	 btn1.click();
	 
	     Set<String>allWindow= driver.getWindowHandles();  //all open window---- parentId+childId
	     
	     for(String s:allWindow) {
	    	 if(!parentId.equals(s)) {
	    		 
	    		 driver.switchTo().window(s);
	    		 
	    		 String title= driver.getTitle();
	    		 if (title.equals("AlertsDemo - H Y R Tutorials")) {
	    WebElement clickMeBtn= driver.findElement(By.cssSelector("button#alertBox"));
	    	clickMeBtn.click();
	    	
	             Alert a= driver.switchTo().alert();
	             a.accept();
	             break;
	    		 }
	}

}
}
}
