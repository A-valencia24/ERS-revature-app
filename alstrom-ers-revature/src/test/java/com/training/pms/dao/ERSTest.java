package com.training.pms.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ERSTest {
	String browserName = "firefox";
	WebDriver driver;

	@BeforeEach
	public void setup() {
		if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}

	@Test
	@DisplayName("Testing login functionallity of ERS")
	public void testERSLoginFunctionality() {
		driver.get("http://localhost:8080/alstron-ers-revature/logIn.html");
		driver.manage().window().maximize();
		// xpath locators
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("adrian");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345");

		driver.findElement(By.id("submit")).click();
		// assert
	}

}
