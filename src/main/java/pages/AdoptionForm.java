package pages;

import models.AdoptionFormData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WebDriverBase;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.isValidEmail;

public class AdoptionForm extends WebDriverBase {

    //** Page Elements **//

    private WebElement txtFirstName(){
        return driver.findElement(By.id("firstName"));
    }

    private WebElement txtLastName(){
        return driver.findElement(By.id("lastName"));
    }

    private WebElement txtEmail(){
        return driver.findElement(By.id("email"));
    }

    private WebElement txtAddress(){
        return driver.findElement(By.id("address"));
    }

    private WebElement txtAddress2(){
        return driver.findElement(By.id("address2"));
    }

    private Select selCountry(){
        return new Select(driver.findElement(By.id("country")));
    }

    private Select selState(){
        return new Select(driver.findElement(By.id("state")));
    }

    private WebElement txtZip(){
        return driver.findElement(By.id("zip"));
    }

    private WebElement txtComments(){
        return driver.findElement(By.id("comments"));
    }

    private WebElement btnAdoptNow(){
        return driver.findElement(By.xpath("//button[text()='Adopt Now']"));
    }

    //** Page Methods **//
    public boolean pageExists(){
        // Validates if the form page is the current page
        // TODO: Use better validation than the url
        return driver.getCurrentUrl().contains("index.html");
    }

    public void enterFormData(AdoptionFormData formData){
        // Fills out all form fields based on the given form data and then clicks the [Adopt Now] button.
        // If the given form data is not supplied (null) then the field is skipped
        if(formData.getFirstName() != null){
            this.txtFirstName().sendKeys(formData.getFirstName());
        }

        if(formData.getLastName() != null){
            this.txtLastName().sendKeys(formData.getLastName());
        }

        if(formData.getEmail() != null){
            this.txtEmail().sendKeys(formData.getEmail());
        }

        if(formData.getAddress() != null){
            this.txtAddress().sendKeys(formData.getAddress());
        }

        if(formData.getAddress2() != null){
            this.txtAddress2().sendKeys(formData.getAddress2());
        }

        if(formData.getCountry() != null){
            this.selCountry().selectByVisibleText(formData.getCountry());
        }

        if(formData.getState() != null){
            this.selState().selectByVisibleText(formData.getState());
        }

        if(formData.getZip() != null){
            this.txtZip().sendKeys(formData.getZip());
        }

        if(formData.getBestGoat() != null){
            this.selectBestGoat(formData.getBestGoat());
        }

        if(formData.getComments() != null){
            this.txtComments().sendKeys(formData.getComments());
        }

        this.btnAdoptNow().click();
    }

    public void selectBestGoat(String bestGoatName){
        // Selects a radio button containing the given text
        WebElement rdoToSelect = driver.findElement(By.xpath("//input[@type='radio']/../label[contains(text(),\""+bestGoatName+"\")]"));
        rdoToSelect.click();
    }

    public List<String> getFeedbackMessages(){
        // Gets the feedback messages that are displayed on the page
        List<WebElement> messageList = driver.findElements(By.xpath("//div[@class='invalid-feedback']"));
        List<String> messages = new ArrayList<>();
        for (WebElement element: messageList){
            if(element.isDisplayed()){
                messages.add(element.getText());
            }
        }
        return messages;
    }

    public List<String> getExpectedFeedbackMessages(AdoptionFormData formData){
        // Generates a list of expected feedback messages based on input to the form. Keeping
        // the expected logic coupled with the page allows it to be easily modified for additional
        // validation if needed.
        List<String> expectedMessages = new ArrayList<>();

        if(formData.getFirstName() == null){
            expectedMessages.add("Valid first name is required.");
        }

        if(formData.getLastName() == null){
            expectedMessages.add("Valid last name is required.");
        }

        if(formData.getEmail() != null && !isValidEmail(formData.getEmail())){
            expectedMessages.add("Please enter a valid email address for adoption updates.");
        }

        if(formData.getAddress() == null){
            expectedMessages.add("Please enter your home address.");
        }

        if(formData.getCountry() == null){
            expectedMessages.add("Please select a valid country.");
        }

        if(formData.getState() == null){
            expectedMessages.add("Please provide a valid state.");
        }

        if(formData.getZip() == null){
            expectedMessages.add("Zip code required.");
        }

        return expectedMessages;
    }



}
