package site.nomoreparties.stellarburgers;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;

public class BunTest {
    private final Faker faker = new Faker();
    private final Random random = new Random();
    private final String name = faker.space().galaxy();
    private final float price = random.nextFloat() + random.nextInt();

    @Test
    public void setPriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Set a price is not correct", price, bun.getPrice(), 0.01);
    }

    @Test
    public void setNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Set a name is not correct", name, bun.getName());
    }
}
