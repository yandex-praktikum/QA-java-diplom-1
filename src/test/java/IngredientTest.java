import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType ingredientType;
    private String ingredientName;
    private float ingredientPrice;

    public IngredientTest(IngredientType ingredientType, String ingredientName,
                          float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters(name = "Тип: {0}, Наименование: {1}, Цена: {2}")
    public static Object[][] getDataForm() {
        return new Object[][] {
                {SAUCE, "Вишнёвый соус", 12.5f},
                {FILLING, "Плавленный сыр", 1000.33f},
                {SAUCE, "Что-то с чем-то", -10.44f}
        };
    }

    @Test
    public void getTypeReturnsExpectedValue() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        IngredientType ingredientTypeActual = ingredient.getType();
        assertEquals(ingredientType, ingredientTypeActual);
    }

    @Test
    public void getNameReturnsExpectedValue(){
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        String ingredientNameActual = ingredient.getName();
        assertEquals(ingredientNameActual, ingredientName);
    }

    @Test
    public void getPriceReturnsExpectedValue() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        float ingredientPriceActual = ingredient.getPrice();
        assertEquals(ingredientPriceActual, ingredientPrice);
    }

    @Test
    public void ingredientTypeValueSauce() {
        assertEquals(SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void ingredientTypeValueFilling() {
        assertEquals(FILLING, IngredientType.valueOf("FILLING"));
    }
}
