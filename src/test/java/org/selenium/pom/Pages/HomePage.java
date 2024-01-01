package org.selenium.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.components.MyHeader;
import org.selenium.pom.components.ProductThumbnail;
import org.selenium.pom.objects.Product;

import java.io.IOException;

public class HomePage extends BasePage {
    public MyHeader getMyHeader() {
        return myHeader;
    }
    private ProductThumbnail productThumbnail;
    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }
    private MyHeader myHeader;
    public HomePage(WebDriver driver) {
        super(driver);
        myHeader = new MyHeader(driver);
        productThumbnail = new ProductThumbnail(driver);
    }
    public HomePage load(){
        load("/");
        return this;
    }
    public ProductPage navigateToTheFeaturedProduct(Integer id) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[normalize-space()='"+ new Product(id).getName() + "']"))).click();
        return new ProductPage(driver);
    }
}
