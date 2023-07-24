package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Spy
    private Burger burger;

    @Test
    public void setBunsShouldSetBurgerBun(){
        burger.setBuns(bun);

        assertNotNull(burger.bun);
    }

    @Test
    public void getPriceShouldReturnBurgerPrice(){
        burger.bun = bun;
        burger.ingredients.add(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(1500F);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        float expectedResult = 3200.0F;
        float actualResult = burger.getPrice();

        assertEquals(expectedResult, actualResult,0);
    }

    @Test
    public void getReceiptShouldReturnBurgerReceipt(){
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        float bunPrice = 988F;
        float ingredientPrice = 15F;
        String bunName = "Флюоресцентная булка R2-D3";
        String ingredientName = "Соус традиционный галактический";

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);

        String receipt = burger.getReceipt();
        String expectedPrice = String.format("%f%n", burger.getPrice());
        boolean hasBunName = receipt.contains(bunName);
        boolean hasIngredientName = receipt.contains(bunName);
        boolean hasPrice = receipt.contains(expectedPrice);

        assertTrue(hasBunName);
        assertTrue(hasIngredientName);
        assertTrue(hasPrice);
    }


    @Test
    public void moveIngredientShouldMoveIngredientInIngredientsArray(){
        burger.ingredients.add(ingredient);
        burger.ingredients.add(null);
        burger.moveIngredient(0,1);

        Ingredient actualResult = burger.ingredients.get(1);

        assertEquals(ingredient, actualResult);
    }

    @Test
    public void addIngredientShouldAddIngredientInIngredientsArray(){
        burger.addIngredient(ingredient);

        boolean actualResult = burger.ingredients.contains(ingredient);

        assertTrue(actualResult);
    }

    @Test
    public void removeIngredientShouldRemoveIngredientInIngredientsArray(){
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);

        int expectedResult = 0;
        int actualResult = burger.ingredients.size();

        assertEquals(expectedResult, actualResult);
    }
}
