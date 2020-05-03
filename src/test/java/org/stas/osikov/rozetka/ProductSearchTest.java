package org.stas.osikov.rozetka;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class ProductSearchTest extends MainTest {

    @Test
    @Description("In this test we're checking that a user can search for a product and see it on a result page")
    void productShouldBeDisplayed(){
        searchPage.openSearchPage();
    }
}
