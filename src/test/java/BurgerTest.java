
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientSauce, ingredientFilling;
    Burger burger;



@Test
public void addIngredientTest() {
    burger = new Burger();
    ingredientSauce = new Ingredient(SAUCE, "chili sauce", 300f);
    burger.addIngredient(ingredientSauce);
    assertTrue(burger.ingredients.size() > 0);

}

   @Test
    public void removeIngredientTest() {
       burger = new Burger();
       ingredientSauce = new Ingredient(SAUCE, "chili sauce", 300f);
       burger.addIngredient(ingredientSauce);
       burger.removeIngredient(0);
       int actual =  burger.ingredients.indexOf(ingredientSauce);
       int expected = -1;
       assertEquals(expected, actual);
    }

    @Test
    public void moveIngredientTest() {
        burger = new Burger();
        ingredientSauce = new Ingredient(SAUCE, "chili sauce", 300f);
        burger.addIngredient(ingredientSauce);
        ingredientFilling = new Ingredient(IngredientType.FILLING, "dinosaur", 200f);
        burger.addIngredient(ingredientFilling);
        String ingredientIdx0 = String.valueOf(burger.ingredients.get(0));
        burger.moveIngredient(0,1);
        String ingredientIdx1 = String.valueOf(burger.ingredients.get(1));
        assertEquals(ingredientIdx0, ingredientIdx1);


    }

    @Test

    public void getPriceTest() {
        burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        float expected = 200f;
        float actual = burger.getPrice();
        float delta = 0f;
        assertEquals(actual, expected, delta);

    }

    @Test

    public void getReceiptTest() {
        burger = new Burger();
        String bunName = "red bun";
        String expectedPriceBurgerStr = String.format("%.6f", 1200f);
        burger.setBuns(bun);
        ingredientSauce = new Ingredient(SAUCE, "chili sauce", 300f);
        burger.addIngredient(ingredientSauce);
        ingredientFilling = new Ingredient(FILLING, "sausage", 300f);
        burger.addIngredient(ingredientFilling);
        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(bun.getName()).thenReturn(bunName);
        String expected = String.format("(==== " + bunName + " ====)%n" +
                "= " + SAUCE.toString().toLowerCase() +
                " chili sauce =%n" +
                "= " + FILLING.toString().toLowerCase() +
                " sausage =%n" + "(==== " + bunName + " ====)%n"
                + "%nPrice: " + expectedPriceBurgerStr + "%n");
        String actual = burger.getReceipt();
        assertEquals(actual, expected);

        }


    }
