package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends BaseClass {
    Database database = new Database();

    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    @Test
    public void createBurgerTest(){
        for(int i = 0; i <= 5; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void shouldAddIngredientTest() {
        burger.addIngredient(ingredient1);
        assertEquals(burger.ingredients.get(0), ingredient1);
        burger.removeIngredient(0);
    }

    @Test
    public void shouldRemoveIngredientTest() {
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(),0);
    }

    @Test
    public void shouldMoveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertEquals(ingredient1.getName(), burger.ingredients.get(1).name);
    }

    @Test
    public void shouldGetPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        assertEquals(300, burger.getPrice(),0.01);
    }

    @Test
    public void shouldGetReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        String actualResult = burger.getReceipt();
        String expectedResult = "(==== black bun ====)\r\n= filling dinosaur =\r\n(==== black bun ====)\r\n\r\nPrice: 900,000000\r\n";
        assertEquals(expectedResult, actualResult);
    }
}