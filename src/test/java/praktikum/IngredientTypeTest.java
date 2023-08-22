package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static praktikum.IngredientType.*;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeTest() {
        MatcherAssert.assertThat("Это начинка", IngredientType.FILLING, equalTo(FILLING));
        MatcherAssert.assertThat("Это соус", IngredientType.SAUCE, equalTo(SAUCE));
    }
}
