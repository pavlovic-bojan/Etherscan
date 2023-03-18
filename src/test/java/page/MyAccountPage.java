package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BaseTest {
    public MyAccountPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[contains(text(), 'someCreativeQAUserName')]")
    WebElement userNameL;

    public boolean userNameMethod(){
        return wdWait.until(ExpectedConditions.visibilityOf(userNameL)).isDisplayed();
    }

    public String userNameMethodText(){
        return wdWait.until(ExpectedConditions.visibilityOf(userNameL)).getText();
    }

}
