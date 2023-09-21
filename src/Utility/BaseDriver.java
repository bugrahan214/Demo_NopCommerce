package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
            public static WebDriver driver; // SingletonDriver method
            public static WebDriverWait wait;

            @BeforeClass(groups = {"Smoke","OrderTest","Regression"})
            public void baslangicIslemleri() {
                Logger logger = Logger.getLogger(""); // output yapılan logları al.
                logger.setLevel(Level.SEVERE); // sadece ERROR ları göster

                driver = new ChromeDriver(); // jenkins deyken : sen head olmadan yani hafızada çalış
                driver.manage().window().maximize(); // Ekranı max yapıyor.
              //  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
              //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // 20 sn mühlet: elementi bulma mühleti
                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                driver.get("https://demo.nopcommerce.com/");

//            loginTesti();
            }
//
//            public void loginTesti() {
//                driver.get("https://openmrs.org/");
//                Utility.MyFunc.Bekle(2);
//
//                WebElement username = driver.findElement(By.id("username"));
//                username.sendKeys("admin");
//
//                WebElement password = driver.findElement(By.id("password"));
//                password.sendKeys("Admin123");
//
//                WebElement locationSelect = driver.findElement(By.id("Registration Desk"));
//                locationSelect.click();
//
//                WebElement loginBtn = driver.findElement(By.id("loginButton"));
//                loginBtn.click();
//
//            }
    //

            @AfterClass(groups = {"Smoke","OrderTest","Regression"})
            public void bitisIslemleri() { // tearDown
                Utility.MyFunc.Bekle(1);
                driver.quit();
            }
}
