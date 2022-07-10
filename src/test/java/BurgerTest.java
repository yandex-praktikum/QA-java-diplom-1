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
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient actual = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.addIngredient(ingredient);
        burger.addIngredient(actual);
        burger.moveIngredient(1, 0);
        Assert.assertEquals("Не переместили игредиент", burger.ingredients.get(0), actual);
    }

}
