import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {

        IngredientType ingredientFilling = IngredientType.FILLING;
        String startName = "CosmoBun";
        float startPrice = 15.25f;
        ingredient = new Ingredient(ingredientFilling, startName, startPrice);
    }

    //исхожу из того, что поля сделаны публичными сознательно, в соответсвии с требованиями
    //поэтому проверяю, что измение этих полей приводит к изменниям в объекте
    @Test
    public void checkChangePriceOnValid() {
        float expectedPrice = 10.50f;
        ingredient.price = expectedPrice;
        float actualPrice = ingredient.getPrice();
        assertEquals("Значение поля Price НЕ верное", expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkChangeNameOnValid() {
        String expectedName = "New burger name";
        ingredient.name = expectedName;
        String actualName = ingredient.getName();
        assertEquals("Значение поля Name НЕ верное", expectedName, actualName);
    }

    @Test
    public void checkChangeIngredientType() {
        IngredientType expectedIngredientType = IngredientType.SAUCE;
        ingredient.type = expectedIngredientType;
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals("Значение поля Type НЕ верное", expectedIngredientType, actualIngredientType);
    }

}