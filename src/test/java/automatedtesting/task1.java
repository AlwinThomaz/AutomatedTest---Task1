package automatedtesting;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task1 {

	private WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/alwinthomas/Downloads/chromedriver");
		this.driver = new ChromeDriver();
		this.driver.manage().window().fullscreen();
		

	}

	@Test
	public void test() throws InterruptedException {
		this.driver.get("http://thedemosite.co.uk/");
		Thread.sleep(2000); // milliseconds
		this.driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"))
				.click();
		Thread.sleep(2000);
		this.driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"))
				.sendKeys("Jess Layton");
		this.driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"))
		.sendKeys("password");
		this.driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"))
		.click();
		
		assertEquals("**Failed Login**", this.driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
				.getText());
		Thread.sleep(5000);
	}

	@After
	public void tearDown() {
		driver.quit();

	}
}

