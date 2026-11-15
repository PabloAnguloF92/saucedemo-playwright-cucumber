package hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(1500) // Espera 1.5 segundos (1500 ms) entre cada acción
        );
        context = browser.newContext();
        page = context.newPage();
    }

    @After
    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
