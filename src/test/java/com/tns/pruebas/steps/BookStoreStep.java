package com.tns.pruebas.steps;

import com.tns.pruebas.pages.BookStorePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class BookStoreStep {
    private BookStorePage bookStorePage = new BookStorePage();

    @Given("Seleccionar los libros y las cantidades$")
    public void agregarCantidadesPorLibro(DataTable dataTable){
        bookStorePage.getBookCuantities("q");
        List<List<String>> data = dataTable.raw();
        bookStorePage.addCuatityByBook(0,  data.get(1).get(1));
        bookStorePage.addCuatityByBook(1,  data.get(2).get(1));
        bookStorePage.addCuatityByBook(2,  data.get(3).get(1));
        bookStorePage.takeScreenshoots("agregar_libros","book_store");
    }

    @When("Agregar al carro de compras")
    public void agregarLibrosAlCarritoDeCompras(){
       bookStorePage.addBooksToCar();
    }

    @Then("^deberia ver un gran total de \"(.*)\"$")
    public void verificarValorCompra(String valor){
        Assert.assertEquals(valor, bookStorePage.getWebElement("total").getAttribute("value"));
        bookStorePage.takeScreenshoots("ver valor total compra","book_store");
    }
}
