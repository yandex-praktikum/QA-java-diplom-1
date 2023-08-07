import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;

import java.util.List;

public class BurgerTest {
    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        Ingredient filling = new Ingredient(IngredientType.FILLING,"hot sauce", 100);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "cutlet", 100);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        List<Ingredient> ingredient = new ArrayList<>();
        ingredient.add(filling);
        ingredient.add(sauce);
        Assert.assertEquals(burger.ingredients,ingredient);
    }
    @Test
    public void getPriceTest(){
        Bun bun= new Bun("red bun", 300);
        Ingredient filling= new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient sauce = new Ingredient(IngredientType.FILLING, "sausage", 300);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.getPrice();
        Assert.assertEquals(burger.getPrice(), 1200, 1);
    }
    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient filling = new Ingredient(IngredientType.FILLING,"hot sauce", 100);
        burger.addIngredient(filling);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient filling = new Ingredient(IngredientType.FILLING,"hot sauce", 100);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "cutlet", 100);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        List<Ingredient> ingredient = new ArrayList<>();
        ingredient.add(sauce);
        ingredient.add(filling);
        burger.moveIngredient(0,1);
        Assert.assertEquals(burger.ingredients,ingredient);
    }
    @Test
   public void getReceiptTest(){
        Bun bun= new Bun("red bun", 300);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient filling = new Ingredient(IngredientType.FILLING,"cutlet", 100);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        String newGetReceipt = "(==== red bun ====)\n" +
                "= sauce hot sauce =\n" +
                "= filling cutlet =\n" +
                "(==== red bun ====)\n" +
                "\n" +
                "Price: 800,000000"+ "\n" ;
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(newGetReceipt.replace("\r\n", "\n"),actualReceipt.replace("\r\n", "\n"));
    }
}

