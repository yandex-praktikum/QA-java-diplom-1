package praktikum.ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTests {
    private final IngredientType testIngredientType;

    public IngredientTests(IngredientType testIngredientType) {
        this.testIngredientType = testIngredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeParameters() {
        return new Object[][]{
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient testIngredient = new Ingredient(testIngredientType, "Szechuan Sauce", 420);
        assertEquals("Указать тип ингредиента не удалось", testIngredientType, testIngredient.getType());
    }

    @Test
    public void ingredientGetPriceTest() {
        float price = 420;
        Ingredient testIngredient = new Ingredient(SAUCE, "Szechuan Sauce", price);
        assertEquals("Задать цену ингредиента не удалось", price, testIngredient.getPrice(), 0);
    }

    @Test
    public void ingredientGetNameTest() {
        String name = "Szechuan Sauce";
        Ingredient testIngredient = new Ingredient(SAUCE, name, 420);
        assertEquals("Задать имя ингредиента не удалось", name, testIngredient.getName());
    }
}


