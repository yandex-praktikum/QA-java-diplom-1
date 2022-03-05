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
    public void addIngredient() {

        burger.addIngredient(ingredient);

        int actualResult = burger.ingredients.size();
        int expectedResult = 1;

        assertEquals("The burger size is not correct",expectedResult, actualResult);
    }

    @Test
    public void removeIngredient() {

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        int actualResult = burger.ingredients.size();
        int expectedResult = 0;

        assertEquals("The burger size is not correct",expectedResult, actualResult);
    }

    @Test
    public void moveIngredient() {

        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.moveIngredient(0, 1);

        String actualResult = burger.ingredients.get(1).name;
        String expectedResult = "dinosaur";

        assertEquals("The burger ingredient is not correct",expectedResult, actualResult);
    }

    @Test
    public void getPrice() {

        float price = 100;
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);

        float actualResult = burger.getPrice();
        float expectedResult = 300;

        assertEquals("The price is not correct", expectedResult, actualResult,0);
    }

    @Test
    public void getReceipt() {

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);

        String actualResult = burger.getReceipt();
        String expectedResult = "(==== black bun ====)\r\n= filling dinosaur =\r\n(==== black bun ====)\r\n\r\nPrice: 900,000000\r\n";

        assertEquals("The burger receipt is not correct",expectedResult, actualResult);
    }
}
