package praktikum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


public class IngredientTypeTest {

    @Test
    public void checkValuesAsListTest() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("SAUCE", "FILLING"));
        ArrayList<String> actual = new ArrayList<>();
        for (IngredientType ingredient: IngredientType.values()){
            actual.add(ingredient.name());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void valueOfFirstIngredientTest() {
        assertThat(IngredientType.valueOf("SAUCE"), notNullValue());
    }

    @Test
    public void valueOfSecondIngredientTest() {
        assertThat(IngredientType.valueOf("FILLING"), notNullValue());
    }

}