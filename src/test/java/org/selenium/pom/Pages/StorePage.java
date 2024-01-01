package org.selenium.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.components.ProductThumbnail;
import org.selenium.pom.objects.Product;

import java.io.IOException;

public class StorePage extends BasePage {
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");

    private final By infoTxt = By.cssSelector(".woocommerce-info");
    public StorePage(WebDriver driver) {
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    private ProductThumbnail productThumbnail;


    public StorePage load(){
        load("/store");
        return this;
    }

    private StorePage enterTextInSearchFld(String txt){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);
        return this;
    }

    protected void clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }

    public StorePage search(String txt){
        enterTextInSearchFld(txt).clickSearchBtn();
        return this;
    }
    public String getTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public ProductPage navigateToTheProduct(Integer id) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[normalize-space()='"+ new Product(id).getName() + "']"))).click();
        return new ProductPage(driver);
    }
    public String getInfo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(infoTxt)).getText();
    }
}
