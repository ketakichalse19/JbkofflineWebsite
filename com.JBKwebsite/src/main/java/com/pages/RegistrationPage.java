package com.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	Logger log = Logger.getLogger(this.getClass());
	
	@FindBy(linkText = "Register a new membership")
	private WebElement registerMember;

	@FindBy(id = "name")
	private WebElement name;

	@FindBy(id = "mobile")
	private WebElement mobile;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button")
	public WebElement signinButton;

	@FindBy(xpath = "//b")
	private WebElement heading;

	@FindBy(linkText = "I already have a membership")
	private WebElement alreadyMember;

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public boolean validateRegistraionLink(WebDriver driver) {
		try {
			registerMember.click();
			log.info("Registration Clickable");
			return true;
		} catch (Throwable e) {
			log.info("Registration UnClickable");
			return false;
		}
	}

	public void EnterName() {
		name.sendKeys("ketaki");
	}

	public void EnterMobile() {
		mobile.sendKeys("9864376239");
	}

	public void EnterEmail() {
		email.sendKeys("ketaki@gmail.com");
	}

	public void EnterPassword() {
		password.sendKeys("12345");
	}

	public boolean validateAlertMessage(WebDriver driver) {
		try {
			signinButton.click();
			Alert al = driver.switchTo().alert();
			al.accept();
			log.info("Signin successfully and accept alert");
			return true;
		} catch (Throwable e) {
			log.info("Failed to SignIn");
			return false;
		}
	}

	public boolean getTitleOfRegistrationPage(WebDriver driver) {
		if (driver.getTitle().equals("JavaByKiran | Registration Page")) {
			log.info("Title match");
			return true;
		} else {
			log.info("Title mismatch");
			return false;
		}
	}

	public boolean getTextOfHeading(WebDriver driver) {
		if (heading.getText().equals("Java By Kiran")) {
			log.info("Heading match");
			return true;
		} else {
			log.info("Heading mismatch");
			return false;
		}
	}

	public boolean validateNoOfTextBoxes(WebDriver driver) {
		List<WebElement> textboxList = driver.findElements(By.tagName("input"));
		if (textboxList.size() == 4) {
			log.info("Total no of text box is correct");
			return true;
		} else {
			log.info("Total no of text box is Incorrect");
			return false;
		}
	}

	public boolean validationOfAlreadyMemberLink(WebDriver driver) {
		try {
			alreadyMember.click();
			log.info("Click successfully to I already have a membership");
			return true;
		} catch (Throwable t) {
			log.info("Unclickable to I already have a membership ");
			return false;
		}
	}

	public boolean validationOfMembership(WebDriver driver) {
		if (validationOfAlreadyMemberLink(driver) == true) {
			return driver.getTitle().equals("JavaByKiran | Log in");
		} else {
			log.info("Not return to Login page");
			return false;
		}
	}
}
