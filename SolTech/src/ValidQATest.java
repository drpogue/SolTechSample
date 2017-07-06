import java.util.ArrayList;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ValidQATest {
	@Test
	public void testSampleTestCase() throws Exception {
		//Tell System where the Chrome driver is
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Keaton\\eclipse-workspace\\selenium\\SolTech\\lib\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//set window to specified size
		driver.manage().window().setSize(new Dimension(1814,974));
		driver.get("http://soltech.net");
		
		// Search for and click on “Open Positions”
		WebElement careers = driver.findElement(By.xpath("//*[contains(text(),'Careers')]"));
		Actions builder = new Actions(driver);
		//move the mouse to menu option
		builder.moveToElement(careers).build().perform();
		//wait
		Thread.sleep(500);
		WebElement open = driver.findElement(By.xpath("//*[contains(text(),'Open Positions')]"));
		builder.moveToElement(open).build().perform();
		open.click();
		
		// Type “QA” into keyword text box
		//change tab by handle
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		//deal with iframe
		driver.switchTo().frame("icims_content_iframe");
		WebElement keyword = driver.findElement(By.id("jsb_f_keywords_i"));
		builder.moveToElement(keyword).click().sendKeys(keyword,"QA").perform();
		// Click “Submit”
		driver.findElement(By.id("jsb_form_submit_i")).click();
		// Click “Quality Assurance Automation Engineer”
		driver.findElement(By.linkText("Quality Assurance Automation Engineer")).click();
		//Verify ID 2017-1958 , also print to console
		WebElement id = driver.findElement(By.className("iCIMS_JobHeaderData"));
		if(id.getText().equals("2017-1958")) {
			System.out.println("Test Case Passed");
		}else
			System.out.println("Test Case Failed");
		//close driver
		driver.quit();
	}

	
}
