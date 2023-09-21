package Yasin;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _02_ParametreliAramaIslemi extends BaseDriver {

    @Test
    @Parameters("mesaj")
    public void ParametreliArama(String gelen) throws AWTException {

        Robot robot=new Robot();

        WebElement searchBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
        searchBox.sendKeys(gelen);
        MyFunc.Bekle(2);

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        WebElement adobeText=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[@class='product-name']//h1")));
        System.out.println("adobeText.getText() = " + adobeText.getText());

        Assert.assertTrue(adobeText.getText().contains(gelen));


    }
}
