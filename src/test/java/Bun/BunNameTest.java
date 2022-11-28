package Bun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunNameTest {

    private final String nameBun;
    private final String expected;

    public BunNameTest(String name, String expected) {
        this.nameBun = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] nameParam() {
        return new Object[][] {
                {"new", "new"},
                {"white", "white"},
                {"ржаная", "ржаная"}
        };
    }

    @Test
    public void getBunName() {
        Bun bun = new Bun(nameBun, 10);
        String actual = bun.getName();
        assertEquals("Данные не совпадают", expected, actual);
    }
}
