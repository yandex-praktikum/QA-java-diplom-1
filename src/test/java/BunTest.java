import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import org.apache.commons.lang3.RandomStringUtils;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun bun;

    @Test
    public void validNameGetBunTest() {
        String name = "Пшеничная";
        Bun bun = new Bun(name, 0);
        assertEquals("Названия должны быть равны", name, bun.getName());
    }

    @Test
    public void validEmptyNameGetBunTest() {
        String name = "";
        Bun bun = new Bun(name, 0);
        assertEquals("Названия должны быть равны",name, bun.getName());
    }
    @Test
    public void validNullNameGetBunTest() {
        String name = null;
        Bun bun = new Bun(name, 0);
        assertEquals("Названия должны быть равны",name, bun.getName());
    }
    @Test
    public void validLongStringNameGetBunTest() {
        String name =  RandomStringUtils.randomAlphabetic(25);
        Bun bun = new Bun(name, 0);
        assertEquals("Названия должны быть равны",name, bun.getName());
    }
    @Test
    public void validStringWithSymbolsNameGetBunTest() {
        String name =  "Bun!@#$%^&*()_+=";
        Bun bun = new Bun(name, 0);
        assertEquals("Названия должны быть равны",name, bun.getName());
    }

    @Test
    public void validPriceGetBunTest() {
        float price = 2.99f;
        Bun bun = new Bun("name", price);
        assertEquals("Цена должна быть равна", price, bun.getPrice(), 0);
    }
    @Test
    public void validZeroGetBunTest() {
        float price = 0;
        Bun bun = new Bun("name", price);
        assertEquals("Цена должна быть равна", price, bun.getPrice(), 0);
    }
    @Test
    public void validMinPriceGetBunTest() {
        float price = Float.MIN_VALUE;
        Bun bun = new Bun("name", price);
        assertEquals("Цена должна быть равна", price, bun.getPrice(), 0);
    }
    @Test
    public void validMaxPriceGetBunTest() {
        float price = Float.MAX_VALUE;
        Bun bun = new Bun("name", price);
        assertEquals("Цена должна быть равна", price, bun.getPrice(), 0);
    }
    @Test
    public void validNanPriceGetBunTest() {
        float price = Float.NaN;
        Bun bun = new Bun("name", price);
        assertEquals("Цена должна быть равна", price, bun.getPrice(), 0);
    }
}
