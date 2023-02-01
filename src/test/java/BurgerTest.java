import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    public List<Ingredient> idealBurger = new ArrayList<>();
    Database database = new Database();
    Burger bigMac = new Burger();
    Burger bigTasty = new Burger();
    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock;

    @Before
    public void createBurgers() {
        bigMac.setBuns(database.availableBuns().get(1));
        bigMac.addIngredient(database.availableIngredients().get(3));
        bigMac.addIngredient(database.availableIngredients().get(0));
        bigMac.addIngredient(database.availableIngredients().get(2));
        bigMac.addIngredient(database.availableIngredients().get(3));

        idealBurger.add(database.availableIngredients().get(3));
        idealBurger.add(database.availableIngredients().get(2));
        idealBurger.add(database.availableIngredients().get(0));
        idealBurger.add(database.availableIngredients().get(3));
    }

    @Test
    public void setBunsTest() {
        bigTasty.setBuns(bunMock);
        Mockito.when(bunMock.getName()).thenReturn("bunTest");
        Assert.assertEquals("bunTest", bigTasty.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        bigTasty.addIngredient(ingredientMock);
        Assert.assertTrue(bigTasty.ingredients.contains(ingredientMock));
    }

    @Test
    public void removeIngredientTest() {
        bigTasty.addIngredient(ingredientMock);
        bigTasty.removeIngredient(0);
        Assert.assertFalse(bigTasty.ingredients.contains(ingredientMock));
    }

    @Test
    public void moveIngredientTest() {
        bigMac.moveIngredient(1, 2);
        Assert.assertEquals(idealBurger, bigMac.ingredients);
    }

    @Test
    public void getPricePositiveTest() {
        Assert.assertEquals(1000, bigMac.getPrice(), 0);
    }

    @Test
    public void getPriceNegativeTest() {
        Assert.assertNotEquals(100, bigMac.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {

        StringBuilder receiptBigMac = new StringBuilder(String.format("(==== %s ====)%n", bigMac.bun.getName()));

        for (Ingredient ingredientMac : bigMac.ingredients) {
            receiptBigMac.append(String.format("= %s %s =%n", ingredientMac.getType().toString().toLowerCase(),
                    ingredientMac.getName()));
        }

        receiptBigMac.append(String.format("(==== %s ====)%n", bigMac.bun.getName()));
        receiptBigMac.append(String.format("%nPrice: %f%n", bigMac.getPrice()));

        Assert.assertEquals(receiptBigMac.toString(), bigMac.getReceipt());
    }
}
