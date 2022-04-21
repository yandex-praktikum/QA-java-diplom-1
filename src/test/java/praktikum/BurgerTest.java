package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

public class BurgerTest {

    @Test
    public void methodSetBunsShouldSetBun() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();
        Burger burger = new Burger();
        Bun bun = new Bun(name, price);

        burger.setBuns(bun);

        Assert.assertEquals("Method setBuns set the wrong value to the field bun", bun, burger.bun);
    }

    @Test
    public void methodAddIngredientShouldAddElementInList() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

        burger.addIngredient(ingredient);

        Assert.assertEquals("Method addIngredient do not add ingredient in List", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void methodRemoveIngredientShouldRemoveElementInList() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertEquals("Method removeIngredient do not remove ingredient in List", 0, burger.ingredients.size());
    }

    @Test
    public void methodMoveIngredientShouldMoveElementInList() {
        String name0 = RandomStringUtils.randomAlphabetic(10);
        float price0 = nextFloat();
        String name1 = RandomStringUtils.randomAlphabetic(10);
        float price1 = nextFloat();

        Burger burger = new Burger();

        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, name0, price0);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, name1, price1);

        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);

        burger.moveIngredient(1, 0);

        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
        Assert.assertEquals(ingredient0, burger.ingredients.get(1));
    }
}
