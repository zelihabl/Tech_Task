package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class FormPages {
    public FormPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "lastName")
    public WebElement lastName;
   @FindBy(xpath = "//nz-select[contains(@class, 'ant-select')]")
   public WebElement country;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content']")
    public List<WebElement> countryList;
    @FindBy(id = "phoneNumber")
    public WebElement phoneNumber;
    @FindBy(id = "companyName")
    public WebElement companyName;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    public WebElement email;
    @FindBy(xpath = "//nz-select[@formcontrolname='jobTitle']")
    public WebElement title;
    @FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']")
    public List<WebElement> titleList;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    public WebElement password;
    @FindBy(xpath = "//input[@formcontrolname='passwordConfirm']")
    public WebElement confirmPassword;
    @FindBy(xpath = "//span[@class='checkbox-box']")
    public WebElement checkbox;
    @FindBy(xpath = "//div[contains(@class, 'ant-modal-body')]")
    public WebElement popUp;

    @FindBy(xpath = "//div[contains(@class, 'ant-modal-footer')]//button[contains(@class, 'ant-btn-primary')]")
    public WebElement accept;
    @FindBy(xpath = "//span[contains(text(),'Agree & Sign-Up')]")
    public WebElement agreeButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkboxdogrulama;




}
