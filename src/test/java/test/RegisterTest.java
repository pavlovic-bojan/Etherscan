package test;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import page.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest extends BaseTest {

    EmaiPagelMailinator emaiPagelMailinator;
    HomePageMailinator homePageMailinator;
    InboxPageMailinator inboxPageMailinator;
    MyAccountPage myAccountPage;
    RegisterPage registerPage;
    SharedMethods sharedMethods;
    SignInPage signInPage;
    SuccessfulConfirmEmailPage successfulConfirmEmailPage;

    Random random = new Random();
    String username = "someCreativeQAUserName" + random.nextInt(999999);
    String email = username + "@mailinator.com";
    String password = "12345678";
    String verifyYourEmailMessages = "Verify Your Email";
    String successfulConfirmEmail = "Welcome to Etherscan!";
    String userNameErrorMessages = "Please enter Username.";
    String userNameUseErrorMessages = "Sorry! The username you entered is already in use.";
    String userNameShortErrorMessages = "Please enter at least 5 characters.";
    String userNameAlphanumericErrorMessages = "Only alphanumeric characters allowed.";
    String emailErrorMessages = "Please enter a valid email address.";
    String emailReEnterErrorMessages = "Please re-enter your email address.";
    String passwordErrorMessages = "Please enter Password.";
    String passwordShortErrorMessages = "Your password must be at least 8 characters long.";
    String passwordMatchErrorMessages = "Password does not match, please check again.";
    String termsErrorMessages = "Please accept our Terms and Conditions.";
    String captchaErrorMessages = "Error! Invalid captcha response.\n" +
            "Please Try Again";
    String mailinatorLink = "https://www.mailinator.com";
    String successfulRegistrationMessage = "Welcome to Etherscan!\n" +
            "Congratulations! Your account is successfully verified. You may proceed to log in with your user ID and password. Please Sign In to your account and enjoy your Etherscan Services!";



    @BeforeEach
    public void setUpPages(){
        emaiPagelMailinator = new EmaiPagelMailinator();
        homePageMailinator = new HomePageMailinator();
        inboxPageMailinator = new InboxPageMailinator();
        myAccountPage = new MyAccountPage();
        registerPage = new RegisterPage();
        sharedMethods = new SharedMethods();
        signInPage = new SignInPage();
        successfulConfirmEmailPage = new SuccessfulConfirmEmailPage();
    }

    //Positive Test

    //For next 2 test you must solve captcha manually and every test is on hold for 10 seconds for you to resolve captcha

    @Test
    public void successfulRegistrationTest() throws Exception{
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        sharedMethods.captchaRegister();
        Thread.sleep(10000);
        registerPage.buttonRegister();
        assertTrue(registerPage.verifyYourEmailMethod());
        assertEquals(verifyYourEmailMessages,registerPage.verifyYourEmailMethodText());
        driver.get(mailinatorLink);
        homePageMailinator.emailInputFieldSendKeys(email);
        homePageMailinator.emailInputFieldSendKeyboardKeys(Keys.ENTER);
        inboxPageMailinator.verifyEmailClick();
        emaiPagelMailinator.iframeHtmlMsgBodySwitchWithWait();
        emaiPagelMailinator.activateAccountClick();
        sharedMethods.switchToNewTab(2,1);
        assertTrue(successfulConfirmEmailPage.confirmYourEmailMethod());
        assertEquals(successfulConfirmEmail,successfulConfirmEmailPage.confirmYourEmailMethodText());
        successfulConfirmEmailPage.signInClickMethod();
        sharedMethods.userInputField(username);
        sharedMethods.passwordInputField(password);
        sharedMethods.captchaRegister();
        Thread.sleep(10000);
        signInPage.buttonLoginClick();
        assertTrue(myAccountPage.userNameMethod());
        assertEquals(username,myAccountPage.userNameMethodText());
    }

    @Test
    public void attemptToRegisterWhenTheNewsLetterIsChecked() throws Exception{
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.checkBoxNewsLetter();
        sharedMethods.captchaRegister();
        Thread.sleep(10000);
        registerPage.buttonRegister();
        assertTrue(registerPage.verifyYourEmailMethod());
        assertEquals(verifyYourEmailMessages,registerPage.verifyYourEmailMethodText());
        driver.get(mailinatorLink);
        homePageMailinator.emailInputFieldSendKeys(email);
        homePageMailinator.emailInputFieldSendKeyboardKeys(Keys.ENTER);
        inboxPageMailinator.verifyEmailClick();
        emaiPagelMailinator.iframeHtmlMsgBodySwitchWithWait();
        emaiPagelMailinator.activateAccountClick();
        sharedMethods.switchToNewTab(2,1);
        assertTrue(successfulConfirmEmailPage.confirmYourEmailMethod());
        assertEquals(successfulConfirmEmail,successfulConfirmEmailPage.confirmYourEmailMethodText());
        successfulConfirmEmailPage.signInClickMethod();
        sharedMethods.userInputField(username);
        sharedMethods.passwordInputField(password);
        sharedMethods.captchaRegister();
        Thread.sleep(10000);
        signInPage.buttonLoginClick();
        assertTrue(myAccountPage.userNameMethod());
        assertEquals(username,myAccountPage.userNameMethodText());
    }

    //Negative Test

    @Test
    public void attemptToRegisterWhenTheUserNameInUse() throws Exception{
        sharedMethods.userInputField("dispatch");
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        sharedMethods.captchaRegister();
        Thread.sleep(10000);
        registerPage.buttonRegister();
        assertTrue(registerPage.errorUserNameUseMethod());
        assertEquals(userNameUseErrorMessages,registerPage.errorUserNameUseMethodText());
    }

    @Test
    public void attemptToRegisterAllFormFieldIsEmpty(){
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorUserNameMethod());
        assertEquals(userNameErrorMessages,sharedMethods.errorUserNameMethodText());
        assertTrue(sharedMethods.errorEmailMetod());
        assertEquals(emailErrorMessages,sharedMethods.errorEmailMetodText());
        assertTrue(registerPage.errorEmailReEnterMetod());
        assertEquals(emailReEnterErrorMessages,registerPage.errorEmailReEnterMetodText());
        assertTrue(sharedMethods.errorPasswordMetod());
        assertEquals(passwordErrorMessages,sharedMethods.errorPasswordMetodText());
        assertTrue(sharedMethods.errorPasswordShortMetod());
        assertEquals(passwordShortErrorMessages,sharedMethods.errorPasswordShortMetodText());
        assertTrue(sharedMethods.errorTermsAndConditionsMetod());
        assertEquals(termsErrorMessages,sharedMethods.errorTermsAndConditionsMetodText());
    }

    @Test
    public void attemptToRegisterWhenTheUserNameFieldIsEmpty(){
        sharedMethods.userInputField("");
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorUserNameMethod());
        assertEquals(userNameErrorMessages,sharedMethods.errorUserNameMethodText());
    }

    @Test
    public void attemptToRegisterWhenTheUserNameShort(){
        sharedMethods.userInputField("men");
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorUserNameShortMethod());
        assertEquals(userNameShortErrorMessages,registerPage.errorUserNameShortMethodText());
    }

    @Test
    public void attemptToRegisterWhenTheUserNameNotAlphanumeric(){
        sharedMethods.userInputField("This is a long username of ->31");
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorUserNameAlphanumericMethod());
        assertEquals(userNameAlphanumericErrorMessages,registerPage.errorUserNameAlphanumericMethodText());
    }

    @Test
    public void attemptToRegisterWhenTheEmailFieldIsEmpty(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField("");
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorEmailMetod());
        assertEquals(emailErrorMessages,sharedMethods.errorEmailMetodText());
    }

    @Test
    public void attemptToRegisterWhenTheEmailIsShort(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField("2@g.");
        registerPage.email2InputField("2@g.");
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorEmailMetod());
        assertEquals(emailErrorMessages,sharedMethods.errorEmailMetodText());
    }

    @Test
    public void attemptToRegisterWhenTheEmailIsInvalid(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField("23g.");
        registerPage.email2InputField("23g.");
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorEmailMetod());
        assertEquals(emailErrorMessages,sharedMethods.errorEmailMetodText());
    }
    @Test
    public void attemptToRegisterWhenTheEmailNotMatching(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField("2@g.");
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorEmailReEnterMetod());
        assertEquals(emailReEnterErrorMessages,registerPage.errorEmailReEnterMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordShort(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField("1234567");
        registerPage.password2InputField("1234567");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorPasswordShortMetod());
        assertEquals(passwordShortErrorMessages,sharedMethods.errorPasswordShortMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordNotMatching(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField("1234567a");
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorPasswordMatchMetod());
        assertEquals(passwordMatchErrorMessages,sharedMethods.errorPasswordMatchMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordOnlyNumbers(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorCaptchaMetod());
        assertEquals(captchaErrorMessages,sharedMethods.errorCaptchaMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordOnlyLowercaseLetters(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField("qwertyui");
        registerPage.password2InputField("qwertyui");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorCaptchaMetod());
        assertEquals(captchaErrorMessages,sharedMethods.errorCaptchaMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordOnlyCapitalLetters(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField("QWERTYUI");
        registerPage.password2InputField("QWERTYUI");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorCaptchaMetod());
        assertEquals(captchaErrorMessages,sharedMethods.errorCaptchaMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordOnlySpecialCharacters(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField("!@#$%^&*");
        registerPage.password2InputField("!@#$%^&*");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorCaptchaMetod());
        assertEquals(captchaErrorMessages,sharedMethods.errorCaptchaMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordLettersNumbersSpecialCharacters(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField("Pas123%^&*");
        registerPage.password2InputField("Pas123%^&*");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorCaptchaMetod());
        assertEquals(captchaErrorMessages,sharedMethods.errorCaptchaMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordFieldIsEmpty(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField("");
        registerPage.password2InputField("");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorPasswordMetod());
        assertEquals(passwordErrorMessages,sharedMethods.errorPasswordMetodText());
    }

    @Test
    public void attemptToRegisterWhenTheTermsIsNotChecked(){
        sharedMethods.userInputField(username);
        sharedMethods.emailInputField(email);
        registerPage.email2InputField(email);
        sharedMethods.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.buttonRegister();
        assertTrue(sharedMethods.errorTermsAndConditionsMetod());
        assertEquals(termsErrorMessages,sharedMethods.errorTermsAndConditionsMetodText());
    }

}
