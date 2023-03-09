package praktikum.BunTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("Чёрствая", 5f);
    @Test
    public void getNamePositiveResult() {
        assertEquals("Не та булочка","Чёрствая",bun.getName());
    }

    @Test
    public void getPricePositiveResultReturn5f() {
        Assert.assertEquals("Некорректная цена",5f,bun.getPrice(),0);
    }
}