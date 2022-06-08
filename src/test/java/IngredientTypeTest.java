import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private String ingredientName;
    float ingredientPrice;
    private IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {praktikum.IngredientType.FILLING, "Сыр", (float) 3},
                {praktikum.IngredientType.FILLING, "Томат", (float) 5},
                {praktikum.IngredientType.SAUCE, "Кетчуп", (float) 25}
        };
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        float priceActual = ingredient.getPrice();
        String message = "Не удалось получить цену ингредиента";
        assertEquals(message, ingredientPrice, priceActual, 0.01);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        praktikum.IngredientType ingredientTypeActual = ingredient.getType();
        String message = "Не удалось получить вид ингредиента";
        assertEquals(message, ingredientType, ingredientTypeActual);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        String ingredientNameActual = ingredient.getName();
        String message = "Не удалось получить название ингредиента";
        assertEquals(message, ingredientName, ingredientNameActual);
    }
}