package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class MyAccountPage extends util {
    //Definicion de locators
    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    private WebElement lblTitulo;
    @FindBy(xpath = "//a[@class='logout']") private WebElement btnSignOut;


    public MyAccountPage(){
        //Inicialización de Page Factory para los locators
        PageFactory.initElements(driver, this);
    }

    //Metodo para validar el titulo
    public boolean validarTitulo(String titulo) {
        wait.until(ExpectedConditions.visibilityOf(lblTitulo));
        if (titulo.equals(lblTitulo.getText())) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo para validar la url actual
    public boolean validarURL(String url){
        String uri = driver.getCurrentUrl();
        System.out.println(uri);
        if (driver.getCurrentUrl().equals(url)){
            return true;
        } else {
            return false;
        }
    }

    //Metodo para validar el nombre del usuario logueado
    public boolean validarNombreUsuario(String usuario){
        WebElement usu = driver.findElement(By.xpath("//span[contains(text(),'"+usuario+"')]"));
        if (usuario.equals(usu.getText())){
            return true;
        } else {
            return false;
        }
    }

    //Metodo para validar que el botón Sign Out este habilitado
    public boolean validarBotonSignOutHabilitado(){
        if (btnSignOut.isEnabled()){
            return true;
        } else {
            return false;
        }
    }

}
