import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTestPrice {
    private final IngredientType type;
    private final String name;
    private final float price;
    private final String errorMessage;

    public IngredientTestPrice(IngredientType type , String name, float price, String errorMessage) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.errorMessage = errorMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100, "Некорректная цена для ингредиента SAUCE hot sauce"},
                {SAUCE, "hot sauce", 100.5F, "Некорректная цена с точкой для ингредиента SAUCE hot sauce"},
                {FILLING, "cutlet", 100.5F, "Некорректная цена с точкой для ингредиента FILLING"},
                {FILLING, "cutlet", 0, "Некорректная цена со значением 0 для ингредиента FILLING"}
        };
    }

    @Test
    public void testSuccessGetForIngredient() {
       Ingredient ingredient = new Ingredient(type, name, price);
       assertEquals(errorMessage, ingredient.getPrice(), price, 0);

    }

}
