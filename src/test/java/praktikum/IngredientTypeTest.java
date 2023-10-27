package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;


public class IngredientTypeTest {

    @Test
    public void checkFillingIsNotEmpty() {
        Assert.assertThat("Filling is empty!", IngredientType.FILLING, is(notNullValue()));
    }

    @Test
    public void checkSauceIsNotEmpty() {
        Assert.assertThat("Sauce is empty!", IngredientType.SAUCE, is(notNullValue()));
    }
}