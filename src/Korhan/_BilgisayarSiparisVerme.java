package Korhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class _BilgisayarSiparisVerme extends BaseDriver{

   @Test
   public void SiparisVer(){


//        WebElement login = driver.findElement(By.xpath("//a[@class='ico-login']"));
//        login.click();
//
//        WebElement email = driver.findElement(By.xpath("//input[@class='email']"));
//        email.sendKeys("lykan23@gmail.com");
//
//        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
//        password.sendKeys("2430177");
//
//        WebElement loginBtn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
//        loginBtn.click();
//
//
//      //****************/

       MyFunc.Bekle(1);
      WebElement anaSayfa = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
      anaSayfa.click();

      MyFunc.Bekle(1);
      List<WebElement> tabMenu = driver.findElements(By.xpath("//div[@class='header-menu']"));
      for (WebElement m : tabMenu)
         System.out.println(m.getText());
      System.out.println();

      MyFunc.Bekle(1);
      WebElement computers = driver.findElement(By.xpath("//a[text()='Computers ']"));
      Actions aksiyonDriver=new Actions(driver);
      MyFunc.Bekle(2);
      aksiyonDriver.moveToElement(computers).build().perform();

      MyFunc.Bekle(1);


      MyFunc.Bekle(1);
      WebElement Desktops = driver.findElement(By.xpath("//a[text()='Desktops ']"));
       Desktops.click();

      MyFunc.Bekle(1);
      WebElement urun=driver.findElement(By.xpath("//a[text()='Build your own computer']"));
      urun.click();


        //İslemciyi random seçtirme işlemi
       MyFunc.Bekle(2);
       WebElement Processor= driver.findElement(By.id("product_attribute_1"));
       Select islemci=new Select(Processor);

       List<WebElement>optionValue =islemci.getOptions();//selectin açılan option valuelarını aldım

//       System.out.println("selectMenüsüValue=" + optionValue.size());

       int randomSecim;
       do {
           randomSecim = MyFunc.randomGenerator(optionValue.size());
       }
       while (randomSecim==0);

       System.out.println("r= " +randomSecim);
       islemci.selectByIndex(randomSecim);

       //RAM'i random seçtirme işlemi
       MyFunc.Bekle(2);
       WebElement RAM= driver.findElement(By.id("product_attribute_2"));
       Select ram=new Select(RAM);

       List<WebElement>optionValue2 =ram.getOptions();//RAM inselectin açılan option valuelarını aldım

       System.out.println("RAM_selectMenüsüValue=" + optionValue2.size());

        int randomSecim2;
       do {
           randomSecim2 = MyFunc.randomGenerator(optionValue2.size());
       }
       while (randomSecim2==0);

       //System.out.println("r= " +randomSecim);
       ram.selectByIndex(randomSecim2);

       //Hdd random seçtirdim
       MyFunc.Bekle(2);
       List<WebElement> Hdd= driver.findElements(By.xpath("//input[@name='product_attribute_3']"));

       int randomSecim3=MyFunc.randomGenerator(Hdd.size());
       Hdd.get(randomSecim3).click();

       //Add to cart tıkla

       MyFunc.Bekle(2);
       WebElement addtoCart=driver.findElement(By.id("add-to-cart-button-1"));
       addtoCart.click();

       MyFunc.Bekle(1);

       WebElement kontrol=driver.findElement(By.xpath("//p[@class='content']"));
       Assert.assertTrue(kontrol.getText().contains("The product has been added to your"),"Ürün eklenemedi");


   }

}
