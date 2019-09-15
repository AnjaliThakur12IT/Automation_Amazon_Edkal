#AutomationAmazonEdkal
##Created Edkal maven project.
Add all dependency in pom.xml file.
Created properties file to read common value from properties file.
Calling 
Created a package name as 'com.amazon.pageObject' under src/main folder and created POM class for each and every web page.
Add all locatores elements associate with different POM classes.
Created two different packages under src/test folder as com.amazon.test and com.uitilitiesFiles.
Created BaseTest class where two method defined, @BeforeMethod defined prerequisites which will execute before any test method runs and @AfterMethod is having postcondirion defind to capture the screenshot if any scenario failed and close the browser.
Created Test class where call all methods inside the test class with creating an object.
