package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BurgerTests {

    @Test
    public void setBunsTest(){
        Bun bun = new Bun("bun", 1f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Wrong bun", bun, burger.bun);
    }

    @Test
    public void addIngredientTest(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Mayonnaise", 1f);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue("Ingredient don't added", burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Mayonnaise", 1f);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue("Ingredient don't removed", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest(){
        Ingredient mayonnaise = new Ingredient(IngredientType.SAUCE, "Mayonnaise", 1f);
        Ingredient ketchup = new Ingredient(IngredientType.FILLING, "Ketchup", 2f);
        Burger burger = new Burger();
        burger.addIngredient(mayonnaise);
        burger.addIngredient(ketchup);
        burger.moveIngredient(1, 0);
        assertEquals("Mayonnaise don't moved", mayonnaise, burger.ingredients.get(1));
        assertEquals("Ketchup don't moved", ketchup, burger.ingredients.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void priceIsNullTest() {
        Burger burger = new Burger();
        burger.getPrice();
    }

    @Test(expected = NullPointerException.class)
    public void receiptIsNullTest() {
        Burger burger = new Burger();
        burger.getReceipt();
    }
}
