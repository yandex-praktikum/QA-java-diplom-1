package praktikum;

import org.junit.Assert;
import org.junit.Test;


public class TestBurgerSettings {
    private Database data = new Database();
    Burger burger = new Burger();

    @Test
    public void testSetBuns() {
        Bun bun = data.availableBuns().get(0);
        burger.setBuns(bun);

        Assert.assertEquals(bun.name, burger.bun.name);
        Assert.assertEquals(bun.price, burger.bun.price, 0.05);
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = data.availableIngredients().get(1);
        burger.addIngredient(ingredient);

        Assert.assertEquals(ingredient.getType(), burger.ingredients.get(0).type);
        Assert.assertEquals(ingredient.getName(), burger.ingredients.get(0).name);
        Assert.assertEquals(ingredient.getPrice(), burger.ingredients.get(0).price, 0.05);

    }

    @Test
    public void testRemoveIngredient() {
        for (Ingredient ingredient : data.availableIngredients()){
            burger.addIngredient(ingredient);
        }
        burger.removeIngredient(0);

        Assert.assertEquals(data.availableIngredients().get(1).getType(), burger.ingredients.get(0).type);
        Assert.assertEquals(data.availableIngredients().get(1).getName(), burger.ingredients.get(0).name);
        Assert.assertEquals(data.availableIngredients().get(1).getPrice(), burger.ingredients.get(0).price, 0.05);

    }

    @Test
    public void testMoveIngredient() {
        for (Ingredient ingredient : data.availableIngredients()){
            burger.addIngredient(ingredient);
        }
        burger.moveIngredient(1, 0);

        Assert.assertEquals(data.availableIngredients().get(1).getType(), burger.ingredients.get(0).type);
        Assert.assertEquals(data.availableIngredients().get(1).getName(), burger.ingredients.get(0).name);
        Assert.assertEquals(data.availableIngredients().get(1).getPrice(), burger.ingredients.get(0).price, 0.05);

    }

}
