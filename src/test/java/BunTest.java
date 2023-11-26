import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                {"Harry's", 100f},
                {"Росбулка", 60f},
        };
    }

    @Test
    public void nameTest() {
        //Arrange
        Bun bun = new Bun(name, price);

        //Act
        String actual = bun.getName();

        //Assert
        Assert.assertEquals("Имя не соответствует", name, actual);
    }

    @Test
    public void priceTest() {
        //Arrange
        Bun bun = new Bun(name,price);

        //Act
        float actual = bun.getPrice();

        //Assert
        Assert.assertEquals("Цена не соответствует", price, actual, 0f);
    }
}
