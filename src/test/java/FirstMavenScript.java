import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstMavenScript {

	@Test
	public void launchBrowser() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.fb.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
	}
}
