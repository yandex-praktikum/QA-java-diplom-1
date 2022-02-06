package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.xml.crypto.Data;

import java.sql.DatabaseMetaData;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void testSetValidBun() {
        Burger burger = new Burger();
        Bun bun = new Bun("булочка", 10.0f);
        burger.setBuns(bun);
        assertEquals(bun.name, burger.bun.getName());
        assertEquals(bun.price, burger.bun.getPrice(), 0.0f);
    }

    @Test
    public void testAddIngredientToList() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientFromNotEmptyList() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemoveIngredientFromEmptyList() {
        new Burger().removeIngredient(0);
    }

    @Test
    public void testMoveIngredientInList() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "сыр", 10.0f));
        burger.addIngredient(ingredient);
        burger.moveIngredient(1, 0);

        assertEquals(3, burger.ingredients.size());
        assertEquals("сыр", burger.ingredients.get(0).getName());
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(50.0f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals(300.0f, burger.getPrice(), 0.0f);
    }

    @Test
    public void testGetReceipt() {
        Database db = new Database();
        Burger burger = new Burger();
        burger.setBuns(db.availableBuns().get(0));
        burger.addIngredient(db.availableIngredients().get(1));
        burger.addIngredient(db.availableIngredients().get(4));
        String fd = burger.getReceipt();
        assertEquals("(==== black bun ====)\n" +
                "= sauce sour cream =\n" +
                "= filling dinosaur =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 600,000000\n", burger.getReceipt());
    }
}