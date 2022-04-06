import junit.framework.TestCase;
import org.junit.Test;
import praktikum.Bun;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class BunTest extends TestCase {

    /*
    Проверка метода getName() класса Bun.java
     */
    @Test
    public void testGetNameSomeNameReturnString() throws Exception {

        Random random = new Random();

        String name = RandomStringUtils.randomAlphabetic(10);
        Float price = random.nextFloat();

        Bun bun = new Bun(name, price);

        String actualName = bun.getName();

        assertEquals("Error in Bun class getName() method", name, actualName);

    }

    /*
    Проверка метода getPrice() класса Bun.java
    */
    @Test
    public void testGetPriceSomePriceReturnFloat() throws Exception {

        Random random = new Random();

        String name = RandomStringUtils.randomAlphabetic(10);
        Float price = random.nextFloat();

        Bun bun = new Bun(name, price);

        float actualPrice = bun.getPrice();

        assertEquals("Error in Bun class getPrice() method", price, actualPrice);

    }

}
