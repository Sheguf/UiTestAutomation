package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base<TakeScreenshot> {

	public static WebDriver driver;
	public static Properties prop; // properties files defines on global level

	static {

		try {
			FileInputStream file = new FileInputStream(
					"H:\\New Test Automation Batch\\com.SwagLabs\\src\\test\\java\\resources\\env.properties");
			prop = new Properties();
			try {
				prop.load(file); // its a load method
			} catch (IOException e) {
				// TODO Auto-generated catch block //properties file read code will be in this
				// static block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Before
	public void setup() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void tearDown(Scenario s) {
		if (s.isFailed()) {
			TakesScreenshot t = (TakesScreenshot) driver; // interface predefined
			File test = t.getScreenshotAs(OutputType.FILE);// it is a method
			try {
				FileHandler.copy(test, new File("Screenshots/" + s.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.quit();
	}
	
	  public void selectDropDownByText1(WebElement ele, String value) {   //generic functions
		  Select s = new Select(ele);
		  s.selectByVisibleText(value);
		  
	  }
	  
	  public void takeScreenshot(String screenshotName) throws IOException {
		  TakeScreenshot t = (TakeScreenshot) driver;
		  File test = ((TakesScreenshot) t).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(test, new File("Screenshots/"+".png"));
	  }
	  
	  public void mouseHover(WebElement ele) {
		  Actions a = new Actions(driver);
		  a.moveToElement(ele).build().perform();
	  }
	  
	  public void selectBootstrapDropDown(List<WebElement>list,String expectedValue ) {  //made a generic method
		for (WebElement e:list) {
		String value = e.getText();
		if(value.equals(expectedValue)) {
			e.click();
			break;
		}
		  }
	  }
	  
	  public void selectDropDownByText(WebElement ele,String value) {
		  Select s = new Select(ele);
		  s.selectByVisibleText(value);
	  }
	  
	  public void selectDropDownByIndex(WebElement ele,int num) {
		  Select s = new Select(ele);
		  s.selectByIndex(num);
		  }
	  
	  public void javaScriptClick(WebElement ele) {
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();",ele);
	  }
	  
	  public void selectAlertPopUp() {
		Alert a = driver.switchTo().alert();
		a.accept();
	  }
	  
	  public void click(WebElement ele) {
		  try {
			  ele.click();
		  }catch (Exception e) {
			  javaScriptClick(ele);
		  }
	  }
	  
}
