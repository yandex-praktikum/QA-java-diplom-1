import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTests {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    private Ingredient ingredient;

    public IngredientTests(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {IngredientType.SAUCE, "Космонез", 7.40f},
                {IngredientType.FILLING, "Джедипеньё", 8.50f}
        };
    }

    @Before
    public void initializeIngredient() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getPriceShouldReturnsIngredientsPrice(){
        Assert.assertEquals("Ошибка! Ожидается цена - " + price, price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameShouldReturnsIngredientName() {
        Assert.assertEquals("Ошибка! Ожидается - " + name, name, ingredient.getName());
    }

    @Test
    public void getTypeShouldReturnsIngredientsType(){
        Assert.assertEquals("Ошибка! Неверный тип ингридиента - " + ingredientType, ingredientType, ingredient.getType());
    }

}
