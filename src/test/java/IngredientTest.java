import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Test
    public void testIngredientGetName() {
        String name = "name";
        Ingredient ingredient = new Ingredient(null, name, 0);
        String actual = ingredient.getName();
        String message = "Метод getName вернул некорректное значение: " + actual + ". Ожидаемый результат: " + name;
        Assert.assertEquals(message, name, actual);
    }

    @Test
    public void testIngredientGetPrice() {
        float price = 5.F;
        Ingredient ingredient = new Ingredient(null, "", price);
        float actual = ingredient.getPrice();
        String message = "Метод getPrice вернул некорректное значение: " + actual + ". Ожидаемый результат: " + price;
        Assert.assertEquals(message, price, actual, 0);
    }
}
