import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class BurgerTest {

    private final Burger buterbrod = new Burger();
    private final Bun toast = new Bun("harrys", 100);
    private final Ingredient cheese = new Ingredient(IngredientType.FILLING, "Сыр", 50);
    private final Ingredient salad = new Ingredient(IngredientType.FILLING, "Салат", 40);
    private final Ingredient tomato = new Ingredient(IngredientType.FILLING, "Помидорка", 60);

    @Before
    public void newBurger() {
        buterbrod.setBuns(toast);
        buterbrod.addIngredient(cheese);
        buterbrod.addIngredient(salad);
        buterbrod.addIngredient(tomato);
    }

    @After
    public void clearData() {
        buterbrod.ingredients.clear();
    }

    @Test
    public void setBunsChooseCorrectBun() {
        assertEquals(buterbrod.bun, toast);
    }

    @Test
    public void addIngredientCorrectAddedInList() {
        assertTrue(buterbrod.ingredients.contains(cheese));
    }

    @Test
    public void removeIngredientCorrectRemove() {
        buterbrod.removeIngredient(0);
        assertFalse(buterbrod.ingredients.contains(cheese));
    }

    @Test
    public void moveIngredientCorrectMove() {
        buterbrod.moveIngredient(0, 2);
        assertEquals(cheese, buterbrod.ingredients.get(2));
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        assertEquals(350, buterbrod.getPrice(), 0);
    }

    @Test
    public void getReceiptReturnCorrectValues() {
        String receipt =
                "(==== harrys ====)\n"+
                        "= filling Сыр =\n"+
                        "= filling Салат =\n"+
                        "= filling Помидорка =\n"+
                        "(==== harrys ====)\n"+
                        "\n"+
                        "Price: 350,000000\n";
        assertEquals("Неверный рецепт", receipt, buterbrod.getReceipt());

    }
}
