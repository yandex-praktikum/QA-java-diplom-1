package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.testng.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {


    private final String nameBun;
    private final String expectedNameBun;

    public BunTest(String nameBun, String expectedNameBun) {
        this.nameBun = nameBun;
        this.expectedNameBun = expectedNameBun;
    }

    @Parameterized.Parameters
    public static Object[][] nameParam() {
        return new Object[][] {
                {"Праздничная булка", "Праздничная булка"},
                {"Chicken 12", "Chicken 12"},
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(nameBun, 1000);
        String actual = bun.getName();
        assertEquals(expectedNameBun, actual);
    }

}
