package standard_user;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StandardUserTests {

	WebDriver driver = new EdgeDriver();
	String SauceDemoWebsite = "https://www.saucedemo.com/";
	String Username = "standard_user";
	String Password = "secret_sauce";
	String FirstName = "Test";
	String LastName = "User";
	String PostalCode = "12345";

	@BeforeTest
	public void Setup() throws InterruptedException {

		driver.get(SauceDemoWebsite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Thread.sleep(1500);
	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {

		WebElement UsernameInput = driver.findElement(By.id("user-name"));
		WebElement PasswordInput = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UsernameInput.sendKeys(Username);
		Thread.sleep(500);

		PasswordInput.sendKeys(Password);
		Thread.sleep(500);

		LoginButton.click();
		Thread.sleep(1000);

		Boolean ActualResult = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(ActualResult, "Login failed");
	}

	@Test(priority = 2)
	public void VerifyProductsPage() throws InterruptedException {

		Thread.sleep(1000);
		Boolean ActualResult = driver.findElements(By.className("inventory_item")).size() > 0;
		Assert.assertTrue(ActualResult, "Products are not diplayed");
	}

	@Test(priority = 3)
	public void VerifyProductsCount() throws InterruptedException {

		Thread.sleep(1000);
		int ActualCount = driver.findElements(By.className("inventory_item")).size();
		int ExpectedCount = 6;
		Assert.assertEquals(ActualCount, ExpectedCount, "Unexpected products count");
	}

	@Test(priority = 4)
	public void AddAllProductsToCart() throws InterruptedException {

		List<WebElement> AddToCartButtons = driver
				.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));

		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i).click();
			Thread.sleep(500);
		}

		Thread.sleep(1000);
		String ActualResult = driver.findElement(By.className("shopping_cart_link")).getText();
		String ExpectedResult = "6";
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test(priority = 5)
	public void RemoveProductFromCart() throws InterruptedException {

		WebElement RemoveButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
		RemoveButton.click();
		Thread.sleep(1000);

		String ActualResult = driver.findElement(By.className("shopping_cart_link")).getText();
		String ExpectedResult = "5";
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test(priority = 6)
	public void GoToCartPage() throws InterruptedException {

		WebElement CartIcon = driver.findElement(By.className("shopping_cart_link"));
		CartIcon.click();
		Thread.sleep(1500);

		Boolean ActualResult = driver.getCurrentUrl().contains("cart");
		Assert.assertTrue(ActualResult, "Cart page not opened");
	}

	@Test(priority = 7)
	public void SortProductsLowToHigh() throws InterruptedException {

		WebElement ContinueShoppingButton = driver.findElement(By.id("continue-shopping"));
		ContinueShoppingButton.click();
		Thread.sleep(1000);

		WebElement SortDropDown = driver.findElement(By.className("product_sort_container"));
		Select SortSelector = new Select(SortDropDown);
		SortSelector.selectByValue("lohi");
		Thread.sleep(1500);

		List<WebElement> Prices = driver.findElements(By.className("inventory_item_price"));
		List<Double> ActualPrices = new ArrayList<>();
		for (WebElement Price : Prices) {
			ActualPrices.add(Double.parseDouble(Price.getText().replace("$", "")));
		}

		List<Double> SortedPrices = new ArrayList<>(ActualPrices);
		Collections.sort(SortedPrices);

		Assert.assertEquals(ActualPrices, SortedPrices, "Products are not sorted from low to high");
	}

	@Test(priority = 8)
	public void SortProductsHighToLow() throws InterruptedException {

		WebElement SortDropDown = driver.findElement(By.className("product_sort_container"));
		Select SortSelector = new Select(SortDropDown);
		SortSelector.selectByValue("hilo");
		Thread.sleep(1500);

		List<WebElement> Prices = driver.findElements(By.className("inventory_item_price"));
		List<Double> ActualPrices = new ArrayList<>();
		for (WebElement Price : Prices) {
			ActualPrices.add(Double.parseDouble(Price.getText().replace("$", "")));
		}

		List<Double> SortedPrices = new ArrayList<>(ActualPrices);
		Collections.sort(SortedPrices, Collections.reverseOrder());

		Assert.assertEquals(ActualPrices, SortedPrices, "Products are not sorted from low to high");
	}

	@Test(priority = 9)
	public void Checkout() throws InterruptedException {

		WebElement CartIcon = driver.findElement(By.className("shopping_cart_link"));
		CartIcon.click();
		Thread.sleep(1000);

		WebElement CheckoutButton = driver.findElement(By.id("checkout"));
		CheckoutButton.click();
		Thread.sleep(1000);

		WebElement FirstNameInput = driver.findElement(By.id("first-name"));
		WebElement LastNameInput = driver.findElement(By.id("last-name"));
		WebElement PostalCodeInput = driver.findElement(By.id("postal-code"));
		WebElement ContinueButton = driver.findElement(By.id("continue"));

		FirstNameInput.sendKeys(FirstName);
		Thread.sleep(500);

		LastNameInput.sendKeys(LastName);
		Thread.sleep(500);

		PostalCodeInput.sendKeys(PostalCode);
		Thread.sleep(500);

		ContinueButton.click();
		Thread.sleep(1000);

		WebElement FinishButton = driver.findElement(By.id("finish"));
		FinishButton.click();
		Thread.sleep(2000);

		Boolean ActualResult = driver.findElement(By.className("complete-header")).isDisplayed();
		Assert.assertTrue(ActualResult, "Checkout not completed");
	}

	@Test(priority = 10)
	public void Logout() throws InterruptedException {

		WebElement MenuButton = driver.findElement(By.id("react-burger-menu-btn"));
		MenuButton.click();
		Thread.sleep(1000);

		WebElement LogoutButton = driver.findElement(By.id("logout_sidebar_link"));
		LogoutButton.click();
		Thread.sleep(1500);

		Boolean ActualResult = driver.getCurrentUrl().contains("saucedemo.com");
		Assert.assertTrue(ActualResult, "Logout failed");
	}

	@AfterTest
	public void TearDown() throws InterruptedException {

		Thread.sleep(1500);
		driver.quit();
	}
}
