package Demo_NopCommerce;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;


public class DemoNopCommerce extends BaseDriver {

    @Test(dataProvider = "getData2",priority = 1,groups ={"Smoke"})
    public void KullaniciKaydiOlusturma(String isim,String soyisim,String mail,String sifre,String sifre2,String mail2,String sifre3) {
        WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
        register.click();

        WebElement gender = wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-male")));
        gender.click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys(isim);

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys(soyisim);

        WebElement selectDay = driver.findElement(By.name("DateOfBirthDay"));
        WebElement selectMonth = driver.findElement(By.name("DateOfBirthMonth"));
        WebElement selectYear = driver.findElement(By.name("DateOfBirthYear"));


        Select day = new Select(selectDay);
        Select month = new Select(selectMonth);
        Select year = new Select(selectYear);

        day.selectByValue("1");
        month.selectByValue("4");
        year.selectByValue("1996");
        MyFunc.Bekle(2);

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys(mail);

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys(sifre);

        WebElement comfirmPassword = driver.findElement(By.id("ConfirmPassword"));
        comfirmPassword.sendKeys(sifre2);


        WebElement registerBtn = driver.findElement(By.id("register-button"));
        registerBtn.click();


        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result']")));

        Assert.assertTrue(success.getText().contains("completed"));

        WebElement continue1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='buttons']/a")));
        continue1.click();

        MyFunc.Bekle(2);

        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();

        WebElement email2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        email2.sendKeys(mail2);

        WebElement password2 = driver.findElement(By.id("Password"));
        password2.sendKeys(sifre3);

        WebElement login2 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        login2.click();

        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My account")));
        Assert.assertTrue(myAccount.getText().contains("My account"));

