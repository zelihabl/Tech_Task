package stepdefinitions;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.FormPages;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.List;
import java.util.Random;


public class P01_SignUp {
    Faker faker = new Faker();
    FormPages form = new FormPages();
    Random random = new Random();


    @Given("Kullanici {string} gider")
    public void kullanici_gider(String string) {
        Driver.getDriver().get(string);
        ReusableMethods.waitFor(5);
    }
    @When("Kullanici FirstName inputuna {string} girer")
    public void kullanici_first_name_inputuna_girer(String string) {
        form = new FormPages();
        form.firstName.sendKeys(faker.name().firstName());
        ReusableMethods.waitFor(3);
    }
    @When("Kullanici LastName inptuna {string} girer")
    public void kullanici_last_name_inptuna_girer(String string) {
        form = new FormPages();
        form.lastName.sendKeys(faker.name().lastName());
        ReusableMethods.waitFor(3);
    }
    @When("Kullanici Cauntry dropdownundan bir ülke seçer")
    public void kullanici_cauntry_dropdownundan_bir_ülke_seçer() {
        // Dropdown'u aç
        ReusableMethods.clickElementWithJs(form.country);
        ReusableMethods.waitFor(3);
        ReusableMethods.scrollElementWithJs(form.password);

        // Dropdown'daki tüm seçenekleri al
        List<WebElement> options = form.countryList;
        System.out.println("Toplam ülke sayısı: " + options.size());

       // Eğer seçenekler boş değilse, rastgele bir ülke seç
        if (!options.isEmpty()) {
            int randomIndex = new Random().nextInt(options.size());
            WebElement selectedOption = options.get(randomIndex); // Önce seçilecek elementi değişkene ata

            String selectedCountry = selectedOption.getText(); // Tıklamadan önce metni al
            selectedOption.click(); // Seçimi yap

            System.out.println("Seçilen Ülke: " + selectedCountry); // Seçilen ülkeyi ekrana yazdır
        } else {
            System.out.println("Ülke seçenekleri bulunamadı!");
        }
        ReusableMethods.waitFor(2);

        /*
        form = new FormPages();
        ReusableMethods.clickElementWithJs(form.country);
        ReusableMethods.waitFor(3);
        List<WebElement> options = form.countryList;

        System.out.println(options.size());

        // Eğer seçenekler boş değilse, rastgele bir ülke seç
        if (!options.isEmpty()) {
            int randomIndex = new Random().nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Seçilen Ülke: " + options.get(randomIndex).getText());
        } else {
            System.out.println("Ülke seçenekleri bulunamadı!");
        }

        ReusableMethods.waitFor(2);

*/
    }
    @When("Kullanici MobileNumber inbutuna {string} girer")
    public void kullanici_mobile_number_inbutuna_girer(String string) {
        form = new FormPages();
        form.phoneNumber.sendKeys(faker.regexify("[1-9]{2}[1-9]{3}[1-9]{2}"));
        ReusableMethods.waitFor(3);
        System.out.println(string);

    }
    @When("Kullanici Campany inputuna {string} girer")
    public void kullanici_campany_inputuna_girer(String string) {
        form = new FormPages();
        form.companyName.sendKeys(string);
        ReusableMethods.waitFor(3);
    }
    @When("Kullanici Email inputuna {string} girer")
   public void kullanici_email_inputuna_girer(String string) {
        form = new FormPages();
        form.email.sendKeys(string);
        ReusableMethods.waitFor(3);
    }
    @When("Kullanici bir Title seçer")
    public void kullanici_bir_title_seçer() {
        form = new FormPages();
        ReusableMethods.clickElementWithJs(form.title);
        ReusableMethods.waitFor(3);
        List<WebElement> options = form.titleList;
        System.out.println(options.size());

        if (!options.isEmpty()) {
            int randomIndex = new Random().nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Seçilen Title: " + options.get(randomIndex).getText());
        } else {
            System.out.println("Title bulunamadı!");
        }
        ReusableMethods.waitFor(2);
    }
    @When("Kullanici Password {string} girer")
    public void kullanici_password_girer(String string) {
        form = new FormPages();
        ReusableMethods.sendKeysText(form.password,string);
        ReusableMethods.waitFor(3);
    }
    @When("Kullanici ConfirmPassword {string} girer")
    public void kullanici_confirm_password_girer(String string) {
        form = new FormPages();
        form.confirmPassword.sendKeys(string);
        ReusableMethods.waitFor(3);
        ReusableMethods.scrollIntoViewJS(form.checkbox);
        form.checkbox.click();
        ReusableMethods.waitFor(5);

        try {
            if (form.accept.isDisplayed()) {
               form.accept.click();
            } else {
                // Eğer buton görünmezse JavaScript ile tıkla
                ReusableMethods.scrollElementWithJs(form.accept);
            }
        } catch (Exception e) {
            // Eğer hala tıklamazsa önce modal içinde scroll yapıp sonra tıkla
            ReusableMethods.scrollElementWithJs(form.accept);
            ReusableMethods.clickElementWithJs(form.accept);
    }

        ReusableMethods.scrollElementWithJs(form.agreeButton);
        ReusableMethods.waitFor(2);
        ReusableMethods.clickElementWithJs(form.checkboxdogrulama);
        ReusableMethods.waitFor(2);
        ReusableMethods.clickElementWithJs(form.agreeButton);
        ReusableMethods.waitFor(2);




    }
}
