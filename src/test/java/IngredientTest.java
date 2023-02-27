import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class IngredientTest {

    protected final static String INGREDIENT_NAME = "Сыр с астероидной плесенью";
    protected final static String INGREDIENT_TYPE = "FILLING";
    protected final static float INGREDIENT_PRICE = 4142.0f;
    private Ingredient ingredient;

    @Before
    public void objectPrepare(){
        ingredient = new Ingredient(IngredientType.valueOf(INGREDIENT_TYPE), INGREDIENT_NAME, INGREDIENT_PRICE);
    }

    @Test
    public void checkIngredientName(){
        assertEquals("Неверное наименование ингредиента!", INGREDIENT_NAME, ingredient.getName());
    }

    @Test
    public void checkIngredientPrice(){
        assertThat("Неверная стоимость ингредиента!", ingredient.getPrice(), is(INGREDIENT_PRICE));
    }

    @Test
    public void checkIngredientType(){
        assertEquals("Неверный тип ингредиента!", IngredientType.valueOf(INGREDIENT_TYPE), ingredient.getType());
    }
}
