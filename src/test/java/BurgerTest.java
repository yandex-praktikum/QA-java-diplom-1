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
        Bun bun = new Bun("Black", 100);
        burger.setBuns(bun);
        assertEquals( burger.bun.getName(),bun.getName());
    }


    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "Sweet", 100);
        burger.addIngredient(ingredient);
        burger.ingredients.contains(ingredient);
    }


    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "Sweet", 100);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        burger.ingredients.isEmpty();
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(SAUCE, "Sweet", 100);
        Ingredient ingredient2 = new Ingredient(SAUCE, "Sweet", 200);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertEquals(burger.ingredients.get(0),ingredient2);
    }

    @Test
    public void getBurgerPrice() {

        Burger burger = new Burger();
        Bun bun = Mockito.mock(Bun.class);
        Ingredient firstBurgerIngredient1 = new Ingredient(SAUCE, "Sweet", 50f);
        Ingredient secondBurgerIngredient2 = new Ingredient(FILLING, "FILLING", 50f);

        burger.setBuns(bun);
        burger.addIngredient(firstBurgerIngredient1);
        burger.addIngredient(secondBurgerIngredient2);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        float result = burger.getPrice();
        assertEquals("Актуальный результат отличается от ожидаемого", 300, result, 0);
    }
    @Test
    public void getReceiptTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "Sweet", 100);
        Bun bun = new Bun("Black", 100);
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);


        assertEquals(burger.getReceipt().startsWith("(==== "+bun.getName()+" ====)"), true);
    }
}


