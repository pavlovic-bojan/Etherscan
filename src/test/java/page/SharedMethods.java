package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class SharedMethods extends BaseTest {

    public SharedMethods(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    WebElement errorCaptchaClick;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtUserName']")
    WebElement userNameInputField;
    @FindBy(xpath = "//div[contains(text(), 'Please enter Username.')]")
    WebElement errorUserName;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtPassword']")
    WebElement passwordInputField;
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtEmail']")
    WebElement emailInputField;
    @FindBy(xpath = "//div[contains(text(), 'Please enter a valid email address.')]")
    WebElement errorEmail;
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

    public void captchaRegister(){
        wdWait.until(ExpectedConditions.visibilityOf(errorCaptchaClick)).click();
    }

    public void userInputField(String username){
        wdWait.until(ExpectedConditions.visibilityOf(userNameInputField)).clear();
        userNameInputField.sendKeys(username);
    }

    public boolean errorUserNameMethod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorUserName)).isDisplayed();
    }

    public String errorUserNameMethodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorUserName)).getText();
    }

    public void passwordInputField(String password){
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField)).clear();
        passwordInputField.sendKeys(password);
    }

    public void emailInputField(String email){
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField)).clear();
        emailInputField.sendKeys(email);
    }

    public boolean errorEmailMetod(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorEmail)).isDisplayed();
    }

    public String errorEmailMetodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(errorEmail)).getText();
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

    public void switchToNewTab(int tabNumbers , int tab){
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(tabNumbers));
        ArrayList <String> numbersOfTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(numbersOfTabs.get(tab));
    }
}
