package MashreqPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Bank_Objects {

	private static WebElement element = null;

	public static WebElement Navigation_bar(WebDriver driver) {

		element = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[1]/nav/div/div[1]/div/ul"));

		return element;

	}

	public static WebElement News_heading(WebDriver driver) {

		element = driver
				.findElement(By.xpath("/html/body/div[2]/div[4]/div[3]/ui-view/div[1]/div[3]/div[2]/div[1]/div/h3"));

		return element;

	}

	public static WebElement News_flash(WebDriver driver) {

		element = driver.findElement(
				By.xpath("/html/body/div[2]/div[4]/div[3]/ui-view/div[1]/div[3]/div[2]/div[1]/div/div/a[2]/span"));

		return element;

	}

	public static WebElement Contact_us(WebDriver driver) {

		element = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[1]/nav/div/div[2]/div/ul/li[3]/a/p"));

		return element;

	}

	public static WebElement Enquiry_type(WebDriver driver) {

		element = driver.findElement(By.id("reachoutforproduct"));

		return element;

	}

	public static WebElement Prod_type(WebDriver driver) {

		element = driver.findElement(By.id("need"));
		return element;

	}

	public static WebElement Sub_Prod(WebDriver driver) {

		element = driver.findElement(By.id("product"));
		return element;

	}

	public static WebElement Mob_no(WebDriver driver) {
		element = driver.findElement(By.id("mobile"));
		return element;
	}

}
