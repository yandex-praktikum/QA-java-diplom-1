import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgersTests {
    Burger burger = new Burger();
    @Mock
    private Bun testBun = new Bun("red bun", 300);
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    @Test
    public void setBunTest() {
        burger.setBuns(testBun);
        Assert.assertEquals(testBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        Assert.assertTrue(burger.ingredients.size() != 0);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(testBun);
        Mockito.when(testBun.getPrice()).thenReturn(100F);
        Assert.assertEquals(200F, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(testBun);
        burger.addIngredient(ingredient2);
        Mockito.when(ingredient2.getType()).thenReturn(FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient2.getPrice()).thenReturn(200F);
        Mockito.when(testBun.getName()).thenReturn("red bun");
        String expected = String.format("(==== red bun ====)%n" +
                "= filling dinosaur =%n" +
                "(==== red bun ====)%n" +
                "%nPrice: 200,000000%n");
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
