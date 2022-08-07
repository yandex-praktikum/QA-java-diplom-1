package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientSause;
    @Mock
    Ingredient ingredientFilling;

    @Test
    public void setBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void checkAdditionIngredient() {
        Burger burger = new Burger();
        List<Ingredient> expectedIngredients = List.of(ingredient);
        burger.addIngredient(ingredient);
        List<Ingredient> actualIngredients = burger.ingredients;
        assertEquals(expectedIngredients, actualIngredients);
    }
    @Test
    public void checkIngredientRemoval() {
        Burger burger = new Burger();
        List<Ingredient> expectedIngredients = List.of(ingredientSause);
        burger.addIngredient(ingredientSause);
        burger.addIngredient(ingredientFilling);
        burger.removeIngredient(1);
        List<Ingredient> actualIngredients = burger.ingredients;
        assertEquals(expectedIngredients, actualIngredients);
    }
    @Test
    public void checkIngredientMove() {
        Burger burger = new Burger();
        List<Ingredient> expectedIngredients = List.of(ingredientSause, ingredientFilling);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSause);
        burger.moveIngredient(0, 1);
        List<Ingredient> actualIngredients = burger.ingredients;
        assertEquals(expectedIngredients, actualIngredients);
    }
    @Test
    public void checkBurgerPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientSause);
        burger.addIngredient(ingredientFilling);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredientSause.getPrice()).thenReturn(100f);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(100f);
        float actualPrice = burger.getPrice();
        float expectedPrice = 400f;
        assertEquals(expectedPrice, actualPrice, 0);
    }
    @Test
    public void checkBurgerReceipt() {
        Burger burger = new Burger();
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", "white bun"));
        receipt.append(String.format("= %s %s =%n", "SAUCE".toLowerCase(), "sour cream"));
        receipt.append(String.format("= %s %s =%n", "FILLING".toLowerCase(), "dinosaur"));
        receipt.append(String.format("(==== %s ====)%n", "white bun"));
        receipt.append(String.format("%nPrice: %f%n", 500f));
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.ingredients.add(ingredientSause);
        Mockito.when(ingredientSause.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSause.getName()).thenReturn("sour cream");
        Mockito.when(ingredientSause.getPrice()).thenReturn(100f);
        burger.ingredients.add(ingredientFilling);
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientFilling.getName()).thenReturn("dinosaur");
        Mockito.when(ingredientFilling.getPrice()).thenReturn(200f);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = receipt.toString();
        assertEquals(expectedReceipt, actualReceipt);
    }
}
