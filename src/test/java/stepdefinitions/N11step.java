package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.N11page;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getDriver;


public class N11step {

    N11page n11page = new N11page();
    Actions actions = new Actions(getDriver());


    @Given("Kullanıcı Anasayfaya gider.")
    public void kullanıcıAnasayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("urlN11"));
    }

    @When("Ana sayfanın yüklendiği doğrulanır.")
    public void anaSayfanınYuklendigiDogrulanır() {
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitleAnaSayfa = " + actualTitle);
        String expectedTitle = "n11 - 10 Üzerinden 11'lik Alışveriş Deneyimi";
        assertEquals(expectedTitle,actualTitle);
    }

    @And("Kullanıcı ana sayfada Giriş Yap butonunu bulur ve tıklar.")
    public void kullanıcıAnaSayfadaButonunuBulurVeTıklar() {
        n11page.btnGirisYap.click();
    }

    @And("Giriş sayfasının yüklendiği doğrulanır.")
    public void girisSayfasınınYuklendigiDogrulanır() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        String expectedUrl = "https://www.n11.com/giris-yap";
        assertEquals(actualUrl, expectedUrl);
    }

    @And("Kullanıcı giriş yap sayfasında kullanıcı adı alanına geçerli bir kullanıcı adı girer.")
    public void kullanıcıGirisYapSayfasındaKullanıcıAdıAlanınaGecerliBirKullanıcıAdıGirer() {
        n11page.btnEmail.sendKeys(ConfigReader.getProperty("email"));
    }

    @And("Kullanıcı giriş yap sayfasında şifre alanına geçerli bir şifre girer.")
    public void kullanıcıGirisYapSayfasındaSifreAlanınaGecerliBirSifreGirer() {
        n11page.btnPassword.sendKeys(ConfigReader.getProperty("sifre"));
    }

    @And("Kullanıcı Giriş Yap butonuna tıklar.")
    public void kullanıcıButonunaTıklar() {
        n11page.btnLogin.click();
    }

    @And("Kullanıcının hesabına başarıyla giriş yapıldığı doğrulanır.")
    public void kullanıcınınHesabınaBasarıylaGirisYapıldıgıDogrulanır() {
        actions.moveToElement(n11page.btnHesabim).perform();
        assertTrue(n11page.btnCikisYap.isEnabled());
    }

    @Then("Kullanıcı ana sayfada istediği işlemi gerçekleştirir.")
    public void kullanıcıAnaSayfadaIstedigiIslemiGerceklestirir() {
        n11page.btnSepetim.click();
    }

    @And("İşlemin başarıyla tamamlandığı doğrulanır.")
    public void ısleminBasarıylaTamamlandıgıDogrulanır() {
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitleSepetim = " + actualTitle);
        String expectedTitle = "Sepetim - n11";
        assertEquals(expectedTitle,actualTitle);
    }
}
