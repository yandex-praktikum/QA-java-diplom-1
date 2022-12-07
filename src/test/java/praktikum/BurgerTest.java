package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient2;

    private Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    private Ingredient ingredient4 = new Ingredient(IngredientType.FILLING, "sausage", 300);

    //Проверяем метод addIngredient(Ingredient ingredient)
    @Test
    public void addIngredientCheck() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        Ingredient expectedResult = ingredient1;
        assertEquals("List is incorrect", expectedResult, burger.ingredients.get(0));
    }

    //Проверяем метод removeIngredient(int index)
    @Test
    public void removeIngredientCheck() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        List<Ingredient> expectedResult = new ArrayList<>();
        assertEquals("List is incorrect", expectedResult, burger.ingredients);
    }

    //Проверяем метод moveIngredient(int index, int newIndex)
    @Test
    public void moveIngredientCheck() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Ingredient is incorrect", ingredient1, burger.ingredients.get(1));
    }

    //Проверяем метод getPrice()
    @Test
    public void getPriceCheck() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient1.getPrice()).thenReturn(50F);
        Mockito.when(ingredient2.getPrice()).thenReturn(100F);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);
        float expectedResult = 550F;
        float actualResult = burger.getPrice();
        assertEquals("Total price is incorrect",expectedResult, actualResult, 0);
    }


}
