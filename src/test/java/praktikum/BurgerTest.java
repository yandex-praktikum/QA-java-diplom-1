package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
public class BurgerTest {

    private Bun bun;
    private List<Ingredient> ingredients;
    private Burger burger;

    @Before
    public void setUp() {
        bun = Mockito.mock(Bun.class);
        ingredients = new ArrayList<>();
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertSame(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        Ingredient ingredient3 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(0, 2);
        Assert.assertEquals(3, burger.ingredients.size());
        Assert.assertSame(ingredient2, burger.ingredients.get(0));
        Assert.assertSame(ingredient3, burger.ingredients.get(1));
        Assert.assertSame(ingredient1, burger.ingredients.get(2));
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(200f);
        Mockito.when(ingredient2.getPrice()).thenReturn(200f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice = 2 * bun.getPrice() + ingredient1.getPrice() + ingredient2.getPrice();
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Bun bun = new Bun("white bun", 200);
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String expectedReceipt = "(==== white bun ====)\r\n" +
                "= sauce sour cream =\r\n" +
                "= filling dinosaur =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 800,000000\r\n";
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}

