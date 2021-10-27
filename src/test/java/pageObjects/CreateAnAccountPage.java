package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class CreateAnAccountPage extends util {
    //Lista de locators
    @FindBy(xpath = "//h1[contains(text(),'Create an account')]")
    private WebElement lblTitulo;
    @FindBy(id = "uniform-id_gender1")
    private WebElement rbMr;
    @FindBy(id = "uniform-id_gender2")
    private WebElement rbMrs;
    @FindBy(id = "customer_firstname")
    private WebElement txtFirstName;
    @FindBy(id = "customer_lastname")
    private WebElement txtLastName;
    @FindBy(id = "email")
    private WebElement txtEmail;
    @FindBy(id = "passwd")
    private WebElement txtPassword;
    @FindBy(id = "days")
    private WebElement cboDay;
    @FindBy(id = "months")
    private WebElement cboMonth;
    @FindBy(id = "years")
    private WebElement cboAnio;
    @FindBy(id = "newsletter")
    private WebElement chkb1;
    @FindBy(id = "optin")
    private WebElement chkb2;
    @FindBy(id = "firstname")
    private WebElement txtFirstName_1;
    @FindBy(id = "lastname")
    private WebElement txtLastName_1;
    @FindBy(id = "company")
    private WebElement txtCompany;
    @FindBy(id = "address1")
    private WebElement txtAdress1;
    @FindBy(id = "address2")
    private WebElement txtAdress2;
    @FindBy(id = "city")
    private WebElement txtCity;
    @FindBy(id = "id_state")
    private WebElement cboState;
    @FindBy(id = "postcode")
    private WebElement txtPostCode;
    @FindBy(id = "id_country")
    private WebElement cboCountry;
    @FindBy(id = "other")
    private WebElement txtAdicional;
    @FindBy(id = "phone")
    private WebElement txtHomePhone;
    @FindBy(id = "phone_mobile")
    private WebElement txtPhoneMobile;
    @FindBy(id = "alias")
    private WebElement txtAlias;
    @FindBy(id = "submitAccount")
    private WebElement btnRegister;

    public CreateAnAccountPage() {
        PageFactory.initElements(driver, this);
    }

    //Metodo booleano que compara el titulo
    public boolean validarTitulo(String titulo) {
        //Espera explicita
        wait.until(ExpectedConditions.visibilityOf(lblTitulo));
        //Condición si el titulo es igual se retorna true
        if (titulo.equals(lblTitulo.getText())) {
            return true;
        } else {
            //Si el titulo no es igual, se retorna falso
            return false;
        }
    }

    public void seleccionarTitulo(String title) {
        if (title.equals("Mr")) {
            wait.until(ExpectedConditions.visibilityOf(rbMr));
            rbMr.click();
        } else if (title.equals("Mrs")) {
            wait.until(ExpectedConditions.visibilityOf(rbMrs));
            rbMrs.click();
        }
    }

    public void escribirFirstName(String firstname) {
        wait.until(ExpectedConditions.visibilityOf(txtFirstName));
        txtFirstName.sendKeys(firstname);
    }

    public void escribirLastName(String lastname) {
        wait.until(ExpectedConditions.visibilityOf(txtLastName));
        txtLastName.sendKeys(lastname);
    }

    public void escribirPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.sendKeys(pass);
    }

    public void seleccionarDia(String day) {
        new Select(cboDay).selectByValue(day);
    }

    public void seleccionarMes(String month) {
        new Select(cboMonth).selectByValue(validarMes(month));
    }

    public String validarMes(String month){
        String mes= "0";
        if ("January".equals(month)) {
            mes = "1";
        } if ("February".equals(month)){
            mes = "2";
        } if ("March".equals(month)){
            mes = "3";
        } if ("April".equals(month)){
            mes = "4";
        } if ("May".equals(month)){
            mes = "5";
        } if ("June".equals(month)){
            mes = "6";
        } if ("July".equals(month)){
            mes = "7";
        } if ("August".equals(month)){
            mes = "8";
        } if ("September".equals(month)){
            mes = "9";
        } if ("October".equals(month)){
            mes = "10";
        } if ("November".equals(month)){
            mes = "11";
        } if ("December".equals(month)){
            mes = "12";
        }
        return mes;
    }

    public void seleccionarAnio(String anio) {
        new Select(cboAnio).selectByValue(anio);
    }

    public void clicCheckSignUp() {
        chkb1.click();
    }

    public void clicCheckSpecialOffers() {
        chkb2.click();
    }

    public void escribirCompany(String company) {
        wait.until(ExpectedConditions.visibilityOf(txtCompany));
        txtCompany.sendKeys(company);
    }

    public void escribirAdress(String adress) {
        wait.until(ExpectedConditions.visibilityOf(txtAdress1));
        txtAdress1.sendKeys(adress);
    }

    public void escribirAdress2(String adress){
        wait.until(ExpectedConditions.visibilityOf(txtAdress2));
        txtAdress2.sendKeys(adress);
    }
    public void escribirCity(String city){
        wait.until(ExpectedConditions.visibilityOf(txtCity));
        txtCity.sendKeys(city);
    }
    public void seleccionarState(String state){
        new Select(cboState).selectByVisibleText(state);
    }
    public void escribirPostalCode(String postalCode){
        wait.until(ExpectedConditions.visibilityOf(txtPostCode));
        txtPostCode.sendKeys(postalCode);
    }
    public void seleccionarCountry(String country){
        new Select(cboCountry).selectByVisibleText(country);
    }
    public void escribirAdicional(String adicional){
        wait.until(ExpectedConditions.visibilityOf(txtAdicional));
        txtAdicional.sendKeys(adicional);
    }
    public void escribirHomePhone(String homephone){
        wait.until(ExpectedConditions.visibilityOf(txtHomePhone));
        txtHomePhone.sendKeys(homephone);
    }
    public void escribirMobilePhone(String mobilephone){
        wait.until(ExpectedConditions.visibilityOf(txtPhoneMobile));
        txtPhoneMobile.sendKeys(mobilephone);
    }
    public void escribirAlias(String alias){
        wait.until(ExpectedConditions.visibilityOf(txtAlias));
        txtAlias.clear();
        txtAlias.sendKeys(alias);
    }
    public void clicRegister(){
        wait.until(ExpectedConditions.elementToBeClickable(btnRegister));
        btnRegister.click();
    }
}
