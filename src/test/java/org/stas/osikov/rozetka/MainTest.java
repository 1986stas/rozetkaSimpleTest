package org.stas.osikov.rozetka;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.stas.osikov.rozetka.environment.Browser;
import org.stas.osikov.rozetka.page.AbstractPage;
import org.stas.osikov.rozetka.page.ProductsPage;
import org.stas.osikov.rozetka.page.SearchPage;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AbstractPage.class)
public class MainTest {

    @Autowired
    ProductsPage productsPage;
    @Autowired
    SearchPage searchPage;

    @BeforeAll
    static void openPage() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().
                screenshots(true).savePageSource(false));
        Browser.getInstance();
    }

    @AfterAll
    public static void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

}