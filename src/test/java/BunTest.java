import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    static Faker faker = new Faker();
    public final String name = faker.food().ingredient();
    public final float price = (float) faker.number().randomDouble(2,1, 1000);
    private final Bun bun = new Bun(name, price);

    @Test
    public void returnNameTest() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void returnPriceTest() {
        Assert.assertEquals(price, bun.getPrice(), 0.000001);
    }
}
