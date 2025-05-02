package almosafertas.almosafertas;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class datatyp {
	
	
	

	WebDriver driver = new ChromeDriver();

	

	String expeactualLanguage0= "en";
	String expDefultCurrncy= "SAR";
	String AlMosaferURL = "https://global.almosafer.com/en";
	String expcontactnumber="+966554400000";
	JavascriptExecutor js=  (JavascriptExecutor)driver ;
	boolean ExpectedResultsForTheLogo = true;
	String tapexpectedValue = "false";
	LocalDate todayDate = LocalDate.now();
	int Today = todayDate.getDayOfMonth();
	int Tomorrow = todayDate.plusDays(1).getDayOfMonth();
	int AfterTomorrow = todayDate.plusDays(2).getDayOfMonth();
	String[] ArabicCi = { "دبي", "جدة" };
	String[] EnglishCi = { "Dubai", "Jeddah", "Riyadh" };
	Random random = new Random();
	int randomArabicCity = random.nextInt(ArabicCi.length);
	int randomEnglishCity = random.nextInt(EnglishCi.length);

	
public void genral() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(AlMosaferURL);
		driver.manage().window().maximize();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
