package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KittyIpsum {

	@Test(groups = { "SmokeTests"}) // testNG annotation
	public void getKittyIpsum() {

		// create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver sally = new ChromeDriver();

		// open page
		String url = "http://www.catipsum.com/";
		sally.get(url);
		System.out.println("Page is open");

		// change number of paragraphs
		WebElement numberOfPara = sally.findElement(By.className("param_input"));
		numberOfPara.clear();
		sleep(3000);
		numberOfPara.sendKeys("4");

		// click checkbox
		WebElement checkbox = sally.findElement(By.id("add_prefix"));
		checkbox.click();

		// make muffins
		WebElement muffinBtn = sally.findElement(By.className("generate_copy_btn"));
		muffinBtn.click();

		// verifications
		// url changes
		String expectedURL = "http://www.catipsum.com/index.php";
		String actualURL = sally.getCurrentUrl();
		Assert.assertTrue(actualURL.contains(expectedURL), "newURL does not contain expectedURL");

		// text contains "Cat ipsum dolor"
		WebElement bodyText = sally.findElement(By.className("body_text"));
		String actualText = bodyText.getText();
		String expectedText = "Cat ipsum dolor";
		Assert.assertTrue(actualText.contains(expectedText), "actualText does not contain expectedText - Line 48");

		// close all windows of the browser
		sally.quit();
		System.out.println("page is closed");
	}

	private void sleep(long milliseconds) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
