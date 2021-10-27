package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class AuthenticationPage extends util {
    //Identificaci[on de locators
    @FindBy(id = "email_create") private WebElement txtEmail;
    @FindBy(id = "email_create") private WebElement txtEmail1;
    @FindBy(id = "SubmitCreate") private WebElement btnCreateAnAccount;
    @FindBy(id = "SubmitCreate") private WebElement btnCreateAnAccount1;
    @FindBy(id = "create_account_error") private WebElement msgError;

    public AuthenticationPage(){
        //Inicialización del Page Factory para la utilización del FindBy
        PageFactory.initElements(driver, this);
    }

    //Este metodo se encarga de escribir el email
    public void escribirEmail(String email){
        //Este wait se encarga de darle un tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        //Se invoca al locator y se le manda la instrucción de escribir el parametro email
        txtEmail.sendKeys(email);
    }

    //Este metodo le da clic al boton Create An Account
    public void clicCreateAnAccount(){
        //Este wait se encarga de darle un tiempo de espera explicito
        wait.until(ExpectedConditions.elementToBeClickable(btnCreateAnAccount));
        //Se invoca al locator y se le da la instrucción de dar clic al botón
        btnCreateAnAccount.click();
    }

    //Este metodo se encarga de buscar correo valido y nuevo para el registro
    public void escribircorreoNuevo(String email) throws InterruptedException {
        //invoco los metodo antes descritos
        escribirEmail(email);
        clicCreateAnAccount();
        //Aqui genero dos parametros de tipo string
            String usu = "manu.guerra";
            String dominio = "@gmail.com";
            //En este bloque intento validar la visualización de mensaje de error. Si falla lo captura en el catch para no detener la prueba.
            try {
                //Aqui espero explicitamente el mensaje de error
                wait.until(ExpectedConditions.visibilityOf(msgError));
                //For se encarga de iterar hasta que el msgError sea false
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
