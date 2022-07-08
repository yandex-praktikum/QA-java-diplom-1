import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.Assert;
import praktikum.Bun;

public class BunTest {
    @Test
    public void testGetName() {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        float price = faker.number().randomNumber();
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName());
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        float price = faker.number().randomNumber();
        Bun bun = new Bun(name, price);
        System.out.println(bun.getPrice());
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}