package ru.yandex.practicum.tests;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameReturnsCorrectValue() {
        String expectedName = "Пшеничная";
        Bun bun = new Bun(expectedName, 19.5f);
        assertEquals("The bun name does not match the expected result", expectedName, bun.getName());
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        float expectedPrice = 20.75f;
        Bun bun = new Bun("Ржаная", expectedPrice);
        assertEquals("The bun price does not match the expected result", expectedPrice, bun.getPrice(), 0);
    }
}
