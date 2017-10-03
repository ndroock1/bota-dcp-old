package org.nilostep.bota.dcp.bookmakers;

import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Config(
        url = "",
//        browser = Browser.PHANTOMJS,
        browser = Browser.CHROME,
        hub = ""
)

public class BrowserFacade extends Locomotive {

    //    private static Logger logger = LogManager.getLogger();

    public BrowserFacade() {
    };

    public String getRawData(String url, String css) {
        navigateTo(url);
        return waitForElement(By.cssSelector(css)).getAttribute("innerHTML");
    }

    public void quitDriver() {
        driver.quit();
    }

    public static void main (String[] args) throws InterruptedException {
        BrowserFacade site = new BrowserFacade();

        // Test
        System.out.println(site.getRawData("https://www.vi.nl/", "#navigation > div.o-wrapper > div > div.flex-menu-section-container.flex-menu-section-container--primary > div.flex-menu-part--main > ul > li:nth-child(2)"));

        site.quitDriver();
    }
}