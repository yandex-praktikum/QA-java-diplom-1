import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;
    private Ingredient ingredient;
    private Ingredient ingredient_2;

    @Spy
    private Ingredient ingredient_3 = new Ingredient(IngredientType.SAUCE, "cosmo", 100500F);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void checkingSetBunsName() {
        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn("Name");

        String expectedResult = "Name";
        assertEquals(expectedResult, burger.bun.getName());
    }

    @Test
    public void checkingSetBunsPrice() {
        burger.setBuns(bun);

        Mockito.when(bun.getPrice()).thenReturn(100500F);

        float expectedResult = 100500F;
        assertEquals(expectedResult, burger.bun.getPrice(), 0.0F);
    }

    @Test
    public void checkingAddIngredient() {
        burger.addIngredient(ingredient);

        Ingredient actualResult = burger.ingredients.get(0);
        assertEquals(ingredient, actualResult);
    }

    @Test
    public void checkingRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        int expectedResult = 0;
        assertEquals(expectedResult, burger.ingredients.size());
    }

    @Test
    public void checkingMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient_2);
        burger.moveIngredient(0, 1);

        assertEquals(ingredient_2, burger.ingredients.get(0));
    }

    @Test
    public void checkingGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient_3);

        Mockito.when(bun.getPrice()).thenReturn(100F);

        float expectedResult = 100700F;
        float actualResult = burger.getPrice();
        assertEquals(expectedResult, actualResult, 0.0F);
    }

    @Test
    public void checkingGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient_3);

        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(bun.getPrice()).thenReturn(100500F);

        String expectedResult = "(==== bun ====)\r\n= sauce cosmo =\r\n(==== bun ====)\r\n\r\nPrice: 301500,000000\r\n";
        String actualResult = burger.getReceipt();
        assertEquals(expectedResult, actualResult);
    }
}