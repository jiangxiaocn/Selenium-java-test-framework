package org.selenium.pom.Pages;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.components.MyHeader;
import org.selenium.pom.components.ProductThumbnail;

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
}
