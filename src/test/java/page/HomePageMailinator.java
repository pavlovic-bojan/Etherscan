package page;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageMailinator extends BaseTest {

    public HomePageMailinator(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search")
    WebElement emailInputField;

    public void emailInputFieldSendKeys(String email){
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField)).clear();
        emailInputField.sendKeys(email);
    }

    public void emailInputFieldSendKeyboardKeys(Keys keyboardButton){
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField)).sendKeys(keyboardButton);
    }
}