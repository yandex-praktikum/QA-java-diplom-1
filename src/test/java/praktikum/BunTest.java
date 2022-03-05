package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    String expectedName;
    float expectedPrice;
    Bun bun;

    // Метод для параметризации
    public BunTest (Bun bun,String expectedName, float expectedPrice) {
        this.bun = bun;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;

    }

    // Параметризация условий авторизации
    @Parameterized.Parameters
    public static Object[][] getTestData () {
        return new Object[][] {
                {new Bun("Тест", 123), "Тест", 123},
                {new Bun("test", 1.323f), "test", 1.323f},
                {new Bun("", -1.32f), "", -1.32f},
                {new Bun("test", 0), "test", 0},

        };
    }

    @Test
    public void getValue() {

        String actualName = bun.getName();
        float actualPrice = bun.getPrice();

        assertEquals("The name is not correct",expectedName,actualName);
        assertEquals("The price is not correct",expectedPrice,actualPrice,0);
    }
}
