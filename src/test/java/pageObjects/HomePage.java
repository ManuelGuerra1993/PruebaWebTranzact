package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class HomePage extends util {
    @FindBy(xpath = "//a[contains(text(),'Sign in')]") private WebElement btnSignIn;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void clicSignIn(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSignIn));
        btnSignIn.click();
    }


}