        WebElement logOut=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
        logOut.click();

    }
        @DataProvider
        Object[][] getData2()
        {
            Object[][] data2={{"mahmut","yıldırım","ahmet27@gmail.com","izmir35KSK","izmir35KSK","ahmet27@gmail.com","izmir35KSK"}};
            return data2;
        }


    @Test(priority = 3,groups = {"Smoke"})
    public void KullaniciGirisiYapabilme()
    {
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginButton.click();

        MyFunc.Bekle(2);

        WebElement eMailBox = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        Assert.assertTrue(eMailBox.isEnabled());

        MyFunc.Bekle(2);

        WebElement passwordBox = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        Assert.assertTrue(passwordBox.isEnabled());

        eMailBox.sendKeys("ahmet27@gmail.com"+ Keys.TAB);
        MyFunc.Bekle(2);
        passwordBox.sendKeys("izmir35KSK");

        MyFunc.Bekle(2);

        WebElement loginClick = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginClick.click();

        WebElement logoutClick = driver.findElement(By.xpath("//a[@class='ico-logout']"));
        Assert.assertTrue(logoutClick.isEnabled());


    }

    @Test(dataProvider = "getdata",priority = 2,groups = {"Smoke"})
    public void NegVePozLoginKombinasyonlari(String isim, String sifre)
    {

        WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log in")));
        login.click();

//        WebElement giris = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ico-login']")));
//        giris.click();

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


        if (isim.equals("")) {
            WebElement message2 = driver.findElement(By.xpath("//span[@class='field-validation-error']//span"));
            Assert.assertTrue(message2.getText().contains("Please enter your"));


        }else {
            WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My account")));
            Assert.assertTrue(myAccount.getText().contains("My account"));
        }

        WebElement logOut=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
        logOut.click();

        MyFunc.Bekle(2);

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
                {"ahmet27@gmail.com","izmir35KSK"}
        };
        return data;
    }


    @Test(enabled = false,priority = 4,groups = {"Regression"})
    public void TabMenusuKontrolu() {
        String Computers = "https://demo.nopcommerce.com/computers";
        String Electronics = "https://demo.nopcommerce.com/electronics";
        String Apparel = "https://demo.nopcommerce.com/apparel";
        String DigitalDowloads = "https://demo.nopcommerce.com/digital-downloads";
        String Books = "https://demo.nopcommerce.com/books";
        String Jewelry = "https://demo.nopcommerce.com/jewelry";
        String GiftCards = "https://demo.nopcommerce.com/gift-cards";
        String Desktops = "https://demo.nopcommerce.com/desktops";
        String Notebooks = "https://demo.nopcommerce.com/notebooks";
        String Software = "https://demo.nopcommerce.com/software";
        String CameraAndPhoto = "https://demo.nopcommerce.com/camera-photo";
        String CellPhones = "https://demo.nopcommerce.com/cell-phones";
        String Others = "https://demo.nopcommerce.com/others";
        String Shoes = "https://demo.nopcommerce.com/shoes";
        String Clothing = "https://demo.nopcommerce.com/clothing";
        String Accessories = "https://demo.nopcommerce.com/accessories";

        SoftAssert asert = new SoftAssert();

        //Ana sayfa görüntüleme
        MyFunc.Bekle(2);
        WebElement anaSayfaGoruldu = driver.findElement(By.xpath("//div[@class='master-wrapper-page']"));
        Assert.assertTrue(anaSayfaGoruldu.getText().contains("nopCommerce"), "Ana sayfa görüntülenemedi");

        //Sekme ve elemanları görünüyor mu.
        MyFunc.Bekle(2);
        WebElement sekme = driver.findElement(By.xpath("//div[@class='header-menu']"));
        Assert.assertTrue(sekme.getText().contains("Computers"));

        //Var olan sekmeleri listeleme
        MyFunc.Bekle(2);
        List<WebElement> sekmeListesi = driver.findElements(By.cssSelector("[class='top-menu notmobile'] > li"));
        for (WebElement e : sekmeListesi) {
            System.out.println("Sekme Listesi : " + e.getText());
            MyFunc.Bekle(1);
        }

        MyFunc.Bekle(2);
        //Sekmelere tıkl
        // ama
        WebElement computers = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']"));
        computers.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/computers", Computers, "Oluşanla beklenen aynı değil");


        WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']"));
        electronics.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/electronics", Electronics, "Oluşanla beklenen aynı değil");

        WebElement apparel = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']"));
        apparel.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/apparel", Apparel, "Oluşanla beklenen aynı değil");

        WebElement digitalDownloads = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/digital-downloads']"));
        digitalDownloads.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/digital-downloads", DigitalDowloads, "Oluşanla beklenen aynı değil");

        WebElement books = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']"));
        books.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/books", Books, "Oluşanla beklenen aynı değil");

        WebElement jewelry = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/jewelry']"));
        jewelry.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/jewelry", Jewelry, "Oluşanla beklenen aynı değil");

        WebElement giftCards = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/gift-cards']"));
        giftCards.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/gift-cards", GiftCards, "Oluşanla beklenen aynı değil");


        //Alt menü sekme kontrol
        computers = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']"));
        MyFunc.Bekle(2);
        Actions aksiyonlar = new Actions(driver);
        Action aksiyon = aksiyonlar.moveToElement(computers).build();
        aksiyon.perform();
        WebElement desktop = driver.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[@href='/desktops']"));
        desktop.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/desktops", Desktops, "Oluşanla beklenen aynı değil");

        computers = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']"));
        aksiyon = aksiyonlar.moveToElement(computers).build();
        aksiyon.perform();
        WebElement notebook =driver.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[@href='/notebooks']"));
        notebook.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/notebooks", Notebooks, "Oluşanla beklenen aynı değil");

        computers = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']"));
        aksiyon = aksiyonlar.moveToElement(computers).build();
        aksiyon.perform();
        WebElement softWare =driver.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[@href='/software']"));
        softWare.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/software", Software, "Oluşanla beklenen aynı değil");

        electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']"));
        aksiyon = aksiyonlar.moveToElement(electronics).build();
        aksiyon.perform();
        WebElement CameraPhoto =driver.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[@href='/camera-photo']"));
        CameraPhoto.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/camera-photo", CameraAndPhoto, "Oluşanla beklenen aynı değil");

        electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']"));
        aksiyon = aksiyonlar.moveToElement(electronics).build();
        aksiyon.perform();
        WebElement cellPhones =driver.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[@href='/cell-phones']"));
        cellPhones.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/cell-phones", CellPhones, "Oluşanla beklenen aynı değil");

        electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']"));
        aksiyon = aksiyonlar.moveToElement(electronics).build();
        aksiyon.perform();
        WebElement others =driver.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[@href='/others']"));
        others.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/others", Others, "Oluşanla beklenen aynı değil");

        apparel = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']"));
        aksiyon = aksiyonlar.moveToElement(apparel).build();
        aksiyon.perform();
        WebElement shoes =driver.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[@href='/shoes']"));
        shoes.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/shoes", Shoes, "Oluşanla beklenen aynı değil");

        apparel = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']"));
        aksiyon = aksiyonlar.moveToElement(apparel).build();
        aksiyon.perform();
        WebElement clothing =driver.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[@href='/clothing']"));
        clothing.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/clothing", Clothing, "Oluşanla beklenen aynı değil");

        apparel = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']"));
        aksiyon = aksiyonlar.moveToElement(apparel).build();
        aksiyon.perform();
        WebElement accessories =driver.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[@href='/accessories']"));
        accessories.click();
        MyFunc.Bekle(2);
        Assert.assertEquals("https://demo.nopcommerce.com/accessories", Accessories, "Oluşanla beklenen aynı değil");


    }


    @Test(enabled = false,priority = 5,groups = {"Regression"})
    @Parameters("searchText")
    public void TabMenudekiUrunlerinKontrolu(String arananUrun)
    {

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

        boolean a=true;
        for (int i = 0; i < notebooklar.length; i++) {
            if(notebooklar[i].contains(kontrol.getText()))
            {
                System.out.println("Ürün Listede Var");
                break;
            }
            else
            {
                a=false;
                Assert.assertFalse(a,"Ürün listede yok");
            }

        }



        // Assert.assertTrue(notebookList.get().getText().contains(kontrol),"yok pc yokk yokk");



    }

    @Test(priority = 6,groups = {"OrderTest"})
    public void HediyeSiparisiVerme()
    {

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

        JavascriptExecutor js=(JavascriptExecutor)driver;

        WebElement anaSayfaLink= driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        js.executeScript("arguments[0].scrollIntoView(true);", anaSayfaLink);

        MyFunc.Bekle(2);


    }

    @Test(priority = 7,groups = {"OrderTest"})
    public void BilgisiyarSiparisiVerme()
    {
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

    @Test(enabled = false,priority = 8,groups = {"Smoke","Regression"})
    @Parameters("mesaj")
    public void ParametreliArama(String gelen) throws AWTException
    {
        MyFunc.Bekle(1);
        WebElement anaSayfa = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        anaSayfa.click();

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
