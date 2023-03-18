package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BaseTest {

    public RegisterPage(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtConfirmEmail']")
    WebElement confirmEmailInputField;

    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtPassword2']")
    WebElement confirmPasswordInputField;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$MyCheckBox']")
    WebElement myCheckBox;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$SubscribeNewsletter']")
    WebElement newsLetterCheckBox;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$btnRegister']")
    WebElement registerButton;
    @FindBy(xpath = "//h1[contains(text(), 'Verify Your Email')]")
    WebElement verifyYourEmail;
    @FindBy(xpath = "//div[contains(text(), 'Sorry! The username you entered is already in use.')]")
    WebElement errorUserNameUse;
    @FindBy(xpath = "//div[contains(text(), 'Please enter at least 5 characters.')]")
    WebElement errorUserNameShort;
    @FindBy(xpath = "//div[contains(text(), 'Only alphanumeric characters allowed.')]")
    WebElement errorUserNameAlphanumeric;
    @FindBy(xpath = "//div[contains(text(), 'Please re-enter your email address.')]")
    WebElement errorEmailReEnter;

    public void email2InputField(String email){
        wdWait.until(ExpectedConditions.visibilityOf(confirmEmailInputField)).clear();
        confirmEmailInputField.sendKeys(email);
    }

    public void password2InputField(String password){
        wdWait.until(ExpectedConditions.visibilityOf(confirmPasswordInputField)).clear();
        confirmPasswordInputField.sendKeys(password);
    }

    public void checkBoxMy(){
        wdWait.until(ExpectedConditions.visibilityOf(myCheckBox));
        if(!myCheckBox.isSelected())
            myCheckBox.click();
    }

    public void checkBoxNewsLetter(){
        wdWait.until(ExpectedConditions.visibilityOf(newsLetterCheckBox));
        if(!newsLetterCheckBox.isSelected())
            newsLetterCheckBox.click();
    }

    public void buttonRegister(){
        wdWait.until(ExpectedConditions.visibilityOf(registerButton)).click();
    }

    public boolean verifyYourEmailMethod(){
        return wdWait.until(ExpectedConditions.visibilityOf(verifyYourEmail)).isDisplayed();
    }

    public String verifyYourEmailMethodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(verifyYourEmail)).getText();
    }

    public boolean errorUserNameUseMethod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorUserNameUse)).isDisplayed();
    }

    public String errorUserNameUseMethodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorUserNameUse)).getText();
    }

    public boolean errorUserNameShortMethod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorUserNameShort)).isDisplayed();
    }

    public String errorUserNameShortMethodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorUserNameShort)).getText();
    }

    public boolean errorUserNameAlphanumericMethod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorUserNameAlphanumeric)).isDisplayed();
    }

    public String errorUserNameAlphanumericMethodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorUserNameAlphanumeric)).getText();
    }



    public boolean errorEmailReEnterMetod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorEmailReEnter)).isDisplayed();
    }

    public String errorEmailReEnterMetodText() {
        return wdWait.until(ExpectedConditions.visibilityOf(errorEmailReEnter)).getText();
    }

}
