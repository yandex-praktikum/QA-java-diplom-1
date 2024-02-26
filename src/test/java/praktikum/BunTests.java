package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTests {

    @Test
    public void createBunTest(){
        String name = "Bun";
        float price = 1f;
        Bun bun = new Bun(name, price);
        assertEquals("Wrong name", name, bun.getName());
        assertEquals("Wrong price", price, bun.getPrice(), 0);
    }
}
