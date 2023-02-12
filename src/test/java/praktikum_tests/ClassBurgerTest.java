package praktikum_tests;


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
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ClassBurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;


    @Test
    public void checkSetBunMethod() {
        Bun testBun = new Bun("TestBun", 1000);
        burger.setBuns(testBun);
        assertEquals(testBun, burger.bun);
    }

    @Test
    public void checkAddIngredientMethod() {
        burger.addIngredient(ingredient);
        assertEquals(List.of(ingredient), burger.ingredients);
    }

    @Test
    public void checkRemoveIngredientMethod() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());

    }

    @Test
    public void checkMoveIngredientMethod() {
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "hot sauce", 100);

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        Assert.assertEquals(ingredient2, burger.ingredients.get(0));


    }

    @Test
    public void checkGetPriceMethod() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(ingredient.getPrice()).thenReturn(300f);

        float expectedPrice = 900f;

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);

    }

    @Test
    public void checkGetReceiptMethod() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Test Bun Name");
        Mockito.when(bun.getPrice()).thenReturn(300f);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Test Ingredient Name");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);

        assertEquals(String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice()), burger.getReceipt());

    }


}
