import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private  String testName;
    private  float testPrice;
    public BunTest(String testName, float testPrice){
        this.testName = testName;
        this.testPrice = testPrice;
    }
    @Parameterized.Parameters
    public static Object[][] getIngredientTestData() {
        return new Object[][]{
                {"testName", new Random().nextFloat()},
                {"", new Random().nextFloat()},
                {null, new Random().nextFloat()},
                {"Тестовое Имя", new Random().nextFloat()},
                {"", new Random().nextFloat()},
                {"1!@#$^&*()_%?", new Random().nextFloat()},
                {"1\n2", new Random().nextFloat()},
                {"          ", new Random().nextFloat()},
                {RandomStringUtils.randomAlphanumeric(1000), new Random().nextFloat()},
                {"testName", -1.0f},
                {"testName", 0},
                {"testName", 4/3},
        };
    }
    @Test
    public void getNameReturnsTrueName(){
        Bun bun = new Bun(testName, testPrice);
        assertEquals(testName,bun.getName());
    }
    @Test
    public void getPriceReturnsTruePrice(){
        Bun bun = new Bun(testName, testPrice);
        assertEquals(testPrice,bun.getPrice(),0);
    }
}
