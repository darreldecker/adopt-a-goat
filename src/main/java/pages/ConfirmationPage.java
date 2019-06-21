package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebDriverBase;

public class ConfirmationPage extends WebDriverBase {

    //** Page Elements **//

    private WebElement txtConfirmationMessage() {
        return driver.findElement(By.xpath("//h2"));
    }

    //** Page Methods **//

    public boolean pageExists() {
        // Validates if the confirmation page is the current page
        // TODO: Use better validation than the url
        return driver.getCurrentUrl().contains("confirmation.html");
    }

    public String getConfirmationMessage() {
        return txtConfirmationMessage().getText();
    }

}
