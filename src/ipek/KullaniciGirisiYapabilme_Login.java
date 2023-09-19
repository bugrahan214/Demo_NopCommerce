package ipek;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KullaniciGirisiYapabilme_Login {
    @Test
    public void KullaniciGirisiYapabilme() {
        WebDriver driver; // SingletonDriver method
        WebDriverWait wait;
        driver = new ChromeDriver(); // jenkins deyken : sen head olmadan yani hafızada çalış
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://demo.nopcommerce.com");

        WebElement loginButton = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginButton.click();

        WebElement eMailBox = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        Assert.assertTrue(eMailBox.isEnabled());

        WebElement passwordBox = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        Assert.assertTrue(passwordBox.isEnabled());

        eMailBox.sendKeys("t.one.techno@gmail.com"+Keys.TAB);
        passwordBox.sendKeys("TOtechno1");

        WebElement loginClick = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginClick.click();

        WebElement logoutClick = driver.findElement(By.xpath("//a[@class='ico-logout']"));
        Assert.assertTrue(logoutClick.isEnabled());
    }
}
