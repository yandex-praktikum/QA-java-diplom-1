package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTestGetNameParameterizedTest {

    private final float price = 100;
    private final String name;

    public BunTestGetNameParameterizedTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Булочка с кунжутом>"},
                {""},
                {null}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals("Название не совпадает с ожидаемым значением", name, actualName);
    }
}
