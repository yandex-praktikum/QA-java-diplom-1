package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String bunName;
    private final float price;

    public BunParameterizedTest(String bunName, float price) {
        this.bunName = bunName;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] parameters() {
        return new Object[][]{
                {" ", 300},
                {null, 400},
                {"СупервВкуснаяБулкаСдобнаяИНеОченьСладкаяИСоленаяХрустящаяИМягкаяСКунжутомИБезКунжутаПокупайИЕшь", 400},
                {"$$верхБулk!a", 300},
                {"ВкуснаяБулка", -300},
                {"Круглая", 0},
                {"Овальная", Float.MIN_VALUE},
                {"Треугольная", Float.MAX_VALUE},
        };
    }

    @Test
    public void testBunNameTest() {
        Bun bun = new Bun(bunName,price);
        assertEquals(bunName,bun.getName());
    }

    @Test
    public void testBunPriceTest() {
        Bun bun = new Bun(bunName,price);
        assertEquals(price,bun.getPrice(),0);
    }
}
