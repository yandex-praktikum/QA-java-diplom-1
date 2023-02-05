package ru.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String nameBun;
    private final float priceBun;


    public BunTest(String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters
    public static Object[][] getDataBun(){
        return new Object[][] {
                {"potato bun", 100},
                {"Brioche", 1500},
                {"Bun with sesame seeds", 0},
                {"Булочка с корицей", 8.5F},
        };
    }


    @Test
    public void getNameReturnCorrectNameBun() {
        Bun bun = new Bun(nameBun,priceBun);
        String actualName = bun.getName();
        Assert.assertEquals("Received incorrect bun name", nameBun, actualName);
    }

    @Test
    public void getPriceReturnCorrectPriceBun() {
        Bun bun = new Bun(nameBun,priceBun);
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Incorrect bun price received", priceBun, actualPrice, 0);

    }



}
