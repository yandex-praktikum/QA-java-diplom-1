package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    //Передоваемое тестовое имя и цена
    private final String EXPECTED_NAME = "test bun";
    private final float EXPECTED_PRICE = 6.66F;
    private Bun bun;

    @Before
    public void setUp(){
        bun = new Bun(EXPECTED_NAME, EXPECTED_PRICE);
    }

    //Проверяем, что метод getName возвращает имя указанное в конструкторе
    @Test
    public void getNameOfBun() {
        String actual = bun.getName();
        assertEquals("The name of the bun does not match the specified!", actual, EXPECTED_NAME);
    }
    //Проверяем, что метод getPrice возвращает цену указанную в конструкторе
    @Test
    public void getPriceOfBun() {
        float actual = bun.getPrice();
        assertEquals("The price of the bun does not match the specified!", actual, EXPECTED_PRICE, 0);
    }
}