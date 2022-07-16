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
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {



    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Black");
        assertEquals( burger.bun.getName(),bun.getName());
    }


    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.ingredients.contains(ingredient);
    }


    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        burger.ingredients.isEmpty();
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertEquals(burger.ingredients.get(0),ingredient2);
    }

    @Test
    public void getBurgerPrice() {
        Burger burger = new Burger();
        Bun bun = Mockito.mock(Bun.class);
        Ingredient firstBurgerIngredient = Mockito.mock(Ingredient.class);
        Ingredient secondBurgerIngredient = Mockito.mock(Ingredient.class);

        burger.setBuns(bun);
        burger.addIngredient(firstBurgerIngredient);
        burger.addIngredient(secondBurgerIngredient);

        Mockito.when(bun.getPrice()).thenReturn(100f);
        float result = burger.getPrice();
        assertEquals("Актуальный результат отличается от ожидаемого", 200f, result, 0);
    }
    @Test
    public void getReceiptTest() {
        Bun bun = Mockito.mock(Bun.class);
        Burger burger = new Burger();

        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn("Black");
        assertEquals(burger.getReceipt().startsWith("(==== "+bun.getName()+" ====)"), true);
    }
}


