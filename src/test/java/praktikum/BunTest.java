package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class BunTest {
    private Bun bun;
    @Before
    public void setUp(){
        bun = new Bun("Вкусная булочка", 150);
    }

    @Test
    public void getName(){
        String expected = "Вкусная булочка";
        String actual = bun.getName();
        Assert.assertEquals("Неверное наименование", expected, actual);
    }
    @Test
    public void getPrice(){
        float expected = 150;
        float actual = bun.getPrice();
        Assert.assertEquals("Неверная цена", expected, actual, 0);
    }
}