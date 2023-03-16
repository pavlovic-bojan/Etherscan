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

    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtUserName']")
    WebElement userNameInputField;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtEmail']")
    WebElement emailInputField;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtConfirmEmail']")
    WebElement confirmEmailInputField;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtPassword']")
    WebElement passwordInputField;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtPassword2']")
    WebElement confirmPasswordInputField;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$MyCheckBox']")
    WebElement myCheckBox;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$SubscribeNewsletter']")
    WebElement newsLetterCheckBox;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$btnRegister']")
    WebElement registerButton;
    @FindBy(xpath = "//h4[contains(text(), 'Verify Your Email')]")
    WebElement verifyYourEmail;
    @FindBy(xpath = "//div[contains(text(), 'Please enter Username.')]")
    WebElement errorUserName;
    @FindBy(xpath = "//div[contains(text(), 'Sorry! The username you entered is already in use.')]")
    WebElement errorUserNameUse;
    @FindBy(xpath = "//div[contains(text(), 'Please enter at least 5 characters.')]")
    WebElement errorUserNameShort;
    @FindBy(xpath = "//div[contains(text(), 'Only alphanumeric characters allowed.')]")
    WebElement errorUserNameAlphanumeric;
    @FindBy(xpath = "//div[contains(text(), 'Please enter a valid email address.')]")
    WebElement errorEmail;
    @FindBy(xpath = "//div[contains(text(), 'Please re-enter your email address.')]")
    WebElement errorEmailReEnter;
    @FindBy(xpath = "//div[contains(text(), 'Please enter Password.')]")
    WebElement errorPassword;
    @FindBy(xpath = "//div[contains(text(), 'Your password must be at least 8 characters long.')]")
    WebElement errorPasswordShort;
    @FindBy(xpath = "//div[contains(text(), 'Password does not match, please check again.')]")
    WebElement errorPasswordMatch;
    @FindBy(xpath = "//div[contains(text(), 'Please accept our Terms and Conditions.')]")
    WebElement errorTermsAndConditions;
    @FindBy(xpath = "//div[contains(text(), 'Error! Invalid captcha response. ')]")
    WebElement errorCaptcha;
    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    WebElement errorCaptchaClick;



    public void userInputField(String username){
        wdWait.until(ExpectedConditions.visibilityOf(userNameInputField)).clear();
        userNameInputField.sendKeys(username);
    }
    public void emailInputField(String email){
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField)).clear();
        emailInputField.sendKeys(email);
    }

    public void email2InputField(String email){
        wdWait.until(ExpectedConditions.visibilityOf(confirmEmailInputField)).clear();
        confirmEmailInputField.sendKeys(email);
    }

    public void passwordInputField(String password){
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField)).clear();
        passwordInputField.sendKeys(password);
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

    public void captchaRegister(){
        wdWait.until(ExpectedConditions.visibilityOf(errorCaptchaClick)).click();
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

    public boolean errorUserNameMethod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorUserName)).isDisplayed();
    }

    public String errorUserNameMethodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorUserName)).getText();
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

    public boolean errorEmailMetod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorEmail)).isDisplayed();
    }

    public String errorEmailMetodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorEmail)).getText();
    }

    public boolean errorEmailReEnterMetod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorEmailReEnter)).isDisplayed();
    }

    public String errorEmailReEnterMetodText() {
        return wdWait.until(ExpectedConditions.visibilityOf(errorEmailReEnter)).getText();
    }

    public boolean errorPasswordMetod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorPassword)).isDisplayed();
    }

    public String errorPasswordMetodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorPassword)).getText();
    }

    public boolean errorPasswordShortMetod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorPasswordShort)).isDisplayed();
    }

    public String errorPasswordShortMetodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorPasswordShort)).getText();
    }

    public boolean errorPasswordMatchMetod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorPasswordMatch)).isDisplayed();
    }

    public String errorPasswordMatchMetodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorPasswordMatch)).getText();
    }

    public boolean errorTermsAndConditionsMetod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorTermsAndConditions)).isDisplayed();
    }

    public String errorTermsAndConditionsMetodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorTermsAndConditions)).getText();
    }


    public boolean errorCaptchaMetod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorCaptcha)).isDisplayed();
    }

    public String errorCaptchaMetodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorCaptcha)).getText();
    }

}
