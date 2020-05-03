package org.stas.osikov.rozetka.page;

import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@SuppressWarnings("rawtypes")
@Component
public class SearchPage extends MainPage {


    @Step
    public SearchPage openSearchPage(){
        openPage(SearchPage.class);
        return this;
    }


}
