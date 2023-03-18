package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessfulConfirmEmailPage extends BaseTest {
    public SuccessfulConfirmEmailPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[contains(text(), 'Welcome to Etherscan!')]")
    WebElement successfulConfirmEmail;

    @FindBy(linkText = "Sign In")
    WebElement signInClick;

    public boolean confirmYourEmailMethod(){
        return wdWait.until(ExpectedConditions.visibilityOf(successfulConfirmEmail)).isDisplayed();
    }

    public String confirmYourEmailMethodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(successfulConfirmEmail)).getText();
    }

    public void signInClickMethod(){
        wdWait.until(ExpectedConditions.visibilityOf(signInClick)).click();
    }

}
