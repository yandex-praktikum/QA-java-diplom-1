import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(Parameterized.class)
public class NamePriceExceptionTest {
    private Bun bun;
    private String name;
    private float price;
    Exception exception;
    Ingredient ingredient;

    public NamePriceExceptionTest(String name, float price) {
        this.name = name;
        this.price = price;

    }

    @Parameterized.Parameters (name = "name ={0} price={1}")
    public static Object[][] getTestBunData(){
        return new Object[][] {
                {null, 0.9f},
                {" ", 0.9f},
                {"Bun", -0.9f},
                {"Bun", 0.0001f},
                {"Bun", 0.0f},
                {"Bun", 1000000000.01f},

        };
    }



    @Before
    public void setUp() {
        exception = null;
    }


    @Ignore
@Test
public void testBunException()  {
    try {
        bun = new Bun(name, price);
    } catch (IllegalArgumentException runTimeEx){
        exception = runTimeEx;
    } catch (Exception ex) {
        exception = ex;
    }
    assertNotNull(exception);
}

    @Ignore
    @Test
    public void testIngredientException()  {
        try {
            ingredient = new Ingredient(IngredientType.SAUCE, name, price);
        } catch (IllegalArgumentException runTimeEx){
            exception = runTimeEx;
        } catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
    }

}
