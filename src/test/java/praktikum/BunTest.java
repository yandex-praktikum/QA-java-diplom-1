package praktikum;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
Тестирование класса Bun
shouldGetName проверяет верно ли возвращаемое имя
shouldGetPrice проверяет верное ли возвращаемая цена
 */
public class BunTest extends BaseClass {

    Bun bun = new Bun(bunName, price);

    @Test
    public void shouldGetNameTest() {
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void shouldGetPriceTest() {
       assertEquals(price, bun.getPrice(), 0.01);
    }
}