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
    @Mock
    Ingredient secondIngredient;


    @Test
    public void isSetBunsSetsCorrectBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        boolean actual = burger.bun == bun;
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void isAddIngredientAddsIngredientTest() {
        Burger burger = new Burger();
        int baseSize = burger.ingredients.size();
        burger.addIngredient(ingredient);
        boolean expected = true;
        boolean actual = ingredient == burger.ingredients.get(baseSize);
        assertEquals(expected, actual);
    }

    @Test
    public void isRemoveIngredientRemovesIngredientTest() {
        Burger burger = new Burger();
        int baseSize = burger.ingredients.size();
        burger.ingredients.add(ingredient);
        burger.removeIngredient(baseSize);
        boolean expected = true;
        boolean actual = baseSize == burger.ingredients.size();
        assertEquals(expected, actual);
    }

    @Test
    public void isMoveIngredientMovesIngredientTest() {
        Burger burger = new Burger();
        int baseSize = burger.ingredients.size();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(secondIngredient);
        burger.moveIngredient(baseSize + 1, baseSize);
        boolean expected = true;
        boolean actual = burger.ingredients.get(baseSize) == secondIngredient;
        assertEquals(expected, actual);
    }

    @Test
    public void isGetPriceReturnsCorrectPrice() {
        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getPrice()).thenReturn(3f);
        float expected = 5;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void isGetReceiptReturnsCorrectReceipt() {
        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("bun_Name");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Ingredient_name");
        Mockito.when(burger.getPrice()).thenReturn(1f);
        String expected = String.format("(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                bun.getName(), ingredient.getType().toString().toLowerCase(),
                ingredient.getName(), bun.getName(), burger.getPrice());
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}
