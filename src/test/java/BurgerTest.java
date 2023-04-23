import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private IngredientType type;
    @Mock
    Bun bun;
    private final static String BUN_NAME = "White bread";
    private Ingredient newIngredient1 = new Ingredient(type.FILLING,"cucumber",32);
    private Ingredient newIngredient2 = new Ingredient(type.SAUCE,"ketchup",10);
    private Burger burger = new Burger();

    @Test
    public void addIngredientTest() {
        burger.addIngredient(newIngredient1);
        int sizeAfter = burger.ingredients.size();
        int sizeExpected = 1;
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newIngredient1);
        assertEquals(sizeExpected ,sizeAfter);
        assertEquals(listExpected, burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(newIngredient1);
        burger.addIngredient(newIngredient2);
        burger.moveIngredient(1,0);
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newIngredient2);
        listExpected.add(newIngredient1);
        assertEquals(listExpected, burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(newIngredient1);
        burger.addIngredient(newIngredient2);
        burger.removeIngredient(0);
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newIngredient2);
        assertEquals(listExpected, burger.ingredients);
    }

    @Test
    public void getReceiptTest() {
        burger.addIngredient(newIngredient1);
        burger.addIngredient(newIngredient2);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        burger.setBuns(bun);
        System.out.println(burger.getReceipt());
        String receipt = burger.getReceipt();
        float price = burger.getPrice();
        String priceStr = Float.toString(price);
        String newPriceStr=priceStr.replace(".",",");
        assertTrue(receipt.contains(BUN_NAME)
                && receipt.contains(newIngredient1.name)
                && receipt.contains(newIngredient2.name)
                && receipt.contains("Price")
                && receipt.contains(newPriceStr));
    }
}
