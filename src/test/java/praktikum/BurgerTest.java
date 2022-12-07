package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    //Проверяем метод addIngredient(Ingredient ingredient)
    @Test
    public void addIngredientCheck() {
        burger.addIngredient(ingredient1);
        Ingredient expectedResult = ingredient1;
        assertEquals("List is incorrect", expectedResult, burger.ingredients.get(0));
    }

    //Проверяем метод removeIngredient(int index)
    @Test
    public void removeIngredientCheck() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        List<Ingredient> expectedResult = new ArrayList<>();
        assertEquals("List is incorrect", expectedResult, burger.ingredients);
    }

    //Проверяем метод moveIngredient(int index, int newIndex)
    @Test
    public void moveIngredientCheck() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Ingredient is incorrect", ingredient1, burger.ingredients.get(1));
    }

    //Проверяем метод getPrice()
    @Test
    public void getPriceCheck() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient1.getPrice()).thenReturn(50F);
        Mockito.when(ingredient2.getPrice()).thenReturn(100F);
        float expectedResult = 550F;
        float actualResult = burger.getPrice();
        assertEquals("Total price is incorrect",expectedResult, actualResult, 0);
    }

    //Проверяем метод getReceipt()
    @Test
    public void getReceiptCheck() {

        StringBuilder expectedResult = new StringBuilder(String.format("(==== %s ====)%n", "bunName"));
        expectedResult.append(String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(),  "cutlet1"));
        expectedResult.append(String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(),  "cutlet2"));
        expectedResult.append(String.format("(==== %s ====)%n", "bunName"));
        expectedResult.append(String.format("%nPrice: %f%n", 500.000000));

        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("bunName");
        Mockito.when(bun.getPrice()).thenReturn(200F);

        burger.addIngredient(ingredient1);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("cutlet1");
        Mockito.when(ingredient1.getPrice()).thenReturn(50F);

        burger.addIngredient(ingredient2);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("cutlet2");
        Mockito.when(ingredient2.getPrice()).thenReturn(50F);

        String actualResult = burger.getReceipt();
        assertEquals("Receipt is incorrect", expectedResult.toString(), actualResult);
    }


}
