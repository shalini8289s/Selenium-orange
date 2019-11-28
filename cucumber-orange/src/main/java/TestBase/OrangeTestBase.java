package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import OrageUtil.util;


public class OrangeTestBase {
	

public static WebDriver driver;
public static Properties prop;
	
	public OrangeTestBase() {
		
			try {
				prop = new Properties();
				
					FileInputStream fis =  new FileInputStream("C:\\Users\\s.shalanipriyanga\\workspace"
							+ "\\cucumber-orange\\src\\main\\java\\OrangeCONFIG\\config.properties");
					
					prop.load(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	
	
	
	public void itialization(){
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\s.shalanipriyanga\\Desktop\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\s.shalanipriyanga\\Downloads\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(util.pageloadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(util.ImplicutyTimeOut, TimeUnit.SECONDS);
	}

	
	
}
