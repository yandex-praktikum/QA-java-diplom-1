package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    // Данные для заполнения
    Bun bun1 = new Bun("Бутер 2", 10.00f);
    Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Томатный", 5.00f);
    Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Салатище", 10.00f);
    Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "Помидорище", 15.00f);
    float expectedPrice = bun1.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice() + ingredient3.getPrice();


    @Mock
    Burger burger;

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
        burger.getReceipt();
        Mockito.verify(burger).getReceipt();
    }

}