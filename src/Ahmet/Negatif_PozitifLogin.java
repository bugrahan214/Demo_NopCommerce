package Ahmet;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class Negatif_PozitifLogin extends BaseDriver {


    @Test(dataProvider = "getdata" )
    public void Test(String isim, String sifre) {


        WebElement giris = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ico-login']")));
        giris.click();

        WebElement eMail = driver.findElement(By.xpath("(//div[@class='inputs'])/input[@class='email']"));
        eMail.clear();
        MyFunc.Bekle(1);
        eMail.sendKeys(isim);
        MyFunc.Bekle(1);

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.clear();
        MyFunc.Bekle(1);
        password.sendKeys(sifre);
        MyFunc.Bekle(1);

        WebElement submit = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        submit.click();
        MyFunc.Bekle(1);

       // WebElement anasayfa= driver.findElement(By.xpath(""));
        WebElement message1 = driver.findElement(By.xpath("//div[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        MyFunc.Bekle(1);
        WebElement message2 = driver.findElement(By.xpath("//span[@class='field-validation-error']//span"));
        MyFunc.Bekle(1);
        WebElement logout= driver.findElement(By.xpath("//a[text()='Log out']"));
        MyFunc.Bekle(1);

       if ((isim.equals("tefekahmet@gmail.com"))&(sifre.equals("kaan2015")))
           Assert.assertTrue(logout.getText().toLowerCase().contains("Log"));

            else
           Assert.assertTrue(message1.getText().toLowerCase().contains("Login was unsuccessful"));

           if (isim.equals(""))
               Assert.assertTrue(message2.getText().toLowerCase().contains("Please enter your"));
           else
               Assert.assertTrue(message1.getText().toLowerCase().contains("Login was unsuccessful"));

    }

            @DataProvider
            public Object[][] getdata () {
                Object[][] data = {
                        {"a@gmail.com","1234"},
                        {"b@gmail.com","1234"},
                        {"c@gmail.com","1234"},
                        {"","1234"},
                        {"e@gmail.com","1234"},
                        {"tefekahmet@gmail.com",""},
                        {"tefekahmet@gmail.com","kaan2015"}
                };
                return data;
            }

        }

