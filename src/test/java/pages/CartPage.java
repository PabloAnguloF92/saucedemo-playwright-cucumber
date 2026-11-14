package pages;

import com.microsoft.playwright.Page;

public class CartPage {
    private final Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public boolean isProductInCart(String productName) {
        return page.locator(".inventory_item_name").textContent().equals(productName);
    }

    public void clickCheckout() {
        page.click("#checkout");
    }
}

