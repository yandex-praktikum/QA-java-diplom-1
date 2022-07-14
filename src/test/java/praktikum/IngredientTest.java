package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTest {

    @Mock
    IngredientType ingredientType;

    private Ingredient ingredient;
    private String expectedName;
    public float expectedPrice;

    @Before
    public void setUp(){
        expectedName = "Коля";
        expectedPrice = 500;
        ingredient = new Ingredient(ingredientType, expectedName, expectedPrice);
    }

    @Test
    public void getPrice() {
        float actualPrice = ingredient.getPrice();
        assertThat(expectedPrice, equalTo(actualPrice));
    }

    @Test
    public void getName() {
        String actualName = ingredient.getName();
        assertThat(expectedName, equalTo(actualName));
    }

    @Test
    public void getType() {
        assertThat(ingredientType, equalTo(ingredientType));
    }
}