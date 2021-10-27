package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.AuthenticationPage;
import pageObjects.CreateAnAccountPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;

public class registroDefinition {
    HomePage home;
    AuthenticationPage authentication;
    CreateAnAccountPage createAnAccount;
    MyAccountPage myAccount;

    public registroDefinition(){
        home = new HomePage();
        authentication = new AuthenticationPage();
        createAnAccount = new CreateAnAccountPage();
        myAccount = new MyAccountPage();
    }


    @Given("valido que la aplicacion {string} este operativa")
    public void validoQueLaAplicacionEsteOperativa(String url) {
        hooks.driver.get(url);
    }

    @When("hago clic en el botón Sign in")
    public void hagoClicEnElBotónSignIn(){
        home.clicSignIn();
    }

    @And("completo el correo electronico {string} para el registro")
    public void completoElCorreoElectronicoParaElRegistro(String email) {
        authentication.escribirEmail(email);
    }

    @And("hago clic en el botón Create an account")
    public void hagoClicEnElBotónCreateAnAccount() {
        authentication.clicCreateAnAccount();
    }

    @Then("se muestra la pantalla Create {string}")
    public void seMuestraLaPantalla(String titulo) throws InterruptedException {
        Assert.assertEquals("El titulo es incorrecto",true,createAnAccount.validarTitulo(titulo));
    }

    @And("completo la información personal {string} {string} {string} {string} {string} {string} {string}")
    public void completoLaInformaciónPersonal(String title, String firstname, String lastname, String pass, String day, String month, String year) throws InterruptedException {
        createAnAccount.seleccionarTitulo(title);
        createAnAccount.escribirFirstName(firstname);
        createAnAccount.escribirLastName(lastname);
        createAnAccount.escribirPassword(pass);
        createAnAccount.seleccionarDia(day);
        createAnAccount.seleccionarMes(month);
        createAnAccount.seleccionarAnio(year);
        createAnAccount.clicCheckSignUp();
        createAnAccount.clicCheckSpecialOffers();
    }

    @And("completo mi dirección {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void completoMiDirección(String company, String address1, String address2, String city, String state, String postal, String country, String adicional, String homephone, String mobilephone, String alias) throws InterruptedException {
        createAnAccount.escribirCompany(company);
        createAnAccount.escribirAdress(address1);
        createAnAccount.escribirAdress2(address2);
        createAnAccount.escribirCity(city);
        createAnAccount.seleccionarState(state);
        createAnAccount.escribirPostalCode(postal);
        createAnAccount.seleccionarCountry(country);
        createAnAccount.escribirAdicional(adicional);
        createAnAccount.escribirHomePhone(homephone);
        createAnAccount.escribirMobilePhone(mobilephone);
        createAnAccount.escribirAlias(alias);

    }

    @And("hago clic en el botón Register")
    public void hagoClicEnElBotónRegister() throws InterruptedException {
        createAnAccount.clicRegister();
    }

    @Then("se muestra la pantalla My Account {string}")
    public void seMuestraLaPantallaMyAccount(String titulo) {
        Assert.assertEquals("El titulo es incorrecto",true,myAccount.validarTitulo(titulo));
    }

    @And("valido la url {string}")
    public void validoLaUrl(String url) {
        Assert.assertEquals(true,myAccount.validarURL(url));
    }

    @And("valido el usuario {string}")
    public void validoElUsuario(String usuario) {
        Assert.assertEquals(true,myAccount.validarNombreUsuario(usuario));
    }

    @And("valido que el botón Log out este disponible")
    public void validoQueElBotónLogOutEsteDisponible() throws InterruptedException {
        Assert.assertEquals(true,myAccount.validarBotonSignOutHabilitado());
        Thread.sleep(20000);
    }

    @And("completo el correo electronico {string} y clic en Create an account")
    public void completoElCorreoElectronicoYClicEnCreateAnAccount(String email) throws InterruptedException {
        authentication.escribircorreoNuevo(email);
    }
}
