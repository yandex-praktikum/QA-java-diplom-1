package StellarBurgerTest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    @Test
    @DisplayName("Bun creating test")
    @Description("Created bun must have correct name and price")
    public void createBunTest() {
        String testName = "Cosmic";
        float testPrice = 2f;
        Bun cosmicBun = new Bun (testName, testPrice);
        Assert.assertEquals("correct bun name",cosmicBun.getName(), testName);
        Assert.assertEquals("correct bun price", cosmicBun.getPrice(),testPrice,0.0001);
    }

}
