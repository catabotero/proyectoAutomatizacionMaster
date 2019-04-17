package com.tns.pruebas.steps;

import com.tns.pruebas.pages.LoginPage;
import com.tns.pruebas.utils.TestUtils;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LoginStep {

    private LoginPage loginPage = new LoginPage();

    @Given("^Que he ingresado a la pagina \"(.*)\"$")
    public void openPage(String url) {
        loginPage.navigateTo(url);
    }

    @And("^he Ingresado nombre de usuario y Password$")
    public void enterCredentials(DataTable dataTable) {
      List<List<String>> data = dataTable.raw();
      loginPage.writeCredentials(data.get(1).get(1), data.get(1).get(0));
      loginPage.takeScreenshoots("ingresar_credenciales", "login_test");
    }

    @When("^de click en el boton login")
    public void pressButton() {

        loginPage.executeButtonAction();
    }

    @Then("^deberia acceder al aplicativo")
    public void validateLogin(){
        Assert.assertTrue(null != loginPage.getWebElement("available"));
        Assert.assertEquals("Books",loginPage.getApplicationTitle());
        loginPage.takeScreenshoots("login_exitoso", "login_test");
    }
}
