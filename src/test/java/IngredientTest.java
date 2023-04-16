import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.FILLING, "cutlet", 100f},
                {IngredientType.FILLING, "dinosaur", 200f},
                {IngredientType.FILLING, "sausage", 300f},
                {IngredientType.SAUCE, "hot sauce", 100f},
                {IngredientType.SAUCE, "sour cream", 200f},
                {IngredientType.SAUCE, "chili sauce", 300f},
        };
    }

    @Test
    public void getCorrectTypeIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType ingredientType = ingredient.getType();
        assertEquals("Метод вернул некорректный тип ингредиента", type, ingredientType);
    }

    @Test
    public void getCorrectNameIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String ingredientName = ingredient.getName();
        assertEquals("Метод вернул некорректное название ингредиента", name, ingredientName);
    }

    @Test
    public void getCorrectPriceIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float ingredientPrice = ingredient.getPrice();
        assertEquals("Метод вернул некорректную цена ингредиента", price, ingredientPrice);
    }
}
