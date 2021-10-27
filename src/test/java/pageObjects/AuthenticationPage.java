package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class AuthenticationPage extends util {
    @FindBy(id = "email_create") private WebElement txtEmail;
    @FindBy(id = "email_create") private WebElement txtEmail1;
    @FindBy(id = "SubmitCreate") private WebElement btnCreateAnAccount;
    @FindBy(id = "SubmitCreate") private WebElement btnCreateAnAccount1;
    @FindBy(id = "create_account_error") private WebElement msgError;

    public AuthenticationPage(){
        PageFactory.initElements(driver, this);
    }

    public void escribirEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys(email);
    }

    public void clicCreateAnAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(btnCreateAnAccount));
        btnCreateAnAccount.click();
    }

    public void escribircorreoNuevo(String email) throws InterruptedException {
        escribirEmail(email);
        clicCreateAnAccount();
            String usu = "manu.guerra";
            String dominio = "@gmail.com";
            try {
                wait.until(ExpectedConditions.visibilityOf(msgError));
                for (int i = 1; msgError.isEnabled(); i++) {
                    String correo = usu + i + dominio;
                    txtEmail1.clear();
                    txtEmail1.sendKeys(correo);
                    btnCreateAnAccount1.click();
                    Thread.sleep(8000);
                }
            } catch (NoSuchElementException e){
                System.out.println("Termino de la instrucción");
            } catch (org.openqa.selenium.StaleElementReferenceException d){
                System.out.println("No encontró el mensaje de error");
            } catch (org.openqa.selenium.TimeoutException f){
                System.out.println("Time out");
            }
    }
}
