import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger = new Burger();
    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest () {
        burger.addIngredient(ingredient);
        int actualValue = burger.ingredients.size();
        int expectedValue = 1;
        assertEquals("Неверный размер бургера", expectedValue, actualValue);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int actualValue = burger.ingredients.size();
        int expectedValue = 0;
        assertEquals("Неверный размер бургера", expectedValue, actualValue);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.moveIngredient(0, 1);
        String actualValue = burger.ingredients.get(1).name;
        String expectedValue = "dinosaur";
        assertEquals("Неверный размер бургера", expectedValue, actualValue);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(2f);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        float expectedPrice = 6;
        float actualPrice = burger.getPrice();
        assertEquals("Неверная цена", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptReturnBurgerReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        String actualValue = burger.getReceipt();
        String expectedValue = "(==== black bun ====)\r\n" +
                "= filling dinosaur =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 900,000000\r\n";
        assertEquals( expectedValue, actualValue);
    }
}