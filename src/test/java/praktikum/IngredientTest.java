package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTest
{
    private static final IngredientType TEST_INGREDIENT_TYPE = IngredientType.SAUCE;
    private static final String TEST_INGREDIENT_NAME = "test ingredient name";
    private static final float TEST_INGREDIENT_PRICE = 42f;

    @Test
    public void ingredientReturnCorrectType()
    {
        Ingredient ingredient = new Ingredient(TEST_INGREDIENT_TYPE, TEST_INGREDIENT_NAME, TEST_INGREDIENT_PRICE);

        assertThat(ingredient.getType(), is(TEST_INGREDIENT_TYPE));
    }

    @Test
    public void ingredientChangeTypeSuccessful()
    {
        IngredientType newIngredientType = IngredientType.FILLING;
        Ingredient ingredient = new Ingredient(TEST_INGREDIENT_TYPE, TEST_INGREDIENT_NAME, TEST_INGREDIENT_PRICE);
        ingredient.type = newIngredientType;

        assertThat(ingredient.getType(), is(newIngredientType));
    }

    @Test
    public void ingredientReturnCorrectName()
    {
        Ingredient ingredient = new Ingredient(TEST_INGREDIENT_TYPE, TEST_INGREDIENT_NAME, TEST_INGREDIENT_PRICE);

        assertThat(ingredient.getName(), is(TEST_INGREDIENT_NAME));
    }

    @Test
    public void ingredientChangeNameSuccessful()
    {
        String newIngredientName = "new ingredient name";
        Ingredient ingredient = new Ingredient(TEST_INGREDIENT_TYPE, TEST_INGREDIENT_NAME, TEST_INGREDIENT_PRICE);
        ingredient.name = newIngredientName;

        assertThat(ingredient.getName(), is(newIngredientName));
    }

    @Test
    public void ingredientReturnCorrectPrice()
    {
        Ingredient ingredient = new Ingredient(TEST_INGREDIENT_TYPE, TEST_INGREDIENT_NAME, TEST_INGREDIENT_PRICE);

        assertThat(ingredient.getPrice(), is(TEST_INGREDIENT_PRICE));
    }

    @Test
    public void ingredientChangePriceSuccessful()
    {
        float newIngredientPrice = 1234f;
        Ingredient ingredient = new Ingredient(TEST_INGREDIENT_TYPE, TEST_INGREDIENT_NAME, TEST_INGREDIENT_PRICE);
        ingredient.price = newIngredientPrice;

        assertThat(ingredient.getPrice(), is(newIngredientPrice));
    }
}
