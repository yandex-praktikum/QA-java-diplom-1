import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    Bun bun;
    @Mock
    Ingredient cheese;
    @Mock
    Ingredient bacon;
    @Mock
    Ingredient garlicSauce;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        Bun bun_rye = new Bun("Ржаная", 140.54f);
        burger.setBuns(bun_rye);
        assertEquals(bun_rye, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(bacon);
        assertTrue(burger.ingredients.contains(bacon));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient cheese = new Ingredient(FILLING, "CHEESE", 33.45f);
        Ingredient bacon = new Ingredient(FILLING, "BACON", 54.4f);
        Ingredient garlicSauce = new Ingredient(SAUCE, "GARLIC SAUCE", 12);

        burger.addIngredient(cheese);
        burger.addIngredient(bacon);
        burger.addIngredient(garlicSauce);

        burger.removeIngredient(1);
        assertFalse(burger.ingredients.contains(bacon));
    }
    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient cheese = new Ingredient(FILLING, "CHEESE", 33.45f);
        Ingredient bacon = new Ingredient(FILLING, "BACON", 54.4f);
        Ingredient garlicSauce = new Ingredient(SAUCE, "GARLIC SAUCE", 12);

        burger.addIngredient(cheese);
        burger.addIngredient(bacon);
        burger.addIngredient(garlicSauce);
        burger.moveIngredient(1, 0);
        assertEquals(burger.ingredients.get(0), bacon);
    }

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(bacon);
        burger.addIngredient(cheese);
        burger.addIngredient(garlicSauce);

        when(bun.getPrice()).thenReturn(988f);
        when(cheese.getPrice()).thenReturn(33.4f);
        when(bacon.getPrice()).thenReturn(54.6f);
        when(garlicSauce.getPrice()).thenReturn(12f);

        float ingredientsSum = bun.getPrice()*2 + bacon.getPrice() + cheese.getPrice() + garlicSauce.getPrice();
        assertEquals(burger.getPrice(), ingredientsSum, 0);
    }
    @Test
    public void getReceiptTest() {
        Bun bun_sesame = new Bun ("Кунжутная", 350);
        Burger burger = new Burger();
        burger.setBuns(bun_sesame);
        burger.addIngredient(new Ingredient(FILLING, "bacon", 120));
        burger.addIngredient(new Ingredient(SAUCE, "garlic sauce", 150));
        String burger_receipt = "(==== Кунжутная ====)" + "\n" + "= filling bacon =" + "\n" + "= sauce garlic sauce =" + "\n" + "(==== Кунжутная ====)" + "\n" + "\n" + "Price: 970.000000" + "\n";
        assertEquals(burger_receipt, burger.getReceipt());
    }

}
