package org.selenium.pom.tests;

import org.selenium.pom.Pages.CartPage;
import org.selenium.pom.Pages.HomePage;
import org.selenium.pom.Pages.ProductPage;
import org.selenium.pom.Pages.StorePage;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataproviders.MyDataProvider;
import org.selenium.pom.objects.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTest extends BaseTest {

    @Test(description = "add product to cart from store page")
    public void addToCartFromStorePage() throws IOException {
        Product product = new Product(1215);
        CartPage cartPage = new StorePage(getDriver()).load().
                getProductThumbnail().
                clickAddToCartBtn(product.getName()).clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

    }
    @Test(dataProvider = "getFeaturedProducts", dataProviderClass = MyDataProvider.class)
    public void addToCartFeaturedProducts(Product product){
        CartPage cartPage = new HomePage(getDriver()).load().
                getProductThumbnail().
                clickAddToCartBtn(product.getName()).
                clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
    }
    @Test
    public void addToCartFromProductPage() throws IOException {
        Product NewProduct =new Product(1215);
        String productNameSeperatedByDash=NewProduct.getName().toLowerCase().replaceAll(" ", "-");

        ProductPage productPage = new ProductPage(getDriver()).loadProduct(productNameSeperatedByDash).clickOnAddToCartBtn();
        Assert.assertTrue(productPage.getAlertText().contains("“" + NewProduct.getName() +"” has been added to your cart."));
    }
}
