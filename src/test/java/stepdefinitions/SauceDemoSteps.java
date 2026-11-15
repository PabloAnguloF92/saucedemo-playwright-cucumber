package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.*;

public class SauceDemoSteps {
    LoginPage loginPage = new LoginPage(Hooks.page);
    ProductsPage productsPage = new ProductsPage(Hooks.page);
    CartPage cartPage = new CartPage(Hooks.page);
    CheckoutPage checkoutPage = new CheckoutPage(Hooks.page);

    @Given("el usuario navega a la página de Sauce Demo")
    public void navegarASauceDemo() {
        loginPage.navigate();
    }

    @When("inicia sesión con el usuario {string} y contraseña {string}")
    public void iniciarSesion(String user, String pass) {
        loginPage.login(user, pass);
    }

    @Then("debería ver la página de productos {string}")
    public void verificarPaginaProductos(String tituloEsperado) {
        Assert.assertEquals(tituloEsperado, productsPage.getHeaderTitle());
    }

    @When("agrega el producto {string} al carrito")
    public void agregarProducto(String producto) {
        productsPage.addProductToCart(producto);
    }

    @And("navega al carrito de compras")
    public void irAlCarrito() {
        productsPage.goToCart();
    }

    @Then("debería ver el producto {string} en el carrito")
    public void verificarProductoEnCarrito(String producto) {
        Assert.assertTrue(cartPage.isProductInCart(producto));
    }

    @When("procede al checkout con nombre {string}, apellido {string} y código postal {string}")
    public void procederCheckout(String nombre, String apellido, String cp) {
        cartPage.clickCheckout();
        checkoutPage.fillInformation(nombre, apellido, cp);
    }

    @And("finaliza la compra")
    public void finalizarCompra() {
        checkoutPage.finishOrder();
    }

    @Then("debería ver el mensaje de confirmación {string}")
    public void verificarConfirmacion(String mensajeEsperado) {
        Assert.assertEquals(mensajeEsperado, checkoutPage.getConfirmationMessage());
    }

    @Then("Valido mensaje {string}")
    public void validoMensajeError(String mensajeEsperado) {
        Assert.assertTrue(loginPage.getErrorMessage().contains(mensajeEsperado));
    }

    @Then("debería ver un mensaje de error indicando credenciales inválidas")
    public void verificarErrorCredencialesInvalidas() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }
    @Then("el ícono del carrito debería mostrar {string} producto")
    public void verificarCantidadCarrito(String cantidadEsperada) {
        Assert.assertEquals(cantidadEsperada, productsPage.getCartItemCount());
    }

}

