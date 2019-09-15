AutomationAmazonEdkal
Chrome Browser version should match to the chrome version from your system, I have used Chrome version 76 "76.0.3809.126"
Created Edkal maven project
Created properties file to read common value from properties file.
Created a package name as 'com.amazon.pageObject' under src/main folder and created POM classes for each and every web page.
Added all locatores elements associate with different POM classes.
Created two different packages under src/test folder as com.amazon.test and com.uitilitiesFiles.
Created BaseTest class where two craeted two methods, @BeforeMethod defined prerequisites which will execute before any test method runs and @AfterMethod is having postcondition defind to capture the screenshot if any scenario failed,calling the method from ScrrenRecorderUtil class to stop the recorder and close the browser.
Created Test class which takes the data from utility class and peroforming the action by calling the methods present in POM class
Created Git repository.
Analyzed the test reporter.
