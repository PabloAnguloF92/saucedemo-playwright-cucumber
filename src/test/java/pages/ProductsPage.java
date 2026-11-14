package pages;

import com.microsoft.playwright.Page;

public class ProductsPage {
    private final Page page;

    public ProductsPage(Page page) {
        this.page = page;
    }

    public boolean isAtProductsPage() {
        return page.locator(".title").textContent().equals("Products");
    }

    public void addProductToCart(String productName) {
        String formattedName = productName.toLowerCase().replace(" ", "-");
        page.click("#add-to-cart-" + formattedName);
    }

    public void goToCart() {
        page.click(".shopping_cart_link");
    }
}

