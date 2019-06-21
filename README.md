## LogicGate Coding Challenge

#### The tests:  
There are 3 tests located in **/src/test/java/EnterFormData**.
- **enterOnlyRequiredFieldsTest()** - Happy path test for entering only the required form fields
- **enterAllFieldsTest()** - Happy path test for entering all of the form fields
- **validationMessagesTest()** - Negative test for all validation messages

#### Running the tests:
Before running the tests, edit the **EnterFormData** file and 
set the **testingDomain** variable to the location where the 
web files are located. Ideally this would be an argument during
execution, but for some reason I couldn't get gradle to pick it
up on the command line.

You can import the project into IntelliJ and run the tests from
the IDE or you can run the tests from the command line with the command:  
 
**gradle clean test**

#### Notes
- The **WebDriverBase** file was lifted from some old projects of mine and needs to be updated for
newer versions of selenium. For this project, I've only modified it enough 
for chrome on mac and included the latest chromedriver in **/lib**
