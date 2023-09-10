package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.PropertiesUtils;
import com.constants.Contstants;
import com.enums.Wait;
import com.report.runConfig.ExtentLogger;
import com.setup.DriverManager;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	ReusableMethods reusableMethods;

	// Constructor
//    public BasePage() {
//       // this.driver = driver;
//        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
//    }
	// Click Method

	public ReusableMethods getReusableMethods() {
		setReusableMethods();
		return reusableMethods;
	}

	public void setReusableMethods() {
		reusableMethods = new ReusableMethods();
	}

	protected void click(By by, Wait wait, String message) {
		explicitWait(by, wait).click();
		ExtentLogger.pass(message, true);
	}

	// Write Text
	protected void writeText(By by, Wait wait, String text) {
		explicitWait(by, wait).sendKeys(text);
	}

	// Read Text
	protected String readText(By by, Wait wait) {
		return explicitWait(by, wait).getText();
	}

	// Read Text
	protected List<String> ListReadText(By by, Wait wait) {
		// return explicitWait(by,wait).getText();
		List<WebElement> elements = DriverManager.getDriver().findElements(by);
		explicitWait(by, wait);
		ArrayList<String> items = new ArrayList<String>();
		//System.out.println(elements);
		scrollIntoView(elements.get(0));
		//System.out.println(elements.get(0).getText());
		System.out.println(elements.get(0).getAttribute("textContent"));
//		System.out.println(elements.get(0).getAttribute("innerHTML"));
//		elements.forEach(item -> items.add(item.getText()));
		elements.forEach(item -> items.add(item.getAttribute("textContent")));
		System.out.println(items);
		return items;

	}
	public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

	// Wait
	// Read Text
	protected boolean isDisplayed(By by, Wait wait) {
		return explicitWait(by, wait).isDisplayed();
	}

	protected WebElement explicitWait(By by, Wait wait) {
		WebElement element = null;
		switch (wait) {
		case CLICKABLE:
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(Contstants.getEXPLICITLYWAITTIME()))
							.until(ExpectedConditions.elementToBeClickable(by));
			break;
		case PRESENCE:
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(Contstants.getEXPLICITLYWAITTIME()))
							.until(ExpectedConditions.presenceOfElementLocated(by));
			break;

		case VISIBLE:
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(Contstants.getEXPLICITLYWAITTIME()))
							.until(ExpectedConditions.visibilityOfElementLocated(by));
			break;
		case NONE:
			element = DriverManager.getDriver().findElement(by);
			break;
		}
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + wait);
//		}
		return element;
	}
}