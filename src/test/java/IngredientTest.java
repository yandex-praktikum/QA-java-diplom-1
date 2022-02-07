
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {
        private final IngredientType ingredientType;

    public IngredientTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypeData() {
        return new Object[][] {
                {IngredientType.FILLING},
                {IngredientType.SAUCE},
        };
    }

    @Test
    public void ingredientCreatedTest(){
        Ingredient ingredient = new Ingredient(ingredientType, "рандомная начинка", 40.0F );
        assertNotNull(ingredient);
    }

    @Test
    public void getIngredientNameTest(){
        Ingredient ingredient = new Ingredient(ingredientType, "рандомная начинка", 40.0F );
        assertEquals("рандомная начинка", ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(ingredientType, "рандомная начинка", 40.0F );
        assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void getIngredientPriceTest(){
        Ingredient ingredient = new Ingredient(ingredientType, "рандомная начинка", 40.0F );
        assertTrue(40.0F == ingredient.getPrice());
    }
}

