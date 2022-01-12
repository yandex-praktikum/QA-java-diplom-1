package praktikum;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class BurgerTest {

    @Test
    public void setBuns() {
        Bun bun = new Bun("test", 14);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun.getName(), bun.name);
        Assert.assertEquals(burger.bun.getPrice(), bun.price, 0);
    }

    @Test
    public void addIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"test", 17);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.get(0).getType(), ingredient.type);
        Assert.assertEquals(burger.ingredients.get(0).getName(), ingredient.name);
        Assert.assertEquals(burger.ingredients.get(0).getPrice(), ingredient.price,0);
    }

    @Test
    public void removeIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"test", 17);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.get(0).getType(), ingredient.type);
        Assert.assertEquals(burger.ingredients.get(0).getName(), ingredient.name);
        Assert.assertEquals(burger.ingredients.get(0).getPrice(), ingredient.price,0);
        burger.removeIngredient(0);
        Assert.assertEquals(burger.ingredients, new ArrayList<>());
    }

    @Test
    public void moveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE,"test1", 17);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING,"test2", 34);
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(burger.ingredients.get(0).getType(), ingredient2.type);
        Assert.assertEquals(burger.ingredients.get(0).getName(), ingredient2.name);
        Assert.assertEquals(burger.ingredients.get(0).getPrice(), ingredient2.price, 0);
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("test", 14);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE,"test1", 17);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING,"test2", 34);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(burger.getPrice(), 79, 0);
    }

    @Test
    public void getReceipt() {
        Bun bun = new Bun("test", 14);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE,"test1", 17);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING,"test2", 34);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.getReceipt();
        Assert.assertEquals(burger.getReceipt(),"(==== test ====)\r\n" +
                "= sauce test1 =\r\n" +
                "= filling test2 =\r\n" +
                "(==== test ====)\r\n" +
                "\r\n" +
                "Price: 79,000000\r\n");
    }

}