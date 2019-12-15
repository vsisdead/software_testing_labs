package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://www.trivago.ru/";

	@FindBy(xpath = "//*[@id=\"js_navigation\"]/a")
	private WebElement buttonGoTo;

	@FindBy(id = "querytext")
	private WebElement searchBox;

	@FindBy(className = "search-button__label")
	private WebElement searchButton;

	@FindBy(className = "df_label")
	private WebElement messageButton;

	@FindBy(className = "alert alert--warning phrase-error")
	private WebElement linkCurrentRepository;

	private final By linkLoggedInUserLocator = By.xpath("//*[@id=\"user-text\"]");

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public CreateNewRepositoryPage invokeNewRepositoryCreation()
	{
		buttonGoTo.click();
		searchBox.sendKeys("Tetetetetetetetetetetetetetetete");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		searchButton.click();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		messageButton.click();
		return new CreateNewRepositoryPage(driver);

	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}

	public String getLoggedInUserName()
	{
		WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
		return linkLoggedInUser.getAttribute("content");
	}
}
