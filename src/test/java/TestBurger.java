
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    Burger burger;

    @Mock
    Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    /**
     * Тестирование метода {@link Burger#setBuns(Bun)}
     */
    @Test
    public void testSetBuns() {
        Bun bun = new Bun("name", 123);
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    /**
     * Тестирование метода {@link Burger#addIngredient(Ingredient)}
     */
    @Test
    public void testAddIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 123);

        burger.addIngredient(ingredient);

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(burger.ingredients.get(0), ingredient);
    }

    /**
     * Тестирование метода {@link Burger#removeIngredient(int)}
     */
    @Test
    public void testRemoveIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 123);

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertEquals(0, burger.ingredients.size());
    }

    /**
     * Тестирование метода {@link Burger#moveIngredient(int, int)}
     */
    @Test
    public void testMoveIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 123);

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals(2, burger.ingredients.size());

        burger.moveIngredient(0, 1);

        Assert.assertEquals(burger.ingredients.get(1), ingredient);
    }

    /**
     * Тестирование метода {@link Burger#getPrice()}
     */
    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn((float) 2);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 1);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Assert.assertEquals(5, burger.getPrice(), 0.1);
    }

    /**
     * Тестирование метода {@link Burger#getReceipt()}
     */
    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("BunName");
        Ingredient ing = new Ingredient(IngredientType.SAUCE, "ing", 2);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "ingredient", 3);

        burger.setBuns(bun);
        burger.addIngredient(ing);
        burger.addIngredient(ingredient);

        burger.getReceipt();

        Assert.assertEquals(5.000000, burger.getPrice(), 0.000001);
        Assert.assertEquals("BunName", bun.getName());
    }
}
