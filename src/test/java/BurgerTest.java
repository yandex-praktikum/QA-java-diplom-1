import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredientTwo;

    @Test
    public void setBunsSetsBunValue() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Bun actual = this.bun;
        Assert.assertEquals("Не выбрана булка", bun, actual);
    }

    @Test
    public void addIngredientAddsIngredientValue() {
        Burger burger = new Burger();
        Ingredient actual = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(actual);
        Assert.assertEquals("Не добавили ингредиент", burger.ingredients.get(0), actual);
    }

    @Test
    public void removeIngredientRemovesIngredientValue() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        boolean actual = burger.ingredients.isEmpty();
        Assert.assertTrue("Не удалили игредиент", actual);
    }

    @Test
    public void moveIngredientMovesIngredientValue() {
        Burger burger = new Burger();
        ingredient.type = IngredientType.FILLING;
        ingredient.name = "cutlet";
        ingredient.price = 100;
        ingredientTwo.type = IngredientType.SAUCE;
        ingredientTwo.name = "how sauce";
        ingredientTwo.price = 100;
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredientTwo, burger.ingredients.get(0));
    }

}
