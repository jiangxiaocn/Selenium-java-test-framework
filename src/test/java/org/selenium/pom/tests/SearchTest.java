package org.selenium.pom.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Pages.StorePage;
import org.selenium.pom.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test
    public void searchWithPartialMatch() {
        String searchFor = "Blue";
        StorePage storePage = new StorePage(getDriver()).load().search(searchFor);
        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");
    }
}
