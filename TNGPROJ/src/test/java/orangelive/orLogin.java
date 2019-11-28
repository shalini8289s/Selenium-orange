package orangelive;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.maven.surefire.shade.common.org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class orLogin {

	static WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\s.shalanipriyanga\\Desktop\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

//	@Test(priority = 1)
//	public void login() {
//		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
//		driver.findElement(By.xpath("//div[@id='divLoginButton']//child::input[1]")).click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String ActualHomepageTitle = driver.getTitle();
//		String excpectedhomepageTitle = "OrangeHRM";
//		Assert.assertEquals(ActualHomepageTitle, excpectedhomepageTitle);
//		if (ActualHomepageTitle.equalsIgnoreCase(excpectedhomepageTitle)) {
//			System.out.println("Login is susscefull");
//		} else {
//			System.out.println("Login is Unsuccsfull");
//		}
//
//	}
//	
	
	
	public void loginnohard(String usr,String pwd){
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(usr);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(pwd);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@id='divLoginButton']//child::input[1]")).click();
		
	}
	
//	@Test(priority = 1)
//	public void Homepage_Admin(){
//		loginnohard("Admin", "admin123");
//		driver.findElement(By.xpath("//*[contains(text(),'Admin')]//parent::a[@id='menu_admin_viewAdminModule']")).click();
//		driver.findElement(By.xpath("//*[contains(text(),'User Management')]")).click();
//		driver.findElement(By.xpath("//*[contains(text(),'User Management')]//following::a[contains(text(),'Users')]")).click();
//		
//	}
	
	
//	@Test(priority=1)
//	public void mouseover_menuOption() throws InterruptedException{
//		orLogin("Admin", "admin123");
//		Thread.sleep(2000);
//		WebElement PIM = driver.findElement(By.xpath("//*[contains(text(),'PIM')]"));
//		WebElement PIM_submenu = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']//following::ul[1]"));
//		Actions menu_submenu = new Actions(driver);
//		menu_submenu.moveToElement(PIM).build().perform();
//		Thread.sleep(1000);
//		boolean PIM_Submenu = PIM_submenu.isDisplayed();
//		Assert.assertTrue(PIM_Submenu);
//	}
		
		
		
//	@Test
//	public void PIM_list() throws InterruptedException{
//		loginnohard("Admin", "admin123");
//		WebElement PIM = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));
//		PIM.click();
//		WebElement Employment_Status = driver.findElement(By.xpath("//*[@id='empsearch_employee_status']"));
//		
//		Thread.sleep(1000);
//		Select PIMlist = new Select(Employment_Status);
//		List<WebElement> list = PIMlist.getOptions();
//		System.out.println(list.size());
//			for(WebElement PIM_LIST:list)	{
//				System.out.println(PIM_LIST.getText());
//			}
//	
//	}
	
//	@Test
//	public void employeetest() throws InterruptedException{
//		loginnohard("Admin", "admin123");
//		WebElement PIM = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));
//		PIM.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@name='empsearch[employee_name][empName]']")).sendKeys("craig");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@name='empsearch[employee_name][empName]']//following::input[2]")).sendKeys("0006");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[contains(@value,'Search')]")).click();
//		Thread.sleep(2000);
//		List<WebElement> tdlist = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));
//		System.out.print(tdlist.size());
//		int size= tdlist.size();
//			for(int i=2;i<=size;i++){
//				String text = tdlist.get(i).getText();
//				System.out.println(text);
/*//				
			}
				
			
	}*/
	
	public static void screenshot(String filename){
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filepath = "C:\\Users\\s.shalanipriyanga\\workspace\\TNGPROJ\\screenshots"+filename+".png";
		File destination = new File(filepath);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	@Test
	public void PIMtable() throws InterruptedException {
		loginnohard("Admin", "admin123");
		Thread.sleep(1000);
		WebElement PIM = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));
		PIM.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> row= driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));
		int rowcount = row.size();
		System.out.println(rowcount);
		for(int i=1;i<=rowcount;i++){
		String bxpath = "//*[@id='resultTable']/tbody/tr[";
		String axpath = "]/td[3]/a";
		String actualx = bxpath+i+axpath;
		WebElement lastname = driver.findElement(By.xpath(actualx));
		System.out.println(lastname.getText());
		String Firstname = lastname.getText();
		if(Firstname.equalsIgnoreCase("steven")){
		WebElement checkbox = driver.findElement(By.xpath(actualx+"//parent::td/preceding-sibling::td//input"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", checkbox);
		Thread.sleep(4000);
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1000)");
    	Thread.sleep(4000);
//		js.executeScript("window.scrollTo(0,100)");
//		Thread.sleep(4000);
//		js.executeScript("histroy.go(0)");
//		Thread.sleep(4000);
		WebElement scrollupto = driver.findElement(By.xpath("//*[text()='Configuration']/parent::li/parent::ul"));
		js.executeScript("arguments[0].scrollIntoView(true)", scrollupto);
		Thread.sleep(4000);
		screenshot("tablescroll");
		}
		}

	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
