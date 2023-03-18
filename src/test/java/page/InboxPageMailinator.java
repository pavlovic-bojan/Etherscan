package page;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxPageMailinator extends BaseTest {

    public InboxPageMailinator(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@class=\"ng-binding\"][contains(text(),\"Please confirm your email [Etherscan.io]\")]")
    WebElement verifyEmail;

    public void verifyEmailClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(verifyEmail)).click();
    }
}
