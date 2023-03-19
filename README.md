# Etherscan
This repository is a recruitment process for the position of QA Engineer but due to obligations at my current job about new release of app, I didn't manage to send the assignment in the scheduled time so I decided to publish it here in this repository. 

This project was made as my answer to assignment which I get from company where I am applying for the job ad and the position of QA Engineer. 

I spent 4 days on the realization of this project

Side information: To use the application in a special environment the author accepts no responsibility if you cause damage to third parties

## Table of Contents
1. [Testing the Etherscan Registration form](#testing-the-etherscan-registration-form)
2. [Potential Bugs](#potential-bugs)
3. [Collaboration](#collaboration)
### Testing the Etherscan Registration form
***
__a) Create TEST SCENARIOS for the registration form on Etherscan website (https://etherscan.io/register)__<br>
* Successful Registration Test
* Attempt To Register When The News Letter Is Checked
* Attempt To Register When The User Name In Use
* Attempt To Register All Form Field Is Empty 
* Attempt To Register When The User Name Field Is Empty
* Attempt To Register When The User Name Short
* Attempt To Register When The User Name Not Alphanumeric
* Attempt To Register When The Email Field Is Empty
* Attempt To Register When The Email Is Short
* Attempt To Register When The Email Is Invalid
* Attempt To Register When The Email Not Matching
* Attempt To Register When The Password Short
* Attempt To Register When The Password Not Matching
* Attempt To Register When The Password Only Numbers
* Attempt To Register When The Password Only Lowercase Letters
* Attempt To Register When The Password Only Capital Letters
* Attempt To Register When The Password Only Special Characters
* Attempt To Register When The Password Letters Numbers Special Characters
* Attempt To Register When The Password Field Is Empty
* Attempt To Register When The Terms Is Not Checked

__b) Explain what type of tools you would use to enable an automatic testing system for the task above and how they would be utilized.__<br>
  
  A list of technologies used within the project:
* [Ubuntu (OS)](https://ubuntu.com/): Version 22.04.2 LTS 
* [Intellij idea](https://www.jetbrains.com/idea/): Version 2022.3.3 (Community Edition) Build #IC-223.8836.41, built on March 10, 2023
* [Java](https://www.java.com/en/): Version openjdk version "18.0.2-ea" 2022-07-19 OpenJDK Runtime Environment (build 18.0.2-ea+9-Ubuntu-222.04) OpenJDK 64-Bit Server VM (build 18.0.2-ea+9-Ubuntu-222.04, mixed mode, sharing)
* [Selenium](https://www.selenium.dev/): Version 4.8.1 
* [JUnit](https://junit.org/junit5/): Version 5.9.1
* [Webdriver Manager](https://bonigarcia.dev/webdrivermanager/): Version 5.3.0

For __first two test you must solve captcha manually and every test is on hold for 10 seconds for you to resolve captcha__. I know it's not the best solution, but it's the only one that came to my mind quickly, and it's in agreement with the [documentation of Selenium](https://www.selenium.dev/documentation/test_practices/discouraged/captchas/) itself. For test environment __captcha__ is mostly turned off

 __c) Create E2E browser tests that will cover all test scenarios__<br>
 
 Feel free to copy the project from this repository into your IDE and download the driver for the browser you are using, copy it to the root of the project and run the test, and make sure all the scenarios listed above are automated.

## Potential Bugs
***
As I haven't read the documentation for the app I performed tested, and I consider the following things to be potential bugs in the registration process itself:
* The possibility of registering several users with the same email address.
   
   __Steps to reproduce__
   * fill all fields for registration form
   * enter the email of the user who is already registered in the email field
   * click on registration
   
   __Actual Result__
   
   Can registering several users with the same email address
   
   __Expected result__
   
   Email and username must be unique
     
* The possibility of creating a password of only 8 numbers or lowercase letters or characters

   __Steps to reproduce__
   * fill all fields for registration form
   * fill password fields with only (lowercase or uppercase or special character)
   * click on registration
   
   __Actual Result__
   
   Can registering users with only (lowercase or uppercase or special character)
   
   __Expected result__
   
   Force the user to create a password from a combination of UPPERCASE lowercase letters and at least one special character
  
* When one of the fields for the password is clicked on the button shows the password of both fields is visible

   __Steps to reproduce__
   * fill all fields for registration form
   * click on show password button in field password
   
   __Actual Result__
   
   One of the fields for the password is clicked on the button shows the password of both fields is visible
   
   __Expected result__
   
   Just need to show the password in that field when is click on show password button

__I say once again that I haven't read the documentation, but in my opinion this is a serious bug.__

## Collaboration
***
This project is closed and I do not accept any collaboration
> Please do not change the code. 
> This project is not an ongoing project.
> I am available for any questions.
