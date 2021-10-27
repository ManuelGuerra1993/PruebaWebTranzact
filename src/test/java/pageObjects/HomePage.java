package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class HomePage extends util {
    //Definicion de locators
    @FindBy(xpath = "//a[contains(text(),'Sign in')]") private WebElement btnSignIn;

    public HomePage() {
        //Inicializacion de page facotry
        PageFactory.initElements(driver, this);
    }

    //Metodo que da clic al botón Sign In
    public void clicSignIn(){
        //Espera explicita
        wait.until(ExpectedConditions.elementToBeClickable(btnSignIn));
        //Acción del clic
        btnSignIn.click();
    }


}

