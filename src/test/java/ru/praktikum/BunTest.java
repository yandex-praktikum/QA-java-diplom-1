package ru.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private static final String NAME = "hot sauce";
    private static final float PRICE = new Random().nextFloat();

    private Bun bun;

    @Before
    public void initBun() {
        bun = new Bun(NAME, PRICE);
    }

    @Test
    public void getNameTest() {
        assertEquals(NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(PRICE, bun.getPrice(), 0);
    }

}
