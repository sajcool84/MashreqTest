package MashreqBankPkg;

import org.testng.annotations.Test;
import MashreqPOM.Bank_Objects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.JavascriptExecutor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MashreqBank {
	WebDriver driver;

	@Test(priority = 0)
	public void Navigationbar_Check() throws InterruptedException {

		Bank_Objects.Navigation_bar(driver).findElements(By.tagName("li"));
		int size = Bank_Objects.Navigation_bar(driver).findElements(By.tagName("li")).size();
		for (int i = 0; i < size; i++) {
			System.out.println(Bank_Objects.Navigation_bar(driver).findElements(By.tagName("li")).get(i).getText());
		}
	}

	@Test(priority = 1)
	public void News_Check() throws InterruptedException {

		String news = Bank_Objects.News_heading(driver).getText();
		System.out.println(news);

		if (Bank_Objects.News_flash(driver).isEnabled()) {
			System.out.println("Flash news exists");
			Bank_Objects.News_flash(driver).click();

		}
	}

	@Test(priority = 2)
	public void Contact_Us_Check() throws InterruptedException {

		Bank_Objects.Contact_us(driver).click();
		System.out.println("Contact Us Page Opened Successfully");

	}

	@Test(priority = 3)
	public void Contact_Form_Mand_Check() throws InterruptedException {

		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]")).click();
		System.out.println("All the mandatory feilds are higlighted");

	}

	@Test(priority = 4)
	public void Iam_Lookingto_Check() throws InterruptedException {

		Select enq_type = new Select(Bank_Objects.Enquiry_type(driver));
		List<WebElement> elmntCount = enq_type.getOptions();
		int iSize = elmntCount.size();
		for (int i = 1; i < iSize; i++) {
			String sValue = elmntCount.get(i).getText();
			System.out.println(sValue);
		}
		int tot = iSize - 1;
		System.out.println("I am looking contains " + tot + " Values");
		if (tot == 4) {
			System.out.println("Test case passed");
		} else
			System.out.println("Test case failed");
	}

	@Test(priority = 5)
	public void Sub_Product_Check() throws InterruptedException {

		Select product_type = new Select(Bank_Objects.Prod_type(driver));
		product_type.selectByVisibleText("Loans");
		Select products = new Select(Bank_Objects.Sub_Prod(driver));
		List<WebElement> sub_prod_list = products.getOptions();
		int pSize = sub_prod_list.size();
		for (int i = 1; i < pSize; i++) {
			String sValue = sub_prod_list.get(i).getText();
			System.out.println(sValue);
			if (sValue.toString().trim().equalsIgnoreCase("Home Loan UAE Resident")) {
				System.out.println("Sub products are loaded properly");
			}

		}
		int tot = pSize - 1;
		if (tot == 6) {
			System.out.println("Test case passed");
		} else
			System.out.println("Test case failed");
	}

	@Test(priority = 6)
	public void Mobile_No_Invalid_Check() throws InterruptedException {

		Bank_Objects.Mob_no(driver).sendKeys("56763");
		String error = "Mobile number should be 7 digit";
		String error_msg = driver.findElement(By.cssSelector(".col-lg-9 > span:nth-child(2)")).getText();
		if (error_msg.toString().equalsIgnoreCase(error)) {
			System.out.println("Kindly enter proper mobile number");
		}
		driver.findElement(By.id("mobile")).clear();
		Thread.sleep(2000);

	}

	@Test(priority = 7)
	public void Mobile_No_Valid_Check() throws InterruptedException {

		Bank_Objects.Mob_no(driver).sendKeys("4567639");
		if (driver.findElement(By.cssSelector(".col-lg-9 > span:nth-child(2)")).isDisplayed() == false) {
			System.out.println("Entered Mobile number contains 7 digits");
		} else
			System.out.println("Kindly enter 7 digits mobile number");

	}

	@BeforeSuite
	public void beforeSuite() throws InterruptedException, IOException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1);
		System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
		driver = new FirefoxDriver();

		String path = "Config\\MashConfig.properties";
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		driver.navigate().to(prop.getProperty("url"));
		driver.manage().window().maximize();
		System.out.println("Browser window maximized");

	}

}
