package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CreateBurgerTest {
    Burger burger;
    String bunName;
    float bunPrice;
    IngredientType ingredientType;
    String ingredientName;
    float ingredientPrice;
    float totalPrice;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"black bun", 100, IngredientType.FILLING, "sausage", 50, 250},
                {"white bun", 200, IngredientType.SAUCE, "chili sauce", 25, 425},
                {"red bun", 230, IngredientType.SAUCE, "hot sauce", 20, 480},
        };
    }

    public CreateBurgerTest(String bunName, float bunPrice, IngredientType ingredientType,
                            String ingredientName, float ingredientPrice, float totalPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.totalPrice = totalPrice;
        this.burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(new Bun(bunName, bunPrice));
        assertTrue("Ошибка! Добавлена неверная булка", burger.getReceipt().contains(bunName));
    }

    @Test
    public void addIngredientTest() {
        burger.setBuns(new Bun(bunName, bunPrice));
        burger.addIngredient(new Ingredient(ingredientType, ingredientName, ingredientPrice));
        assertEquals("Ошибка! Неверная стоимость", totalPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        burger.setBuns(new Bun(bunName, bunPrice));
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse("В рецепте бургера есть удаленный ингредиент", burger.ingredients.contains(ingredient));
    }
}
