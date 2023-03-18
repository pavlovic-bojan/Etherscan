package page;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class EmaiPagelMailinator extends BaseTest {

    public EmaiPagelMailinator(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'https://etherscan.io/confirmemail')]")
    WebElement confirmationLink;
    @FindBy(id = "html_msg_body")
    WebElement iframeHtmlMsgBoby;

    public void activateAccountClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(confirmationLink)).click();
    }

    public void iframeHtmlMsgBodySwitchWithWait(){
        wdWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeHtmlMsgBoby));
        actions.scrollByAmount(0,100).perform();
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }
}
