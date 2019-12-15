package com.epam.ta.page;

import com.epam.ta.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();

	private final String PAGE_URL = "https://access.trivago.com/oauth/ru-RU/login";

	@FindBy(id = "check_email")
	private WebElement inputLogin;

	@FindBy(xpath = "//*[@id=\"login_email_submit\"]")
	private WebElement buttonNext;

	@FindBy(xpath = "//*[@id=\"register_password\"]")
	private WebElement inputRegPassword;
	@FindBy(xpath = "//*[@id=\"login_password\"]")
	private WebElement inputLogPassword;

	@FindBy(xpath = "//*[@id=\"register_email_submit\"]")
	private WebElement buttonRegSubmit;
	@FindBy(xpath = "//*[@id=\"login_submit\"]")
	private WebElement buttonLogSubmit;


	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public LoginPage openPage()
	{
		driver.navigate().to(PAGE_URL);
		logger.info("Login page opened");
		return this;
	}

	public MainPage login(User user)
	{
		inputLogin.sendKeys(user.getUsername());
		buttonNext.click();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		inputLogPassword.sendKeys(user.getPassword());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		buttonLogSubmit.click();
		logger.info("Login performed");
		return new MainPage(driver);
	}
}
