import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest extends BaseTest {
    private final IngredientType INGREDIENT_TYPE;
    private final String INGREDIENT_NAME ;
    private final float INGREDIENT_PRICE;

    public IngredientTest(IngredientType INGREDIENT_TYPE, String INGREDIENT_NAME, float INGREDIENT_PRICE) {
        this.INGREDIENT_TYPE = INGREDIENT_TYPE;
        this.INGREDIENT_NAME = INGREDIENT_NAME;
        this.INGREDIENT_PRICE = INGREDIENT_PRICE;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337},
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88},
        };
    }

    @Test
    public void getIngredientType() {
        ingredient = new Ingredient(INGREDIENT_TYPE, INGREDIENT_NAME, INGREDIENT_PRICE);
        assertEquals(INGREDIENT_TYPE, ingredient.getType());
    }

    @Test
    public void getIngredientName() {
        ingredient = new Ingredient(INGREDIENT_TYPE, INGREDIENT_NAME, INGREDIENT_PRICE);
        assertEquals(INGREDIENT_NAME, ingredient.getName());
    }

    @Test
    public void getIngredientPrice() {
        ingredient = new Ingredient(INGREDIENT_TYPE, INGREDIENT_NAME, INGREDIENT_PRICE);
        assertEquals(INGREDIENT_PRICE, ingredient.getPrice(), 0);
    }
}
