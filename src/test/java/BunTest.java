import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bunTest = new Bun("Тестовая булка", 50);

    @Test
    public void getNamePositiveTest() {
        Assert.assertEquals("Тестовая булка", bunTest.getName());
    }

    @Test
    public void getNameNegativeTest() {
        Assert.assertNotEquals("Не Тестовая булка", bunTest.getName());
    }

    @Test
    public void getPricePositiveTest() {
        Assert.assertEquals(50.0, bunTest.getPrice(), 0);
    }

    @Test
    public void getPriceNegativeTest() {
        Assert.assertNotEquals(150.0, bunTest.getPrice(), 0);
    }
}
