package com.demo.pageobjects.saucedemo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.abstractcomponents.AbstractSauceDemo;

public class Homepage extends AbstractSauceDemo {
    WebDriver driver;

    public Homepage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "app_logo")
    private WebElement HomePageText;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;

    By listOfProducts = By.cssSelector(".inventory_item");
    By titleProduct = By.cssSelector(".inventory_item_name");
    By addToCartButton = By.cssSelector(".btn_inventory");

    public String getHomePageText() {
        return HomePageText.getText();
    }
    // method untuk cari produk
    public WebElement getProductByName(String productName) {
        List<WebElement> products = driver.findElements(listOfProducts);
        WebElement productToSelect = products.stream()
                .filter(prod -> prod.findElement(titleProduct).getText().equals(productName))
                .findFirst()
                .orElse(null);
        return productToSelect;
    }

    public void addToCart(String productName) throws InterruptedException {
        System.out.println("Adding " + productName + " to cart.");
        visibilityOfElementLocated(listOfProducts);
        getProductByName(productName).findElement(addToCartButton).click();
        Thread.sleep(2000);
    }

    public void clickOnCart() {
        cartButton.click();
    }
}