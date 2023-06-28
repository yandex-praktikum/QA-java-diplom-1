package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("white bun", 200);
        assertEquals("white bun", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("white bun", 200);
        assertEquals(200, bun.getPrice(), 0);
    }

    @Test
    public void getNameNullTest() {
        // Значение названия равно null
        Bun bun = new Bun(null, 200);
        assertNull(bun.getName());
    }

    @Test
    public void getNameEmptyStringTest() {
        // Значение названия является пустой строкой
        Bun bun = new Bun("", 200);
        assertEquals("", bun.getName());
    }

    @Test
    public void getNameLongStringTest() {
        // Очень длинное значение названия
        Bun bun = new Bun("This is a very long bun name that exceeds the maximum length", 200);
        assertEquals("This is a very long bun name that exceeds the maximum length", bun.getName());
    }

    @Test
    public void getNameSpecialCharactersTest() {
        // Значение названия содержит специальные символы
        Bun bun = new Bun("Bun with $pecial Characters!", 200);
        assertEquals("Bun with $pecial Characters!", bun.getName());
    }

    @Test
    public void getPricePositiveTest() {
        // Обычное положительное значение цены
        Bun bun = new Bun("white bun", 200);
        assertEquals(200, bun.getPrice(), 0);
    }

    @Test
    public void getPriceZeroTest() {
        // Значение цены равно нулю
        Bun bun = new Bun("white bun", 0);
        assertEquals(0, bun.getPrice(), 0);
    }

    @Test
    public void getPriceNegativeTest() {
        // Значение цены является отрицательным числом
        Bun bun = new Bun("white bun", -200);
        assertEquals(-200, bun.getPrice(), 0);
    }

    @Test
    public void getPriceFractionalTest() {
        // Минимальное положительное значение цены (дробное число)
        Bun bun = new Bun("white bun", 0.01f);
        assertEquals(0.01f, bun.getPrice(), 0);
    }

    @Test
    public void getPriceMaxValueTest() {
        // Максимально возможное положительное значение цены
        Bun bun = new Bun("white bun", Float.MAX_VALUE);
        assertEquals(Float.MAX_VALUE, bun.getPrice(), 0);
    }

    @Test
    public void getNameTrimTest() {
        // Значение названия с пробелами в начале и конце
        Bun bun = new Bun("   white bun   ", 200);
        assertEquals("   white bun   ", bun.getName());
    }

    @Test
    public void getPriceInfinityTest() {
        // Значение цены равно бесконечности
        Bun bun = new Bun("white bun", Float.POSITIVE_INFINITY);
        assertEquals(Float.POSITIVE_INFINITY, bun.getPrice(), 0);
    }

    @Test
    public void getPriceNaNTest() {
        // Значение цены является NaN (не числом)
        Bun bun = new Bun("white bun", Float.NaN);
        assertTrue(Float.isNaN(bun.getPrice()));
    }
}
