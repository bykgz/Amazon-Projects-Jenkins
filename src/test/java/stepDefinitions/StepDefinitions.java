package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;




public class StepDefinitions {
    AmazonPage amazon = new AmazonPage();



    @Given("Kullanici Amazon anasayfasina gider")
    public void kullanici_amazon_anasayfasina_gider() {

        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));
        ReusableMethods.waitFor(1);
    }

    @When("Giris yap sekmesine tiklar")
    public void giris_yap_sekmesine_tiklar() {
        ReusableMethods.waitFor(1);
        BrowserUtilities.clickWithJS(amazon.accountList);
    }

    @Then("Gecerli kullanici adini girer")
    public void gecerli_kullanici_adini_girer() {
        ReusableMethods.waitFor(1);
        amazon.emailBox.sendKeys("mustafa_bykgz@hotmail.com");

    }

    @Then("Devam et butonuna tiklar")
    public void devam_et_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        amazon.submitButton.click();
    }



    @Then("Gecerli password bilgisini girer")
    public void gecerli_password_bilgisini_girer() {
        ReusableMethods.waitFor(1);
        amazon.passwordBox.sendKeys("060512020mM");

    }

    @Then("Giris yap butonuna tiklar")
    public void giris_yap_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        amazon.passwordButton.click();
    }

    @Then("Kullanici arama kutusuna herhangi bir gecerli veri girisi yapar")
    public void kullanici_arama_kutusuna_herhangi_bir_gecerli_veri_girisi_yapar() {
        ReusableMethods.waitFor(1);
        amazon.searchBox.sendKeys("Java", Keys.ENTER);


    }


    @Then("Kullanici arama sonuclarini fiyati dusukten yuksege siralar")
    public void kullanici_arama_sonuclarini_fiyati_dusukten_yuksege_siralar() {

        ReusableMethods.waitFor(1);
        amazon.getDropDownMenu2.click();
        amazon.lowToHigh.click();


    }

    @Then("Kullanici fiyati en dusuk olan urune tiklar")
    public void kullanici_fiyati_en_dusuk_olan_urune_tiklar() {
        ReusableMethods.waitFor(1);
        amazon.product.click();

    }

    @Then("Kullanici urunu sepete ekler")
    public void kullanici_urunu_sepete_ekler() {
        ReusableMethods.waitFor(1);
        amazon.addToCard.click();

    }

    @Then("Kullanici urunun sepete eklendigini dogrular")
    public void kullaniciUrununSepeteEklendiginiDogrular() {
        ReusableMethods.waitFor(1);

        Assert.assertTrue(amazon.addToCartAssert.getText().contains("Sepete Eklendi"));
        // test başarılı oldu.

        ReusableMethods.waitFor(1);
        BrowserUtilities.clickWithJS(Driver.getDriver().findElement(By.cssSelector("[data-action=\"ewc-delete-item\"]")));




        //Driver.closeDriver();
    }
}

