import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import Utility.CommonFunctionality;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestNgPage  {
	public static WebDriver driver;
	String driverPath;
	String browser;
	String appURL;
	CommonFunctionality obj;
	public Properties prop;
	 

	
	@BeforeSuite
	public void launchBrowser() throws IOException
	{
		//To get the property
		//browser =  
		//appURL = prop.getProperty("appURL");
				
	    prop = CommonFunctionality.setPropertyFilePath("config.properties");
		browser = prop.getProperty("browser");
		appURL = prop.getProperty("appURL");
		
		
		if(browser.equalsIgnoreCase("Chrome")) {
			//driver = new ChromeDriver(); (If there exist an chrome driver dependencies in POM.XML file)
			
			//If there exists Web Driver Manager in POM.XML file
			//WebDriverManager.chromedriver().setup();
			String chromedriverpath = System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("Firefox")) {
			//driver = new FirefoxDriver(); (If there exist an firefox driver dependencies in POM.XML file)
		}else {
			System.out.println("Plese provide correct browser name in the argument");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appURL);
		obj = new CommonFunctionality(driver);
	}
	
}
