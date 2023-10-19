package ru.yandex.praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price)
    {
        this.name = name;
        this.price = price;
    }

        @Parameterized.Parameters
        public static Object[][] getData ()
        {
            return new Object[][]{
                    {"Мясо бессмертных моллюcков Protostomia ну или просто не корроткое наименование", 19991337},
                    {"Флюресцентная булка R2-D3", 988.9f},
                    {"Bullka!@", 0},
                    {null, 567},
                    {" ", 1},
                    {"%", -123},
                               };
        }
    @Test
        public void checkGetNameBunTest () {
              Bun bun = new Bun(name,price);
            assertEquals(name, bun.getName());

        }
    @Test
    public void checkGetPriceBunTest () {
        Bun bun = new Bun(name,price);
        assertEquals(price, bun.getPrice(), 0.001);

    }


    }




