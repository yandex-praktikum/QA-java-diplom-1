package praktikum.bun;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.lang3.RandomStringUtils;
import praktikum.Bun;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

@Feature(value = "Bun for burger")
@Epic(value = "Burger order in Stellar Burger")
public class BunTest {

    @Test
    @DisplayName("Getting the bun name")
    @Description("Create the new random Bun and then try to get the bun name")
    public void methodGetNameShouldReturnSameName() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();

        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    @DisplayName("Getting the bun price")
    @Description("Create the new random Bun and then try to get the bun price")
    public void methodGetPriceShouldReturnSamePrice() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();

        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0.001);
    }
}
