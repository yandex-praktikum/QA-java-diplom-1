import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameReturnsValidValue() {
        Bun bun = new Bun("Мягкая булка", 30);
        String expectedResult = "Мягкая булка";

        String actualResult = bun.getName();

        Assert.assertEquals("Почему не мягкая булка :с", expectedResult, actualResult);
    }

    @Test
    public void getPriceReturnsValidValue() {
        Bun bun = new Bun("Мягкая булка", 30);
        float expectedResult = 30;

        float actualResult = bun.getPrice();

        Assert.assertEquals("Неверная цена", expectedResult, actualResult, 0);
    }
}
