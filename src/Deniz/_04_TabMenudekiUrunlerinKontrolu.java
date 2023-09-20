package Deniz;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Arrays;

public class _04_TabMenudekiUrunlerinKontrolu extends BaseDriver {


    @Test
    @Parameters("searchText")
    public void TabMenudekiUrunlerinKontrolu(String arananUrun) {

//        Utility.MyFunc.Bekle(2);
//
//        WebElement login = driver.findElement(By.xpath("//a[@class='ico-login']"));
//        login.click();
//
//        WebElement email = driver.findElement(By.xpath("//input[@class='email']"));
//        email.sendKeys("t.one.techno1@gmail.com");
//
//        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
//        password.sendKeys("Abc123");
//
//        WebElement loginBtn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
//        loginBtn.click();


        //****************/

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
        List<WebElement> computerList = driver.findElements(By.xpath("(//ul[@class='sublist first-level'])[1]"));
        for (WebElement c : computerList)
            System.out.println(c.getText());
        System.out.println();

        MyFunc.Bekle(1);
        WebElement notebooks = driver.findElement(By.xpath("//a[text()='Notebooks ']"));
        notebooks.click();

        MyFunc.Bekle(1);


        int s=0;

        List<WebElement> notebookList = driver.findElements(By.xpath("//div[@class='item-grid']//h2[@class='product-title']"));

        String[] notebooklar= new String[notebookList.size()];

        for (WebElement n : notebookList) {
            notebooklar[s]=n.getText();
            s++;
        }
        // System.out.println(n.getText());
        System.out.println();


        MyFunc.Bekle(1);
        WebElement anaSayfa2 = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        anaSayfa2.click();

        MyFunc.Bekle(2);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(arananUrun + Keys.ENTER);

        List<WebElement> secilenUrunimage=driver.findElements(By.xpath("//div[@class='picture']"));
        MyFunc.Bekle(2);

        int randomSecim=MyFunc.randomGenerator(secilenUrunimage.size());
        System.out.println("r= " +randomSecim);
        secilenUrunimage.get(randomSecim).click();

        WebElement kontrol=driver.findElement(By.xpath("//div[@class='product-name']"));

        System.out.println("r= " +randomSecim);


        for (int i = 0; i < notebooklar.length; i++) {
            if (!notebooklar[i].contains(kontrol.getText())) {
                System.out.println("Ürün Listede Yok");
                break;
            }
        }

        }


    }


