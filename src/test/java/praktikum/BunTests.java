package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//@RunWith(Parameterized.class)
public class BunTests {

    private Bun bun = new Bun("Булка цвета из иных миров", 2535.25F);

    @Test
    public void testBunGetName() {
        assertEquals("Безымянная булка!", "Булка цвета из иных миров", bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        assertEquals("Булка бесценна!", 2535.25F, bun.getPrice(), 0.005);
    }
}
