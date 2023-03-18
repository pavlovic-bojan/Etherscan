package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BaseTest {
    public SignInPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$btnLogin']")
    WebElement loginButton;

    public void buttonLoginClick(){
        wdWait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }
}
