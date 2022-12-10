package praktikum;

import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static praktikum.Generator.BUN_TEST_NAME;
import static praktikum.Generator.BUN_TEST_PRICE;


@RunWith(JUnitParamsRunner.class)
public class BunTest {

    Bun bunTest;

    @Before
    public void setUp(){
        bunTest = Generator.getDefaultBun();
    }

    @Test
    public void getNameReturnsValidValue() {
        Assert.assertEquals("Некорректное возвращаемое имя", BUN_TEST_NAME, bunTest.getName());
    }

    @Test
    public void getPriceReturnsValidValue() {
        Assert.assertEquals("Некорректная возвращаемая цена", BUN_TEST_PRICE, bunTest.getPrice(), 0.0);
    }
}