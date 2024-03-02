package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    String name = "bigBun";
    float price = 1234;
    Bun bun = new Bun(name, price);

    @Test
    public void getName() {
        assertEquals("Проверка Модель булочки для бургера", name, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals("Проверка цену для бургера", price, bun.getPrice(), 0.001f); //Проверка с погрешностью для float
    }
}