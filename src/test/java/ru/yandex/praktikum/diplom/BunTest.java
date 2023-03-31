package ru.yandex.praktikum.diplom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    public String name;
    public float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return TestData.TEST_DATA_FOR_BUN_TEST;
    }

    @Test
    public void getNameReturnName() {
        Bun bun = new Bun(name, price);
        String expected = name;
        String actual = bun.getName();
        assertEquals("Неверное название", expected, actual);
    }

    @Test
    public void getNameReturnPrice() {
        Bun bun = new Bun(name, price);
        float expected = price;
        float actual = bun.getPrice();
        assertEquals("Неверная цена", expected, actual, 0);
    }
}
