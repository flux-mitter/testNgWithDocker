package com.setup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.config.PropertiesUtils;
import com.enums.ConfigEnum;
import com.report.runConfig.ExtentLogger;


public final class Driver {
	
	Driver()
	{
		
	}
	
	private WebDriver driver;
	
	public WebDriver getDriver(String browser,String version) throws MalformedURLException {
//		System.out.println("driver " + driver);
		if (Objects.isNull(driver))
		{
			driver = createDriver(browser,version);
		}
			
//		else if(driver.toString().contains("null"))
//		{
//		
//			driver = createDriver(browser,version);
//		}
//		System.out.println("driver2 " + driver);
//		else
//		{
//			
//		}
		
		return driver;
	}
	public void setDriverNull()
	{
		driver=null;
	}
	
	private WebDriver createDriver(String browser,String version) throws MalformedURLException
	{
		//WebDriver driver = null;
		DesiredCapabilities dc = new DesiredCapabilities();
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			
			//String downloadFilepath = System.getProperty("user.dir") + "\\" + "data" + "\\" + "reports\\download";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//			chromePrefs.put("profile.default_content_settings.popups", 0);
//			chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);
//			chromePrefs.put("download.prompt_for_download", false);
//			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions options = new ChromeOptions();
//			options.setBrowserVersion("114.0.5735.198");
			options.addArguments("--remote-allow-origins=*");
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
			//options.addArguments("−−incognito");
//			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.merge(cap);
			// cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(options);
			
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("firefox");
			System.out.println("running firefox");
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
			//driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Safari"))
		{
			driver=new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropertiesUtils.get(ConfigEnum.URL));
		//driver.get("https://google.com");
		System.out.println("Titile = " + driver.getTitle());
		driver.navigate().refresh();
		return driver;
	}
//	
//		public static void endDriver() {
//			driver.quit();
//
////		if (Objects.nonNull(DriverManager.getDriver())) {
////			DriverManager.getDriver().quit();
////			DriverManager.removeDriver();
////		}
//
//	}
	
	
}
