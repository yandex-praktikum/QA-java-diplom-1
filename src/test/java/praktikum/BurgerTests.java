package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    private Ingredient mockIngredient;

    @Mock
    private Bun mockBun;

    @Test
    public void bunCanBeAddedToBurgerTest(){
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        Assert.assertNotNull(burger.bun);}

    @Test
    public void ingredientCanBeAddedToBurgerTest(){
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient);
        assertEquals(1, burger.ingredients.size());}
    @Test
    public void ingredientCanBeRemovedFromBurgerTest(){
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());}
    @Test
    public void ingredientCanBeMovedInBurgerTest(){
        Burger burger = new Burger();
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Star Dust", 20f);
        Ingredient filling = new Ingredient(IngredientType.FILLING,"Black Hole", 300);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        assertEquals(1, burger.ingredients.indexOf(sauce));}
    @Test
    public void bunsPriceDoubledInBurgerTest(){
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        when(mockBun.getPrice()).thenReturn(120f);
        assertEquals(240, burger.getPrice(), 0);}

    @Test
    public void getBurgerPriceTest(){
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        when(mockBun.getPrice()).thenReturn(120f);
        when(mockIngredient.getPrice()).thenReturn(60f);
        assertEquals(300, burger.getPrice(), 0);}

    @Test
    public void canBeShowedBurgerReceiptTest(){
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        when(mockBun.getName()).thenReturn("Planet");
        when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient.getName()).thenReturn("Black Hole");
        when(burger.getPrice()).thenReturn(300f);
        String expectedReceipt = "(==== Planet ====)\r\n= filling Black Hole =\r\n(==== Planet ====)\r\n\r\nPrice: 300,000000\r\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
