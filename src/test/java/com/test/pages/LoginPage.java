package com.test.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.BaseTestCase;

public class LoginPage {

	By email = By.cssSelector("input#user_email");
	By password = By.cssSelector("input#user_password");
	By loginButton = By.cssSelector("input[name='commit']");
	By message=By.cssSelector("div.alert.alert-danger");
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loadLoginPage(WebDriver driver) {
		driver.get("http://qaclickacademy.usefedora.com/sign_in");
	}
	
	public WebElement getUserID(WebDriver driver) {
		return driver.findElement(email);
	}
	
	public WebElement getUserPassword(WebDriver driver) {
		return driver.findElement(password);
	}
	
	public WebElement getLoginButon(WebDriver driver) {
		return driver.findElement(loginButton);
	}
	
	public WebElement getAlertMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(message));
		return driver.findElement(message);
	}
}
