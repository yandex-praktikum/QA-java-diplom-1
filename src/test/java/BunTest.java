import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String expextedName;
    private final float expectedPrice;

    public BunTest(String expextedName, float expectedPrice) {
        this.expextedName = expextedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Стоимость булочки. Тестовые данные: {0} {1}")
    public static Object[][] getBunData() {
        return new Object[][]{{"Классическая", -1}, {"Super", 1}, {"", 0}, {"@#$", -23}, {"             ", 99999}, {"24242", -99999}, {"Сааааамаааая длинннннннная бУУУУУлука", 23},};
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(expextedName, 100);
        Assert.assertEquals(expextedName, bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        Bun bun = new Bun("Жгучая булочка", expectedPrice);
        Assert.assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
