package Esin;
import Utility.BaseDriver;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _05_HediyeSipVer extends BaseDriver {



    @Test
    public void testNopCommerce() {
        driver.get("https://demo.nopcommerce.com/");



        WebElement giftCardsTab = driver.findElement(By.linkText("Gift Cards"));
        giftCardsTab.click();
        MyFunc.Bekle(2);


        driver.findElement(By.linkText("$25 Virtual Gift Card")).click();
        MyFunc.Bekle(2);


        WebElement recipientName = driver.findElement(By.id("giftcard_43_RecipientName"));
        recipientName.sendKeys("Ayşe");
        MyFunc.Bekle(2);

        WebElement yourName = driver.findElement(By.id("giftcard_43_SenderName"));
        yourName.sendKeys("Fatma");
        MyFunc.Bekle(2);


        WebElement message = driver.findElement(By.id("giftcard_43_Message"));
        message.sendKeys("iyi ki doğdun");
        MyFunc.Bekle(2);


        driver.findElement(By.id("add-to-cart-button-43")).click();
        MyFunc.Bekle(2);


        WebElement errorPopup = driver.findElement(By.xpath("//span[@class='close']"));
        errorPopup.click();
        MyFunc.Bekle(2);


        WebElement recipientEmail = driver.findElement(By.id("giftcard_43_RecipientEmail"));
        recipientEmail.sendKeys("ayse123@gmail.com");
        MyFunc.Bekle(2);


        WebElement yourEmail = driver.findElement(By.id("giftcard_43_SenderEmail"));
        yourEmail.sendKeys("fatma123@gmail.com");
        MyFunc.Bekle(2);


        driver.findElement(By.id("add-to-cart-button-43")).click();
        MyFunc.Bekle(2);


        WebElement successMessage = driver.findElement(By.cssSelector(".bar-notification.success"));
        Assert.assertEquals(successMessage.getText(), "The product has been added to your shopping cart");
    }
}