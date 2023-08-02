package com.setup;

import java.util.HashMap;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.config.PropertiesUtils;
import com.enums.ConfigEnum;


public final class Driver {
	
	private Driver()
	{
		
	}
	
	private static WebDriver driver;
	
	public static WebDriver getDriver(String browser,String version) {
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
	public static void setDriverNull()
	{
		driver=null;
	}
	
	public static WebDriver createDriver(String browser,String version)
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
//			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.merge(cap);
			// cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(PropertiesUtils.get(ConfigEnum.URL));
		}
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
