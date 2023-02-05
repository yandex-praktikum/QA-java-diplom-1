package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void checkBunsNameTest() {
        Bun bun = new Bun("Булочка с кунжутом", 5.25f);
        String expectedName = "Булочка с кунжутом";
        String actualName = bun.getName();

        assertEquals("Название не соответствует", expectedName, actualName);
    }

    @Test
    public void checkBunsPriceTest() {
        Bun bun = new Bun("Ржаная булочка", 4.05f);
        float expectedPrice = 4.05f;
        float actualPrice = bun.getPrice();

        assertEquals("Цена не соответствует", expectedPrice, actualPrice, 0.0f);
    }
}
