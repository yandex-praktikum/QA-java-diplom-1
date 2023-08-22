import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient1;

    @Before
    public void newBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(),0);
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(1, 0);
        assertEquals("Неправильный ингредиент",ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn(15F);
        Mockito.when(ingredient.getPrice()).thenReturn(350F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float expectedPrice=1430F;
        assertEquals("Ожидаемая цена " + expectedPrice, expectedPrice, burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest(){
        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(ingredient.getName()).thenReturn("Krevetka");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expectedReceipt = "(==== Bun ====)\r\n" +
                "= filling Krevetka =\r\n" +
                "(==== Bun ====)\r\n" +
                "\r\n" +
                "Price: 0,000000\r\n";
        assertEquals("Ожидаемый рецепт" + expectedReceipt, expectedReceipt, burger.getReceipt());
    }
}