package org.stas.osikov.rozetka.environment;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import javax.naming.NamingException;
import java.util.logging.Logger;

@SuppressWarnings("all")
public final class Browser {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Browser.class));

    private static BrowserFactory instance;
    private final static SystemProperties systemProperties = new SystemProperties();

    private static Browsers currentBrowser = Browsers.valueOf(systemProperties.getBrowser());

    static final boolean IS_HEADLESS = systemProperties.isHeadless();
    public static final String BROWSER_URL = systemProperties.getUrl();
    private static final String BROWSER_SIZE = systemProperties.getBrowserSize();

    private Browser(){
        LOGGER.info(String.format("browser %s is ready", currentBrowser.name()));
    }

    @SuppressWarnings("all")
    public static void getInstance() {
        if (instance == null) {
            synchronized (BrowserFactory.class) {
                initNewDriver();
                instance = new BrowserFactory();
            }
        }
    }

    static boolean isGrid() {
        return false;
    }

    public static WebDriver getDriver() {
        return WebDriverRunner.getWebDriver();
    }

    private static void initNewDriver() {
        WebDriverManager.chromedriver().version("79");
//        Configuration.browserSize = BROWSER_SIZE;
        try {
            BrowserFactory.setUp(currentBrowser);
        } catch (NamingException e) {
            LOGGER.info("Browser: getting New Driver " + e.getExplanation());;
        }
    }

    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public enum Browsers {
        FIREFOX("firefox"),
        CHROME("chrome");

        @Getter
        private final String value;
    }

}
