package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;

    Burger burger = new Burger();

    @Test
    public void bunIsCorrect(){
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addSingleIngredientTest(){
        burger.addIngredient(ingredient1);
        List<Ingredient> expected = List.of(ingredient1);
        assertEquals(expected, burger.ingredients);
    }

    @Test
    public void addMultipleIngredientsTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        List<Ingredient> expected = List.of(ingredient1, ingredient2);
        assertEquals(expected, burger.ingredients);
    }

    @Test
    public void removeSingeIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        List<Ingredient> expected = new ArrayList<>();
        assertEquals(expected, burger.ingredients);
    }

    @Test
    public void removeIngredientTest(){
        setUpBurgerIngredients();
        burger.removeIngredient(1);
        List<Ingredient> expected = List.of(ingredient1, ingredient3);
        assertEquals(expected, burger.ingredients);
    }

    @Test
    public void removeLastIngredientTest(){
        setUpBurgerIngredients();
        burger.removeIngredient(2);
        List<Ingredient> expected = List.of(ingredient1, ingredient2);
        assertEquals(expected, burger.ingredients);
    }

    @Test
    public void moveIngredientsTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        List<Ingredient> expected = List.of(ingredient2, ingredient1);
        assertEquals(expected, burger.ingredients);
    }

    @Test //c
    public void emptyBurgerPriceIsZero(){
        try {
            assertEquals(0f, burger.getPrice());
        } catch (NullPointerException e) {
            fail("NullPointerException");
        }
    }

    @Test
    public void testBurgerReturnsCorrectPrice(){
        setUpPricesOfMockedIngredients();
        burger.setBuns(bun);
        setUpBurgerIngredients();
        assertEquals(totalBurgerPrice(), burger.getPrice());
    }

    @Test
    public void testBurgerReturnsCorrectReceipt(){
        setUpMockedIngredients();
        burger.setBuns(bun);
        setUpBurgerIngredients();
        Burger burgerSpy = Mockito.spy(burger);
        burgerSpy.getReceipt();
        InOrder callsOrder = Mockito.inOrder(bun, ingredient1, ingredient2, ingredient3);
        callsOrder.verify(bun).getName();
        callsOrder.verify(ingredient1).getType();
        callsOrder.verify(ingredient1).getName();
        callsOrder.verify(ingredient2).getType();
        callsOrder.verify(ingredient2).getName();
        callsOrder.verify(ingredient3).getType();
        callsOrder.verify(ingredient3).getName();
        callsOrder.verify(bun).getName();
        Mockito.verify(burgerSpy).getPrice();
    }

    private void setUpPricesOfMockedIngredients() {
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient1.getPrice()).thenReturn(20f);
        Mockito.when(ingredient2.getPrice()).thenReturn(30f);
        Mockito.when(ingredient3.getPrice()).thenReturn(25.72f);
    }

    private void setUpNamesOfMockedIngredients() {
        Mockito.when(bun.getName()).thenReturn("Пшеничная");
        Mockito.when(ingredient1.getName()).thenReturn("Соус");
        Mockito.when(ingredient2.getName()).thenReturn("Салатик");
        Mockito.when(ingredient3.getName()).thenReturn("Сосисочка");
    }

    private void setUpTypesOfMockedIngredients() {
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient3.getType()).thenReturn(IngredientType.FILLING);
    }

    private void setUpMockedIngredients(){
        setUpNamesOfMockedIngredients();
        setUpTypesOfMockedIngredients();
        setUpPricesOfMockedIngredients();
    }

    private void setUpBurgerIngredients(){
        burger.ingredients = List.of(ingredient1, ingredient2, ingredient3);

    }

    private float totalBurgerPrice() {
        return bun.getPrice() * 2
                + ingredient1.getPrice()
                + ingredient2.getPrice()
                + ingredient3.getPrice();
    }

}
