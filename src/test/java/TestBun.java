import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class TestBun {
    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;

    public TestBun(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {"testName", 123, "testName", 123},
                {"test!@#$^&*()_%", 123.25f, "test!@#$^&*()_%", 123.25f},
                {" ", -123, " ", -123},
                {null, 0, null, 0},
                {"very very very very very very very very very very very very very very very very long name",
                        Float.POSITIVE_INFINITY,
                        "very very very very very very very very very very very very very very very very long name",
                        Float.POSITIVE_INFINITY
                },
                {"testName", Float.NEGATIVE_INFINITY, "testName", Float.NEGATIVE_INFINITY}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice);
    }
}
