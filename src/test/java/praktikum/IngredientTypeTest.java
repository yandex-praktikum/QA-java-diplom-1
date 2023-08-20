package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class IngredientTypeTest {

    @Test
    public void testSauce(){
        MatcherAssert.assertThat("Я не твой любимый кетчунезик = (", IngredientType.SAUCE, is (IngredientType.valueOf("SAUCE")));
    }

    @Test
    public void testFilling(){
        MatcherAssert.assertThat("Я не твоя любимая котлетка -_-", IngredientType.FILLING, is (IngredientType.valueOf("FILLING")));
    }

}