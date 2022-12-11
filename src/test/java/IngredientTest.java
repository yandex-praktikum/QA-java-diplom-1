import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private IngredientType ingredientType;

    @Test
    public void getNameReturnsValidValue() {
        Ingredient ingredient = new Ingredient(ingredientType, "Лук", 20.0f);
        String expectedResult = "Лук";

        String actualResult = ingredient.getName();

        Assert.assertEquals("А где лук? :с", expectedResult, actualResult);
    }

    @Test
    public void getPriceReturnsValidValue() {
        Ingredient ingredient = new Ingredient(ingredientType, "Кетчунез", 3000.0f);
        float expectedResult = 3000.0f;

        float actualResult = ingredient.getPrice();

        Assert.assertEquals("Неправильная цена :с", expectedResult, actualResult, 0);
    }

    @Test
    public void getTypeReturnsValidValue() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Кетчунез", 3000.0f);
        IngredientType expectedResult = IngredientType.SAUCE;

        IngredientType actualResult = ingredient.getType();

        Assert.assertEquals("Правильный ингредиент", expectedResult, actualResult);
    }

}
