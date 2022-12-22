import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class IngredientTest {

    private Ingredient ingredient;
    private String nameIngredient = "Ingredient";
    private float priceIngredient = 300.00f;

    @Before
    public void createIngredient() {
        ingredient = new Ingredient(IngredientType.SAUCE, nameIngredient, priceIngredient);
    }

    // Проверка метода назначенной цены ингредиента
    @Test
    public void getPriceTest() {
        float expected = 300.00f;
        float actual = ingredient.getPrice();
        float delta = 0.00f;
        Assert.assertEquals("Отклонение в стоимости ",expected, actual, delta);
    }

    // Проверка метода названия ингредиента
    @Test
    public void getNameTest() throws Exception {
        String expected = "Ingredient";
        String actual = ingredient.getName();
        Assert.assertEquals("Неправильное название ингридиента ",expected, actual);
    }

    // Проверка метода типа ингредиента
    @Test
    public void getTypeTest() throws Exception {
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("Не соус ", expected, actual);
    }

}
