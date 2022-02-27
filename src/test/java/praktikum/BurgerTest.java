package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        int expected = 1;
        int actual = burger.ingredients.size();
        assertEquals(expected, actual);
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        int expected = 0;
        int actual = burger.ingredients.size();
        assertEquals(expected, actual);
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce",100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet",100));

        burger.moveIngredient(0, 1);

        String expected = "hot sauce";
        String actual = burger.ingredients.get(1).getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);

        float actual = burger.getPrice();
        float expected = 400;
        assertEquals(expected, actual,0);
    }

    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(burger.getPrice()).thenReturn(400F);

        String actual = burger.getReceipt();
        String expected = String.format(
                        "(==== black bun ====)%n" +
                        "= sauce hot sauce =%n" +
                        "(==== black bun ====)%n%n" +
                        "Price: 400,000000%n");

        assertEquals("строки не равны", expected, actual);

    }
}