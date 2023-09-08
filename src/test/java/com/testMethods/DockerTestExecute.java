package com.testMethods;

import java.net.MalformedURLException;


import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;
import org.testng.annotations.Test;

public class DockerTestExecute {

	@Test
	public void localTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		//cap.setVersion("116.0");
		// ChromeOptions optios = new ChromeOptions();
//		cap.setCapability("browserVersion", "114");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--no-sandbox");
//		options.merge(cap);
		// cap.add("--headless");

//		ClientConfig config = ClientConfig.defaultConfig().connectionTimeout(Duration.ofMinutes(3))
//				.readTimeout(Duration.ofMinutes(3)); // I change this 3 minute(Default) to 20 minutes.
//				WebDriver driver = RemoteWebDriver.builder().oneOf(cap).address("http://localhost:4444").config(config).build(); // now you can use this remoteWebDriver.
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
		driver.get("https://www.amazon.in/");
		System.out.println("Titile = " + driver.getTitle());
		// Thread.sleep(50000);
		driver.findElement(By.xpath("//div/input[@type='text' and @id='twotabsearchtextbox']")).sendKeys("Iphone 14");
		driver.findElement(By.xpath("//span/input[@type='submit']")).click();
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath("//h2/a/span"));
		System.out.println(elements.get(0).getText());
		String originalWindow = driver.getWindowHandle();
		System.out.println("originalWindow = "+originalWindow);
		elements.get(0).click();
		Thread.sleep(5000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("allWindowHandles = "+allWindowHandles);
		Iterator<String> itr = allWindowHandles.iterator();
// allWindowHandles.forEach(window -> window.equals(originalWindow));
// allWindowHandles.stream().filter(window ->)
		while (itr.hasNext()) {
			String window = itr.next();

			if (!originalWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}
		System.out.println(driver.findElement(By.xpath("//h1/span")).getText());
// driver.findElement(By.xpath("//span/span[@id='submit.add-to-cart']")).click();
		javaExecutorClick(driver,"//span/input[@id='add-to-cart-button']");

		driver.findElement(By.xpath("//div/h4[contains(text(),'Added to Cart')]")).isDisplayed();
		Thread.sleep(3000);
		javaExecutorClick(driver,"//span/span[contains(text(),'Proceed to checkout')]");
// driver.findElement(By.xpath("//span/span[contains(text(),'Proceed to
// checkout')]")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//div/h1")).getText());
		driver.quit();
		driver.close();

	}
	public  void javaExecutorClick(WebDriver driver, String xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
	}
}
