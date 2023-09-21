package Yasin;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_KullaniciKaydiRegisterOlusturma extends BaseDriver {

    @Test(dataProvider = "getData")
    public void KullaniciKaydiOlusturma(String isim,String soyisim,String mail,String sifre,String sifre2,String mail2,String sifre3){

        WebElement register=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
        register.click();

        WebElement gender =wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-male")));
        gender.click();

        WebElement firstName=driver.findElement(By.id("FirstName"));
        firstName.sendKeys(isim);

        WebElement lastName=driver.findElement(By.id("LastName"));
        lastName.sendKeys(soyisim);

        WebElement selectDay=driver.findElement(By.name("DateOfBirthDay"));
        WebElement selectMonth=driver.findElement(By.name("DateOfBirthMonth"));
        WebElement selectYear=driver.findElement(By.name("DateOfBirthYear"));


        Select day=new Select(selectDay);
        Select month=new Select(selectMonth);
        Select year=new Select(selectYear);

        day.selectByValue("1");
        month.selectByValue("4");
        year.selectByValue("1996");
        MyFunc.Bekle(2);

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys(mail);

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys(sifre);

        WebElement comfirmPassword=driver.findElement(By.id("ConfirmPassword"));
        comfirmPassword.sendKeys(sifre2);


        WebElement registerBtn=driver.findElement(By.id("register-button"));
        registerBtn.click();



        WebElement success=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result']")));
        Assert.assertTrue(success.getText().contains("completed"));

        WebElement continue1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='buttons']/a")));
        continue1.click();

        WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log in")));
        login.click();

        WebElement email2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        email2.sendKeys(mail2);

        WebElement password2=driver.findElement(By.id("Password"));
        password2.sendKeys(sifre3);

        WebElement login2=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        login2.click();

        WebElement myAccount=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My account")));
        Assert.assertTrue(myAccount.getText().contains("My account"));


    }


    @DataProvider
    Object[][] getData()
    {
        Object[][] data={{"mahmut","yıldırım","ahmet15@gmail.com","izmir35KSK","izmir35KSK","ahmet15@gmail.com","izmir35KSK"}};
        return data;
    }



}
