package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameTest(){
        Bun bun = new Bun("Булочка с повидлом", 23);
        String actual = bun.getName();
        String expected = "Булочка с повидлом";
        assertEquals("Название булочки не совпадает.", expected, actual);
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun("Булочка с повидлом", 23.0f);
        float actual = bun.getPrice();
        float expected = 23.0f;
        assertEquals("Цена булочки не совпадает.", expected, actual, 0.0f);

    }
}
