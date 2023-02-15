import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Burger;
import praktikum.Ingredient;



public class BurgerTest {
    @Mock
    private Ingredient ingredient;
    private Ingredient secondIngredient;

    @Test
    public void addIngredientShouldAddNewIngredient() {
        Burger burger = new Burger();
        Assert.assertEquals(0, burger.ingredients.size());
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientShouldRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());

    }

    @Test
    public void moveIngredientShouldMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertEquals(secondIngredient, burger.ingredients.get(1));
        burger.moveIngredient(1, 0);
        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertEquals(secondIngredient, burger.ingredients.get(0));
    }
}

