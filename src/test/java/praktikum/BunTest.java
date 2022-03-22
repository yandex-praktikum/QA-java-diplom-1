package praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BunTest {

    Faker faker = Faker.instance();
    Random random = new Random();

    final private String name = faker.name().toString();
    final private float price = random.nextFloat();

    Bun bun = new Bun(name, price);

    @Test
    public void getNameCheck() {
        String actual = bun.getName();
        assertEquals(name, actual);
    }

    @Test
    public void getPriceCheck() {
        float actual = bun.getPrice();
        assertEquals(price, actual, 0);
    }
}