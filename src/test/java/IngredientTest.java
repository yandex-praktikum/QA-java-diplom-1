import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class IngredientTest {

    @Test
    public void getNameReturnIngredientName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 1);
        String expectedName = "name";
        String actualName = ingredient.getName();
        assertEquals ("Неверное имя", expectedName, actualName);
    }

    @Test
    public void getPriceReturnIngredientPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 1);
        float expectedPrice = 1;
        float actualPrice = ingredient.getPrice();
        assertEquals("Неверная цена", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getPriceReturnIngredientType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 1);
        IngredientType expectedType = IngredientType.SAUCE;
        IngredientType actualType = ingredient.getType();
        assertEquals("Неверный тип", expectedType, actualType);
    }
}