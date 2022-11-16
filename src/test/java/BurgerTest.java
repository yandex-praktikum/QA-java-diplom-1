import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger  = new Burger();
    @Mock
    Bun testBun;
    @Mock
    Ingredient ingredient, testIngredient;

    @Test
    public void setBunsTest() {
        burger.setBuns(testBun);
        Assert.assertEquals(testBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(testIngredient);
        Assert.assertTrue(burger.ingredients.contains(testIngredient));
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(testIngredient);
        int i = (burger.ingredients).indexOf(testIngredient);
        burger.removeIngredient(i);
        Assert.assertFalse(burger.ingredients.contains(testIngredient));
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(ingredient);
        burger.ingredients.add(testIngredient);
        int i = (burger.ingredients).indexOf(testIngredient);
        burger.moveIngredient(i, i-1);
        Assert.assertEquals((burger.ingredients).indexOf(testIngredient), i-1);
    }

    @Test
    public void getPriceTest() {
        float price = 7;
        burger.bun = testBun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(testIngredient);
        Mockito.when(testBun.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        Mockito.when(testIngredient.getPrice()).thenReturn(3f);

        Assert.assertEquals(price, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.bun = testBun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(testIngredient);
        Mockito.when(testBun.getName()).thenReturn("test bun");
        Mockito.when(testBun.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getName()).thenReturn("test sauce");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        Mockito.when(testIngredient.getName()).thenReturn("test sausage");
        Mockito.when(testIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(testIngredient.getPrice()).thenReturn(3f);

        String expected = String.format("(==== %s ====)%n", "test bun") +
                String.format("= %s %s =%n", "sauce", "test sauce") +
                String.format("= %s %s =%n", "filling", "test sausage") +
                String.format("(==== %s ====)%n", "test bun") +
                String.format("%nPrice: %f%n", 7f);

        Assert.assertEquals(expected, burger.getReceipt());
    }

}
