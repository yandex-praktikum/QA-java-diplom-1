package praktikum.stellar_burgers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
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

        burger.setBuns(bun);
        assertEquals(bun, burger.bun);

    }

    @Test
    public void addIngredientsToIngredientList() {

        burger.addIngredient(ingredient);
        int expectedSize = 1;
        assertEquals(expectedSize, burger.ingredients.size());

    }

    @Test
    public void removeIngredientFromIngredientList() {

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int expectedSize = 0;
        assertEquals(expectedSize, burger.ingredients.size());

    }

    @Test
    public void moveIngredientInIngredientList() {

        String expected = "MoveTest";
        burger.addIngredient(ingredient);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, expected,1));
        burger.addIngredient(ingredient);
        burger.moveIngredient(1, 2);
        String actual = burger.ingredients.get(2).getName();
        assertEquals(expected, actual);

    }

    @Test
    public void getPriceTest() {
        float expectedPrice = 40;
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(10f);
        assertEquals("Цена не соответствует", expectedPrice, burger.getPrice(), 0);

    }

    @Test
    public void getReceipt() {

        String expected = "(==== BunName ====)\n"
                + "= sauce IngName =\n"
                + "= sauce IngName =\n"
                + "(==== BunName ====)\n"
                + "\n"
                + "Price: 40,000000\n";
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("BunName");
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getName()).thenReturn("IngName");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(10f);
        assertEquals(expected, burger.getReceipt());

    }

}