package EventHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class EventHandlingDemo {
	
	static String actualText, expectedText;
	static SoftAssert sa = new SoftAssert();
	static WebElement webele, webele1, webele2;
	static Alert alert;
	
	public static void main(String[] args) throws InterruptedException {
		String chromedriverpath = System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		
		//Launch the chrome browser
		WebDriver driver = new ChromeDriver();
		
		//Launch the application
		driver.get(System.getProperty("user.dir")+"\\template_7\\index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//a[@href='alerts.html']")).click();
//		
//		//Alert Handling → Alert Box
//		driver.findElement(By.xpath("//input[@value='Alert Box']")).click();
//		Alert alert = driver.switchTo().alert();
//		actualText = "This is a warning message!";
//		expectedText = alert.getText();
//		System.out.println(expectedText);
//		sa.assertEquals(actualText, expectedText);
//		sa.assertAll();
//		alert.accept();
//		
//		//Alert Handling → Alert Box
//		driver.findElement(By.xpath("//input[@value='Confirm Box']")).click();
//		actualText = "Do you want to continue ?";
//		expectedText = alert.getText();
//		System.out.println(expectedText);
//		sa.assertEquals(actualText, expectedText);
//		sa.assertAll();
//		alert.accept();
		
		/*//Alert Handling → PromptBox
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		WebElement elm =driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(elm);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
	 	driver.switchTo().alert().sendKeys("SYSO@GMAIL.COM");
		Thread.sleep(5000);
		System.out.println(alert.getText());
		driver.findElement(By.xpath("//input[@value='PromptBox']")).click();
		driver.switchTo().alert().sendKeys("SYSO@GMAIL.COM");*/
		 
		/*//Iframe handling
		driver.findElement(By.linkText("iFrame Handling")).click();
		System.out.println(driver.findElement(By.xpath("//h1[text()='iFrames Handling']")).isDisplayed());
		webele = driver.findElement(By.xpath("//iframe[@name='iframebasic1']"));
		driver.switchTo().frame(webele);
		driver.findElement(By.id("name")).sendKeys("SeleniumTest");
		driver.findElement(By.id("mail")).sendKeys("SeleniumTest");
		driver.switchTo().defaultContent();
		webele = driver.findElement(By.xpath("//iframe[@name='iframebasic2']"));
		driver.switchTo().frame(webele);
		driver.findElement(By.xpath("//input[@value='Alert Box']")).click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.accept();*/
		
		/*//Widow Handling
		driver.get("https://www.naukri.com/");
		String parentwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		windows.remove(parentwindow);
		int i=1;
		for(String handle : windows) {
			driver.switchTo().window(handle);
			System.out.println(i);
			System.out.println("Window : "+handle);
			System.out.println("Window Title" + driver.getTitle());
			driver.close();
			i++;
		}*/

		//Droppable
		driver.get("https://jqueryui.com/droppable/");
		Actions action = new Actions(driver);
		webele= driver.findElement(By.xpath("//iframe[@src='/resources/demos/droppable/default.html']"));
		driver.switchTo().frame(webele);
		webele1 = driver.findElement(By.id("draggable"));
		webele2 = driver.findElement(By.id("droppable"));
		//action.dragAndDrop(webele1, webele2).perform();
		action.clickAndHold(webele1).release(webele2).build().perform();
	}
}