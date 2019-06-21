import models.AdoptionFormData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.AdoptionForm;
import pages.ConfirmationPage;
import utils.WebDriverBase;

import java.util.List;

public class EnterFormData {

    private WebDriver driver = new WebDriverBase().createDriver();
    public String testingDomain = "file:///Users/darrel/dev/adopt-a-goat/index.html";

    @Test
    public void enterOnlyRequiredFieldsTest() {
        // Happy Path - Enter only the required fields and verify the confirmation page
        AdoptionFormData formData = AdoptionFormData.getDefaultRequiredFormData();
        driver.get(testingDomain);

        AdoptionForm adoptionForm = new AdoptionForm();
        Assert.assertTrue("Verify index page is displayed", adoptionForm.pageExists());
        adoptionForm.enterFormData(formData);

        ConfirmationPage confirmationPage = new ConfirmationPage();
        Assert.assertTrue("Verify confirmation page is displayed", confirmationPage.pageExists());
        Assert.assertEquals("Verify confirmation message is 'accepted'", "Adoption Request Accepted!", confirmationPage.getConfirmationMessage());

        driver.quit();
    }

    @Test
    public void enterAllFieldsTest() {
        // Happy Path - Enter all of the form fields and verify the confirmation page
        AdoptionFormData formData = AdoptionFormData.getDefaultFormData();
        driver.get(testingDomain);

        AdoptionForm adoptionForm = new AdoptionForm();
        Assert.assertTrue("Verify index page is displayed", adoptionForm.pageExists());
        adoptionForm.enterFormData(formData);

        ConfirmationPage confirmationPage = new ConfirmationPage();
        Assert.assertTrue("Verify confirmation page is displayed", confirmationPage.pageExists());
        Assert.assertEquals("Verify confirmation message is 'accepted'", "Adoption Request Accepted!", confirmationPage.getConfirmationMessage());

        driver.quit();
    }

    @Test
    public void validationMessagesTest() {
        // Negative Test - validate all fields for data validation messages
        driver.get(testingDomain);
        AdoptionFormData formData = new AdoptionFormData();
        formData.setEmail("xxx");
        AdoptionForm adoptionForm = new AdoptionForm();
        Assert.assertTrue("Verify index page is displayed", adoptionForm.pageExists());
        adoptionForm.enterFormData(formData);

        Assert.assertTrue("Verify index page is still displayed", adoptionForm.pageExists());
        List<String> expectedFeedbackMessages = adoptionForm.getExpectedFeedbackMessages(formData);
        List<String> actualFeedbackMessages = adoptionForm.getFeedbackMessages();
        Assert.assertEquals("Verify expected and actual list size is the same", expectedFeedbackMessages.size(), actualFeedbackMessages.size());
        for (String message : expectedFeedbackMessages) {
            Assert.assertTrue("Message '" + message + "' is displayed", actualFeedbackMessages.contains(message));
            actualFeedbackMessages.remove(message);
        }
        driver.quit();
    }

    //TODO tests:
    //  - Validate the lengths of text fields
    //  - Validate text fields for cross site scripting attempts
    //  - Validate how pages react on mobile browsers
    //  - After form submission, validate that backend data was successfully saved maybe with an api call or db query
    //  - Refactor startup and shutdown test suites to use better BeforeTest/AfterTest logic
    //  - Refactor framework to us common logging and verification logic

}
