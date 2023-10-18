package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String ingredientType;


    @Parameterized.Parameters
    public static Object[][] getTestData() {

        return new Object[][]{
                {
                        "SAUCE"
                },
                {
                        "FILLING",
                }
        };
    }

    public IngredientTypeTest(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Test
    public void ingredientTypeValueSuccess() {
        assertThat(IngredientType.valueOf(this.ingredientType), is(notNullValue()));
    }

}


