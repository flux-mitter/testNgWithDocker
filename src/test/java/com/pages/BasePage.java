package com.pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.PropertiesUtils;
import com.constants.Contstants;
import com.enums.Wait;
import com.setup.DriverManager;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	// Constructor
//    public BasePage() {
//       // this.driver = driver;
//        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
//    }
	// Click Method
	protected void click(By by,Wait wait) {
		explicitWait(by,wait).click();
	}

	// Write Text
	protected void writeText(By by, Wait wait,String text) {
		explicitWait(by,wait).sendKeys(text);
	}

	// Read Text
	protected String readText(By by, Wait wait) {
		return explicitWait(by,wait).getText();
	}

	// Wait
	// Read Text
	protected boolean isDisplayed(By by, Wait wait) {
			return explicitWait(by,wait).isDisplayed();
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