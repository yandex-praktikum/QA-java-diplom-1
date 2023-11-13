import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    String name;
    float price;

    public BunTest() {
        name = "Alisa";
        price = 2.24F;
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun(name, price);
         float actualPrice = bun.getPrice();
         assertEquals(price, actualPrice, 0);
    }
}
