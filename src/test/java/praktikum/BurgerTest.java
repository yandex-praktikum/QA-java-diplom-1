package praktikum;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    @Mock
    Ingredient ingredient1, ingredient2;

    @Mock
    Bun bun;

    @Test
    public void setBunsTest() {
       Bun bun = new Bun("testBun", 10F);
       Burger burger = new Burger();
       burger.setBuns(bun);
       assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientPositiveTest() {
        Burger burger = new Burger();
        burger.ingredients.add(0, ingredient1);
        burger.removeIngredient(0);
        assertEquals(true, burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(0, ingredient1);
        burger.ingredients.add(1, ingredient2);
        burger.moveIngredient(1, 0);
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients.add(0, ingredient1);
        burger.ingredients.add(1, ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredient1.getPrice()).thenReturn(2F);
        Mockito.when(ingredient2.getPrice()).thenReturn(3F);
        float expected = 25f;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.bun = bun;
        String bunName = "testBun";
        String ingredient1Name = "testIngredientName1";
        String ingredient2Name = "testIngredientName2";
        float floatValue = 50.000000F;
        burger.ingredients.add(0, ingredient1);
        burger.ingredients.add(1, ingredient2);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn(ingredient1Name);
        Mockito.when(ingredient2.getName()).thenReturn(ingredient2Name);
        Mockito.when(burger.getPrice()).thenReturn(floatValue);
        String actual = burger.getReceipt();
        String expected = String.format(
                "(==== %s ====)%n" +
                "= filling %s =%n" +
                "= sauce %s =%n" +
                "(==== %s ====)%n" +
                "%nPrice: %f%n", bunName, ingredient1Name, ingredient2Name, bunName, floatValue);
        assertEquals(expected, actual);
    }
}