package practicum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunNameTest {
    float randomPrice = ThreadLocalRandom.current().nextFloat();
    String name;

    public BunNameTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"someName"},
                {""},
                {null},
                {"ThisIsAbsolutelyLongNameForAbsolutelyDeliciousBun"}
        };
    }

    @Test
    public void getNameShouldReturnValidName() {
        Bun bun = new Bun(name, randomPrice);
        assertEquals(name, bun.getName());
    }
}