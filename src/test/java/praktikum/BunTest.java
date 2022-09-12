package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BunTest {

    @Test
    public void checkBunGetName(){

        Bun bun = new Bun("white", 3);
        String actualName = bun.getName();
        String expectedName = "white";
        assertEquals("Bun name is incorrect", expectedName, actualName);

    }

    @Test
    public void checkBunGetPrice(){

        Bun bun = new Bun("white", 3);
        float actualPrice = bun.getPrice();
        float expectedPrice = 3;
        assertThat("Bun price is incorrect", actualPrice, is(expectedPrice));

    }



}
