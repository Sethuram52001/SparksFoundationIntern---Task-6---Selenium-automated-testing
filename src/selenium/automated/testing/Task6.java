package selenium.automated.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;


public class Task6 {

	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sethu\\OneDrive\\Desktop\\Web-Dev\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			//driver.get("https://www.thesparksfoundationsingapore.org");
			testHomePage();
			testJoinUsPage();
			testAboutUsPage();
			testPrograms();
			testContactUsPage();
			testLinksPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testHomePage() {
		try {
			driver.get("https://www.thesparksfoundationsingapore.org");
			// 1.checking for title
			if(driver.getTitle().contains("The Sparks Foundation")) {
				System.out.println("Title is verified, title: " + driver.getTitle());
			}
			else {
				System.out.println("Title is not the same as expected");
			}
			Thread.sleep(1000);
			// 2. checking for logo
			if(driver.findElement(By.xpath("//img[@src='/images/logo_small.png']")) != null) {
				System.out.println("logo is present");
			}
			else {
				System.out.println("logo is absent");
			}
			Thread.sleep(1000);
			// 3. checking for navbar
			boolean navDisplayed = driver.findElement(By.tagName("nav")).isDisplayed();
			System.out.println("Navigation bar is displayed: " + navDisplayed);
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testJoinUsPage() {
		try {
			driver.get("https://www.thesparksfoundationsingapore.org/join-us/why-join-us/");
			Thread.sleep(1000);
			// 4.checking name field, name - //input[@placeholder='Full Name']
			driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Sethu");
			Thread.sleep(1000);
			// 5.checking email field, email/number - //input[@placeholder='Email or Phone Number']
			driver.findElement(By.xpath("//input[@placeholder='Email or Phone Number']")).sendKeys("sethuram52001@gmail.com");
			Thread.sleep(1000);
			// 6. checking dropdown
			Select dropdown = new Select(driver.findElement(By.className("form-control")));
			dropdown.selectByVisibleText("Student");
			Thread.sleep(1000);
			dropdown.selectByVisibleText("Intern");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testAboutUsPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.get("https://www.thesparksfoundationsingapore.org");
			Actions actions = new Actions(driver);
			// 7. checking element in about us page
			actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[1]/a"))).click().moveToElement(driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[1]/ul/li[1]/a"))).click().perform();
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void testContactUsPage() {
		try {
			driver.get("https://www.thesparksfoundationsingapore.org/contact-us/");
			Thread.sleep(2000);
			// 8.checking linkedin link, //a[contains(text(),'JOIN TSF NETWORK HERE (https://www.linkedin.com/gr')]
			driver.findElement(By.xpath("//a[contains(text(),'JOIN TSF NETWORK HERE (https://www.linkedin.com/gr')]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void testPrograms() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.get("https://www.thesparksfoundationsingapore.org/programs/student-scholarship-program/");
			// 9. checking student mentorship
			driver.findElement(By.xpath("//div[@class='w3l_inner_section about-w3layouts']//li[1]")).click();
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,600)", "");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void testLinksPage() {
		try {
			driver.get("https://www.thesparksfoundationsingapore.org/links/ai-in-education/");
			// 10. testing links in ai page
			Thread.sleep(2000);
			driver.findElement(By.xpath("//body/div[@class='w3l_inner_section about-w3layouts']/div[@class='container']/div[@class='inner_w3l_agile_grids']/div[@class='blog-w3ls col-md-9']/div[@class='single-middle']/div[@class='media']/div[@class='media-body']/div[1]/div[1]/a[1]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Task6 t = new Task6();
		t.invokeBrowser();
		System.out.println("The test script has checked of at 6 pages and 10 elements in total.");
	}
}
