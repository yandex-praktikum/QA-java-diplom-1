import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Database database;

    @Test
    public void checkGetPrice() {
        float expectedPrice = 300;
        Bun expBun = new Bun("Чизбургер", 50);
        List<Bun> expectedBuns = new ArrayList<>();
        expectedBuns.add(expBun);
        Mockito.when(database.availableBuns()).thenReturn(expectedBuns);
        Ingredient expSauce = new Ingredient(IngredientType.SAUCE, "Кетчуп", 50);
        Ingredient expFilling = new Ingredient(IngredientType.FILLING, "Крокодил", 200);
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(expSauce);
        expectedIngredients.add(expFilling);
        Mockito.when(database.availableIngredients()).thenReturn(expectedIngredients);
        Burger burger = new Burger();
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.moveIngredient(1, 0);
        burger.removeIngredient(1);
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkGetReceipt() {
        String expectedReceipt = "(==== Чизбургер ====)\n" +
                "= filling Крокодил =\n" +
                "(==== Чизбургер ====)\n" +
                "\n" +
                "Price: 300,000000\n";
        Bun expBun = new Bun("Чизбургер", 50);
        List<Bun> expectedBuns = new ArrayList<>();
        expectedBuns.add(expBun);
        Mockito.when(database.availableBuns()).thenReturn(expectedBuns);
        Ingredient expSauce = new Ingredient(IngredientType.SAUCE, "Кетчуп", 50);
        Ingredient expFilling = new Ingredient(IngredientType.FILLING, "Крокодил", 200);
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(expSauce);
        expectedIngredients.add(expFilling);
        Mockito.when(database.availableIngredients()).thenReturn(expectedIngredients);
        Burger burger = new Burger();
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.moveIngredient(0, 1);
        burger.removeIngredient(1);
        String actualReceipt = burger.getReceipt();
        assertEquals(actualReceipt.replaceAll("\\s+",""), expectedReceipt.replaceAll("\\s+",""));
    }
}
