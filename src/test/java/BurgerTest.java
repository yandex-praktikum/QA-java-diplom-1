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
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void setBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        assertEquals(true,burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertEquals(false, burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1,0);
        assertEquals(false, burger.ingredients.indexOf(firstIngredient)==0);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        float mockIngridientPrice = 550;
        float mockBunPrice = 60;
        float mockPriceSum = mockIngridientPrice + mockBunPrice + mockBunPrice;
        Mockito.when(firstIngredient.getPrice()).thenReturn(mockIngridientPrice);
        Mockito.when(bun.getPrice()).thenReturn(mockBunPrice);
        float actualSum = burger.getPrice();
        assertEquals(mockPriceSum, actualSum, 0);
    }



    }
