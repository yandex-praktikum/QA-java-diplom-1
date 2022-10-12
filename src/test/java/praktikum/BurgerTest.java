package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        int actual = burger.ingredients.size();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void moveIngredientTest() {
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        String expected = "hot sauce";
        String actual = burger.ingredients.get(1).name;
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        float price = 300;
        float expected = price * 2 + price;
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(expected, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceiptTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200F);
        Bun bun = new Bun("black bun", 100F);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        String actual = burger.getReceipt();
        String expected = String.format(("(==== " + bun.getName() + " ====)%n= "
                + ingredient.getType().toString().toLowerCase() + " " + ingredient.getName() +
                " =%n(==== " + bun.getName() + " ====)%n%nPrice: %f%n"), burger.getPrice());
        assertEquals(expected, actual);
    }
}

