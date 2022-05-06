package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest implements SetUp {
    private Bun bun;
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Override
    @Before
    public void createObject() {
        bun = new Bun(expectedName, expectedPrice);
    }

    @Parameterized.Parameters
    public static Object[][] BunTestData() {
        return new Object[][]{{"T", 100},// заглавная латиница в одну букву +целое число
                {"verymuchsolongnameforbunhowitwork", 100.0f},//длинная латиница без пробелов+дробь с 0
                {"Кириллица", 0.1f},// кириллица+дробное число, десятка в дробной части для округления
                {" ТЕСТ", 2.99f}, //заглавные с пробелом + сотка в дробной части
                {"!@# ", 999999999.999f},//символы+большое число
                {null, 0},//дефолтные значения
                {"Test Name", -0.01f} // пробел в середине+отрицательное число
        };
    }

    @Test
    public void getNameParameterizedParametersGetValue() {
        String actualName = bun.getName();

        Assert.assertEquals("Incorrect name", expectedName, actualName);
    }

    @Test
    public void getPriceParameterizedParametersGetValue() {
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Incorrect price", expectedPrice, actualPrice, 0);
    }

}

