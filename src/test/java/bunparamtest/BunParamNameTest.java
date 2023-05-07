package bunparamtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class BunParamNameTest {
    private final  String expected;
    private final  String name;
    private final float price;
    public  BunParamNameTest(String expected, float price, String name) {
        this.expected = expected;
        this.price = price;
        this.name = name;
    }
    @Parameterized.Parameters
    public static Object[][] checkName() {
        return new Object[][]{
                {"black bun",100,"black bun"},
                {"white bun",200,"white bun"},
                {"red bun",300,"red bun"},
        };
    }
    @Test
    public void checkNameTest() {
        Bun bun = new Bun(name,price);
        String actual = bun.getName();
        assertEquals(expected, actual);
    }
}
