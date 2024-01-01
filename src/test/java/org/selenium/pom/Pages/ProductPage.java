package org.selenium.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.components.MyHeader;
import org.selenium.pom.components.ProductThumbnail;
import org.selenium.pom.objects.Product;

public class ProductPage extends BasePage {
    private final By productTitle = By.cssSelector(".product_title.entry-title");
    private final By addToCartBtn = By.cssSelector(".single_add_to_cart_button");

    private final By alert = By.cssSelector("div[role='alert']");
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public ProductPage load(){
        load("/product");
        return this;
    }
    public String getProductTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
    }
    public ProductPage clickOnAddToCartBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        return this;
    }
    public String getAlertText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(alert)).getText();
    }
    public ProductPage loadProduct(String productNameSeparatedByDash){
        load("/product/" + productNameSeparatedByDash + "/");
        return this;
    }
}
