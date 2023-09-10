import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;

public class TestBun {

    private String name;
    private float price;

    @Before
    public void createBun() {
        Faker faker = new Faker();
        name = faker.food().ingredient();
        price = (float) faker.number().randomDouble(2, 0, 1000);
        System.out.println("Fake name - " + name + "and price " + price);
    }

    @Test
    public void checkName() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void checkPrice() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}