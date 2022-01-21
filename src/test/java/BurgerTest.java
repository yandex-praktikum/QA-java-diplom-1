
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;
    Ingredient ingredient2;

    @Test
    public void setBunTest() {
        burger = new Burger();
        bun = new Bun("Говядина", 7.29F);
        burger.setBuns(bun);
        assertEquals(bun.name, "Говядина");
        assertEquals(bun.price, 7.29F, 0);
    }

    @Test
    public void addIngredientTest() {
        burger = new Burger();
        ingredient = new Ingredient(FILLING, "Мясо", 1.0F);
        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.get(0), ingredient);
        burger.removeIngredient(0);
    }

    @Test
    public void removeIngredientTest() {
        burger = new Burger();
        ingredient = new Ingredient(FILLING, "Мясо", 1.0F);
        ingredient2 = new Ingredient(SAUCE, "Кетчуп", 2.0F);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.get(0), ingredient2);
    }

    @Test
    public void moveIngredientTest() {
        burger = new Burger();
        ingredient = new Ingredient(FILLING, "Мясо", 1.0F);
        ingredient2 = new Ingredient(SAUCE, "Кетчуп", 2.0F);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        assertEquals(burger.ingredients.get(0), ingredient);
        burger.moveIngredient(1, 0);
        assertEquals(burger.ingredients.get(0), ingredient2);
    }

    @Test
    public void getPriceTest() {
        burger = new Burger();
        bun = new Bun("Говядина", 7.29F);
        burger.setBuns(bun);
        burger.getPrice();
        assertEquals(burger.getPrice(), 14.58F, 0);
    }

    @Test
    public void getReceiptTest() {
        burger = new Burger();
        bun = new Bun("Белая булка", 2.2F);
        burger.setBuns(bun);
        ingredient = new Ingredient(FILLING, "Свинина", 1.0F);
        burger.ingredients.add(ingredient);
        String expected = "(==== Белая булка ====)\n" +
                "= filling Свинина =\n" +
                "(==== Белая булка ====)\n" +
                "\n" +
                "Price: 5,400000\n";
        expected.equals(burger.getReceipt());
    }
}
