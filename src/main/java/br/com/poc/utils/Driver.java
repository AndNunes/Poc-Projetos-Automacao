package br.com.poc.utils;

import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

	private static final String HOMEPAGE = "https://globoesporte.globo.com/cartola-fc/";
	private static WebDriver driver;
	
	public static void setUpDriver() {
		
		getDriver().manage().window().maximize();
		getDriver().get(HOMEPAGE);
	}
	

	private static WebDriver getDriver() {
	
		if(driver == null) {
			
			driver = newChromeDriver();
		}
		
		return driver;
	}
	
	private static WebDriver newChromeDriver() {	
		ChromeOptions options = new ChromeOptions();
		
		
		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		return new ChromeDriver();
	}
	
	
	public static void finalizaDriver() {
		getDriver().quit();
	}
}
