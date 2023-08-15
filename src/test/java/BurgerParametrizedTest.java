import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {
    private static int bun;
    private static int filling;
    private static int sauce;
    private static float expectedPrice;
    private final String expectedReceipt;
    private static String expectedReceipt1 = "(==== black bun ====)\r\n" +
            "= sauce sour cream =\r\n" +
            "= filling cutlet =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 500,000000\r\n";
    private static String expectedReceipt2 = "(==== white bun ====)\r\n" +
            "= sauce chili sauce =\r\n" +
            "= filling dinosaur =\r\n" +
            "(==== white bun ====)\r\n" +
            "\r\n" +
            "Price: 900,000000\r\n";
    private static String expectedReceipt3 = "(==== red bun ====)\r\n" +
            "= sauce hot sauce =\r\n" +
            "= filling sausage =\r\n" +
            "(==== red bun ====)\r\n" +
            "\r\n" +
            "Price: 1000,000000\r\n";
    private static String expectedReceipt4 = "(==== black bun ====)\r\n" +
            "= sauce hot sauce =\r\n" +
            "= filling cutlet =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 400,000000\r\n";
    private static String expectedReceipt5 = "(==== white bun ====)\r\n" +
            "= sauce sour cream =\r\n" +
            "= filling dinosaur =\r\n" +
            "(==== white bun ====)\r\n" +
            "\r\n" +
            "Price: 800,000000\r\n";
    private static String expectedReceipt6 = "(==== red bun ====)\r\n" +
            "= sauce chili sauce =\r\n" +
            "= filling sausage =\r\n" +
            "(==== red bun ====)\r\n" +
            "\r\n" +
            "Price: 1200,000000\r\n";


    public BurgerParametrizedTest(int bun, int filling, int sauce, float expectedPrice,String expectedReceipt) {
        this.bun = bun;
        this.filling = filling;
        this.sauce = sauce;
        this.expectedPrice = expectedPrice;
        this.expectedReceipt = expectedReceipt;

    }

    @Parameterized.Parameters
    public static Object[] createNewBurger() {
        return new Object[][]{
                {0, 1, 3,500.0f,expectedReceipt1},
                {1, 2, 4,900.0f,expectedReceipt2},
                {2, 0, 5,1000.0f,expectedReceipt3},
                {0, 0, 3,400.0f,expectedReceipt4},
                {1, 1, 4,800.0f,expectedReceipt5},
                {2, 2, 5,1200.0f,expectedReceipt6}
        };
    }

    @Test
    public void getPrice() {
        Burger burger = TestUtils.createPlainBurger(bun,filling,sauce);
        float actualPrice = burger.getPrice();
        assertEquals(actualPrice,expectedPrice,0);
    }

    @Test
    public void getReceipt(){
        Burger burger = TestUtils.createPlainBurger(bun,filling,sauce);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
