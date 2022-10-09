package org.example;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void getRealName() {
        // arrange
        Bun bun = new Bun("с маком", 10);
        String expectedRealName = "с маком";
        // act
        String actualRealName = bun.getName();
        // assert
        assertEquals(expectedRealName, actualRealName);
    }

    @Test
    public void getRealPrice() {
        // arrange
        Bun bun = new Bun("с маком", 12);
        float expectedRealPrice = 12;
        // act
        float actualRealPrice = bun.getPrice();
        // assert
        assertEquals(expectedRealPrice, actualRealPrice, 0);
    }
}
