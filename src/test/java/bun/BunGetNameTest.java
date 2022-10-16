package bun;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunGetNameTest {

    private final String name;
    float price = 100;

    public BunGetNameTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] getDataOfBun() {
        return new Object[][]{
                {"normal name"},
                {null},
                {"@$#"},
                {"      "},
                {""},
                {"really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string "},
                {"русский текст"},

        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }
}
