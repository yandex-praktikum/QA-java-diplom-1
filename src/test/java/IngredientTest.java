import org.junit.Test;
import praktikum.*;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    IngredientType ingredientType;

    @Test
    public void getPriceTest() {

        Ingredient in = new Ingredient(ingredientType.SAUCE, "Колбаса", 12);
        int actualPrice = (int) in.getPrice();
        int expectedPrice = 12;

        assertEquals("Цена не совпадает",  expectedPrice, actualPrice);
    }

    @Test
    public void getNameTest() {

        Ingredient in = new Ingredient(ingredientType.SAUCE, "Колбаса", 12);
        String actualName = in.getName();
        String expectedName = "Колбаса";

        assertEquals("Название ингредиента не совпадает",  expectedName, actualName);

    }

    @Test
    public void getTypeTest() {

        Ingredient in = new Ingredient(ingredientType.SAUCE, "Колбаса", 12);
        String actualType = in.getType().name();
        String expectedType = "SAUCE";

        assertEquals("Тип ингредиента не совпадает", expectedType, actualType);

    }

}
