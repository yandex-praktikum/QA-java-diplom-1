package practicumTest;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;

public class BunTest {
    Faker faker = new Faker();
    Random random = new Random();
    private final String name = faker.space().galaxy();
    private final float price = random.nextFloat() + random.nextInt();

    @Test
    public void setPriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertTrue("Set a price is not correct", price == bun.getPrice());
    }

    @Test
    public void setNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Set a name is not correct", name, bun.getName());
    }
}
