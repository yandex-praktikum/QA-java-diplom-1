package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BurgerTest {

    // Данные для заполнения
    Bun bun1 = new Bun("Бутер 2", 10.00f);
    Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Томатный", 5.00f);
    Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Салатище", 10.00f);
    Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "Помидорище", 15.00f);
    float expectedPrice = bun1.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice() + ingredient3.getPrice();
    String expectedReceipt =
            "(==== Бутер 2 ====)\r\n" +
            "= sauce Томатный =\r\n" +
            "= sauce Салатище =\r\n" +
            "= sauce Помидорище =\r\n" +
            "(==== Бутер 2 ====)\r\n" +
            "\r\n" +
            "Price: 50,000000" +
            "\r\n";


    @Test
    public void setNewBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun1);
        Bun expected = new Bun("Бутер 2", 10.00f);
        assertEquals(expected.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientInBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        assertEquals(burger.ingredients.get(0).getName(), "Томатный");
    }

    @Test
    public void removeIngredientInBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.isEmpty(),true);
    }

    @Test
    public void moveIngredientsInList() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(0, 2);
        assertEquals(burger.ingredients.get(0).getName(),"Салатище");
    }

    @Test
    public void getBurgerTotalPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun1);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(expectedPrice, burger.getPrice(), 0.00);
    }

    @Test
    public void getBurgerReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun1);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(expectedReceipt, burger.getReceipt());
    }

}