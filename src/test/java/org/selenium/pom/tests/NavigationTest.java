package org.selenium.pom.tests;

import org.selenium.pom.Pages.HomePage;
import org.selenium.pom.Pages.StorePage;
import org.selenium.pom.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void NavigateFromHomeToStoreUsingMainMenu() throws InterruptedException {
        StorePage storePage = new HomePage(getDriver()).load().getMyHeader().navigateToStoreUsingMenu();
        Assert.assertEquals(storePage.getTitle(), "Store");
    }

}
