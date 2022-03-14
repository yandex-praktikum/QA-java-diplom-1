package praktikum;

import com.github.javafaker.Faker;
import com.github.javafaker.FunnyName;
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
        String expected = name;
        String actual = bun.getName();
        assertEquals(expected,actual);
    }

    @Test
    public void getPriceCheck() {
        float expected = price;
        float actual = bun.getPrice();
        assertEquals(expected,actual,0);
    }
}