package ru.yandex.practicum.burgers;

import praktikum.Bun;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    String name = "black bun";
    float price = 100F;

    Bun bun = new Bun(name, price);

    @Test
    public void doesGetNameReturnValidValue() {
        String actualName = bun.getName();
        assertEquals("Название булочки отличается:", actualName, name);
    }

    @Test
    public void doesGetPriceReturnValidValue() {
        float actualPrice = bun.getPrice();
        assertEquals("Стоимость булочки отличается:", actualPrice, price, 0.05);
    }
}
