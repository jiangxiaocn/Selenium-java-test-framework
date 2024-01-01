package org.selenium.pom.tests;

import org.selenium.pom.Pages.HomePage;
import org.selenium.pom.Pages.ProductPage;
import org.selenium.pom.Pages.StorePage;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NavigationTest extends BaseTest {

    @Test
    public void NavigateFromHomeToStoreUsingMainMenu() throws InterruptedException {
        StorePage storePage = new HomePage(getDriver()).load().getMyHeader().navigateToStoreUsingMenu();
        Assert.assertEquals(storePage.getTitle(), "Store");
    }
    @Test
    public void NavigateFromStoreToProductPage() throws InterruptedException, IOException {
        Product product = new Product(1215);
        ProductPage productPage = new StorePage(getDriver()).load().navigateToTheProduct(product.getId());
        Assert.assertEquals(productPage.getProductTitle(), product.getName());
    }

    @Test
    public void NavigateFromHomeToFeaturedProductPage() throws InterruptedException, IOException {
        Product product = new Product(1215);
        ProductPage productPage = new HomePage(getDriver()).load().navigateToTheFeaturedProduct(product.getId());
        Assert.assertEquals(productPage.getProductTitle(), product.getName());
    }

}
