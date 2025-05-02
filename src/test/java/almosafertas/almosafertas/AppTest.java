package almosafertas.almosafertas;


import java.awt.RenderingHints.Key;
import java.security.KeyStoreSpi;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLBaseElement;


public class AppTest extends datatyp {
	
	
	@BeforeTest
	public void setup(){
	
		genral();
		WebElement firstButton = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		firstButton.click();
		
	
	}
	@Test(priority = 1 )
	public void CheckDefaultLanguageisEN() {
		
		String actualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		Assert.assertEquals(actualLanguage,  expeactualLanguage0); // Expected: EN

	}
	
	
	@Test(priority = 2 )
	public void cheakdDefultCurrncy() {
		String defultCurrncy= driver.findElement(By.xpath(("//button[@data-testid='Header__CurrencySelector']"))).getText();
		Assert.assertEquals(defultCurrncy, expDefultCurrncy);
	}
	
	
	@Test (priority = 3)
	public void CheckContactNumber() {
		
	String defultContactNumber=driver.findElement(By.tagName("strong")).getText();
	Assert.assertEquals(defultContactNumber, expcontactnumber);
	
	}
	@Test(priority = 4 )
	public void cheaklogoqitaf() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement Footer = driver.findElement(By.tagName("footer"));
		WebElement QitafLogo = Footer.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR"));
		boolean ActualResult = QitafLogo.isDisplayed();
		Assert.assertEquals(ActualResult, ExpectedResultsForTheLogo);
		
		
	}
	@Test(priority = 5)
	public void cheackseachtapforHotel() {
		
		String tapActualValue = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected");
		Assert.assertEquals(tapActualValue, tapexpectedValue);	
	}
	
	@Test(priority = 6)

	public void CheckDepatureDate() {


		List<WebElement> depatureAndArrivalDates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));

		String ActualDepatureDate = depatureAndArrivalDates.get(0).getText();
		String ActualReturnDate = depatureAndArrivalDates.get(1).getText();

		int ActualDepatureDateAsInt = Integer.parseInt(ActualDepatureDate);
		int ActualreturnDateAsInt = Integer.parseInt(ActualReturnDate);



		Assert.assertEquals(ActualDepatureDateAsInt, Tomorrow);
		Assert.assertEquals(ActualreturnDateAsInt, AfterTomorrow);

	}
	
	@Test(priority=7)
	public void Randomchangweb() {
		
		String[] URLs = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar", };
		int RandomIndex = random.nextInt(URLs.length);

		driver.get(URLs[RandomIndex]);
	}
	@Test(priority = 7)

	public void RandomlyChangeTheLanguage() {
		String[] URLs = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar", };
		int RandomIndex = random.nextInt(URLs.length);

		driver.get(URLs[RandomIndex]);
	}

	

	@Test(priority = 8)

	public void FillHotelTab() {


		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));

		HotelTab.click();
		WebElement SearchHotelInputField = driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));

		String WebsiteURL = driver.getCurrentUrl();

		if (WebsiteURL.contains("ar")) {

			SearchHotelInputField.sendKeys(ArabicCi[randomArabicCity]);
		} else {
			SearchHotelInputField.sendKeys(EnglishCi[randomEnglishCity]);

		}

		WebElement ListOfLocations = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));

		WebElement firstResult = ListOfLocations.findElements(By.tagName("li")).get(1);
		firstResult.click();

	}
	
	@Test(priority = 9)

	public void RandomlySelectTheNumberOfVistor() {

		WebElement SelectorVistor = driver
				.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));

		Select select = new Select(SelectorVistor);

		int randomIndex = random.nextInt(2);
		select.selectByIndex(randomIndex);


		WebElement SearchHotelButton = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SearchHotelButton.click();
	}
	
	@Test(priority = 10)

	public void FullyLoaded() throws InterruptedException {

		boolean expectedResult = true;
		Thread.sleep(10000);
		String results = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"))
				.getText();

		boolean finished = results.contains("مكان") || results.contains("found");

		Assert.assertEquals(finished, expectedResult);

	}
	
	
	
	
	 
}
