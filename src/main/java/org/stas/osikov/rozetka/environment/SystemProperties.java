package org.stas.osikov.rozetka.environment;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SystemProperties {

    private static final String ROOT_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final String APP_CONFIG_PATH = ROOT_PATH + "browser.properties";
    private static final Properties applicationProperties = new Properties();

    @SneakyThrows(IOException.class)
    private static void initProperties() {
        applicationProperties.load(new FileInputStream(APP_CONFIG_PATH));
    }

    protected String getBrowser(){
        return applicationProperties.getProperty("browser");
    }

    protected boolean isHeadless(){
        return Boolean.parseBoolean(applicationProperties.getProperty("headless"));
    }

    protected String getUrl(){
        return applicationProperties.getProperty("url");
    }

    protected String getBrowserSize(){
        return applicationProperties.getProperty("browser_size");
    }
}
