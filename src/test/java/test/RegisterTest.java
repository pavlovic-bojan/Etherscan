package test;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage;
    Random random = new Random();
    String username = "someCreativeQAUserName" + random.nextInt(999999);
    String email = username + "@mailinator.com";
    String password = "12345678";
    String verifyYourEmailMessages = "Verify Your Email";
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
        registerPage = new RegisterPage();
    }

    //Positive Test

    //For next 2 test you must solve captcha manually and every test is on hold for 10 seconds for you to resolve captcha

    @Test
    public void successfulRegistrationTest() throws Exception{
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.captchaRegister();
        Thread.sleep(10000);
        registerPage.buttonRegister();
        assertTrue(registerPage.errorUserNameUseMethod());
        assertEquals(userNameUseErrorMessages,registerPage.errorUserNameUseMethodText());
    }

    @Test
    public void attemptToRegisterWhenTheUserNameInUse() throws Exception{
        registerPage.userInputField("dispatch");
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.captchaRegister();
        Thread.sleep(10000);
        registerPage.buttonRegister();
        assertTrue(registerPage.errorUserNameUseMethod());
        assertEquals(userNameUseErrorMessages,registerPage.errorUserNameUseMethodText());
    }

    //Negative Test

    @Test
    public void attemptToRegisterAllFormeFieldIsEmpty(){
        registerPage.buttonRegister();
        assertTrue(registerPage.errorUserNameMethod());
        assertEquals(userNameErrorMessages,registerPage.errorUserNameMethodText());
        assertTrue(registerPage.errorEmailMetod());
        assertEquals(emailErrorMessages,registerPage.errorEmailMetodText());
        assertTrue(registerPage.errorEmailReEnterMetod());
        assertEquals(emailReEnterErrorMessages,registerPage.errorEmailReEnterMetodText());
        assertTrue(registerPage.errorPasswordMetod());
        assertEquals(passwordErrorMessages,registerPage.errorPasswordMetodText());
        assertTrue(registerPage.errorPasswordShortMetod());
        assertEquals(passwordShortErrorMessages,registerPage.errorPasswordShortMetodText());
        assertTrue(registerPage.errorTermsAndConditionsMetod());
        assertEquals(termsErrorMessages,registerPage.errorTermsAndConditionsMetodText());
    }

    @Test
    public void attemptToRegisterWhenTheUserNameFieldIsEmpty(){
        registerPage.userInputField("");
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorUserNameMethod());
        assertEquals(userNameErrorMessages,registerPage.errorUserNameMethodText());
    }

    @Test
    public void attemptToRegisterWhenTheUserNameShort(){

        registerPage.userInputField("men");
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorUserNameShortMethod());
        assertEquals(userNameShortErrorMessages,registerPage.errorUserNameShortMethodText());
    }

    @Test
    public void attemptToRegisterWhenTheUserNameNotAlphanumeric(){
        registerPage.userInputField("This is a long username of ->31");
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorUserNameAlphanumericMethod());
        assertEquals(userNameAlphanumericErrorMessages,registerPage.errorUserNameAlphanumericMethodText());
    }

    @Test
    public void attemptToRegisterWhenTheEmailFieldIsEmpty(){
        registerPage.userInputField(username);
        registerPage.emailInputField("");
        registerPage.email2InputField(email);
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorEmailMetod());
        assertEquals(emailErrorMessages,registerPage.errorEmailMetodText());
    }

    @Test
    public void attemptToRegisterWhenTheEmailIsShort(){
        registerPage.userInputField(username);
        registerPage.emailInputField("2@g.");
        registerPage.email2InputField("2@g.");
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorEmailMetod());
        assertEquals(emailErrorMessages,registerPage.errorEmailMetodText());
    }

    @Test
    public void attemptToRegisterWhenTheEmailIsInvalid(){
        registerPage.userInputField(username);
        registerPage.emailInputField("23g.");
        registerPage.email2InputField("23g.");
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorEmailMetod());
        assertEquals(emailErrorMessages,registerPage.errorEmailMetodText());
    }
    @Test
    public void attemptToRegisterWhenTheEmailNotMatching(){
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField("2@g.");
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorEmailReEnterMetod());
        assertEquals(emailReEnterErrorMessages,registerPage.errorEmailReEnterMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordShort(){
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField("1234567");
        registerPage.password2InputField("1234567");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorPasswordShortMetod());
        assertEquals(passwordShortErrorMessages,registerPage.errorPasswordShortMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordNotMatching(){
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField("1234567a");
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorPasswordMatchMetod());
        assertEquals(passwordMatchErrorMessages,registerPage.errorPasswordMatchMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordOnlyNumbers(){
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorCaptchaMetod());
        assertEquals(captchaErrorMessages,registerPage.errorCaptchaMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordOnlyLowercaseLetters(){
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField("qwertyui");
        registerPage.password2InputField("qwertyui");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorCaptchaMetod());
        assertEquals(captchaErrorMessages,registerPage.errorCaptchaMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordOnlyCapitalLetters(){
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField("QWERTYUI");
        registerPage.password2InputField("QWERTYUI");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorCaptchaMetod());
        assertEquals(captchaErrorMessages,registerPage.errorCaptchaMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordOnlySpecialCharacters(){
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField("!@#$%^&*");
        registerPage.password2InputField("!@#$%^&*");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorCaptchaMetod());
        assertEquals(captchaErrorMessages,registerPage.errorCaptchaMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordLettersNumbersSpecialCharacters(){
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField("Pas123%^&*");
        registerPage.password2InputField("Pas123%^&*");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorCaptchaMetod());
        assertEquals(captchaErrorMessages,registerPage.errorCaptchaMetodText());
    }

    @Test
    public void attemptToRegisterWhenThePasswordFieldIsEmpty(){
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField("");
        registerPage.password2InputField("");
        registerPage.checkBoxMy();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorPasswordMetod());
        assertEquals(passwordErrorMessages,registerPage.errorPasswordMetodText());
    }

    @Test
    public void attemptToRegisterWhenTheTermsIsNotChecked(){
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.buttonRegister();
        assertTrue(registerPage.errorTermsAndConditionsMetod());
        assertEquals(termsErrorMessages,registerPage.errorTermsAndConditionsMetodText());
    }

    @Test
    public void attemptToRegisterWhenTheNewsLerrerIsChecked(){
        registerPage.userInputField(username);
        registerPage.emailInputField(email);
        registerPage.email2InputField(email);
        registerPage.passwordInputField(password);
        registerPage.password2InputField(password);
        registerPage.checkBoxMy();
        registerPage.checkBoxNewsLetter();
        registerPage.buttonRegister();
        assertTrue(registerPage.errorCaptchaMetod());
        assertEquals(captchaErrorMessages,registerPage.errorCaptchaMetodText());
    }

}
