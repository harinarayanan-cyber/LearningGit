package week8automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UiAutomation {

	    @Test
	    public void uiAuto() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		WebElement invoices = driver.findElementByXPath("//button[text()[normalize-space()='Invoices']]");
		Actions builders = new Actions(driver);
		builders.moveToElement(invoices).perform();
		driver.findElementByLinkText("Search for Invoice").click();
		driver.findElementById("vendorTaxID").sendKeys("DE763212");
		driver.findElementById("buttonSearch").click();
		List<WebElement>  tabledata = driver.findElementsByXPath("//table[@class='table']//tr");
		int sumofrows = tabledata.size();
		for (int i=2; i<sumofrows; i++) {
		String text = driver.findElementByXPath("//table[@class='table']//tr["+i+"]/td[3]").getText();
		if(text.equals("IT Support")) {
			String text2 = driver.findElementByXPath("//table[@class='table']//tr["+i+"]/td[1]").getText();
			System.out.println(text2);
		   }
		}
		driver.findElementByLinkText("Log Out").click();
		driver.close();
	}

}
