package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTests {
	@Test  //testNG annotation defining this as a test
	public void loginTest () {
			
			//create driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			sleep(3000);
			
			driver.manage().window().maximize();
			
			//open page
			String url = "https://the-internet.herokuapp.com/login";
			driver.get(url);
			
			sleep(5000);
			System.out.println("page is open");
			
			//enter username
			//enter password
			//click login button
			//verifications
			//new URL
			//logout button is visible
			//successful login message
			
			//close browser
			driver.quit();
			System.out.println("page is closed");
	}

	//driver will pause for specified time in milliseconds - surrounded in try/catch to get rid of eclipse error
	private void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
