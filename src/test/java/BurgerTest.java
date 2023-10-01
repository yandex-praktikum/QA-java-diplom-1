import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends BaseTest {

    private static final float firstIngredientPrice = random.nextFloat();
    private static final float secondIngredientPrice = random.nextFloat();
    private static final IngredientType firstIngredientType = IngredientType.FILLING;
    private static final IngredientType secondIngredientType = IngredientType.SAUCE;
    private static final float expectedSum =expectedBunPrice * 2 + firstIngredientPrice + secondIngredientPrice;

    @Mock
    private static Bun bun;

    @Mock
    private static Ingredient firstIngredient;

    @Mock
    private static Ingredient secondIngredient;

    private static Burger burger;

    @Before
    public void setUp() {
        Mockito.when(bun.getName()).thenReturn(expectedBunName);
        Mockito.when(bun.getPrice()).thenReturn(expectedBunPrice);

        Mockito.when(firstIngredient.getName()).thenReturn(expectedIngredientName);
        Mockito.when(firstIngredient.getPrice()).thenReturn(firstIngredientPrice);
        Mockito.when(firstIngredient.getType()).thenReturn(firstIngredientType);

        Mockito.when(secondIngredient.getName()).thenReturn(expectedIngredientName);
        Mockito.when(secondIngredient.getPrice()).thenReturn(secondIngredientPrice);
        Mockito.when(secondIngredient.getType()).thenReturn(secondIngredientType);

        burger = new Burger();
    }

    @Test
    public void setBuns() {
        //when
        burger.setBuns(bun);
        //then
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        //when
        burger.addIngredient(firstIngredient);
        //then
        Assert.assertEquals(List.of(firstIngredient), burger.ingredients);
    }

    @Test
    public void removeIngredient() {
        //when
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        //then
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientToEnd() {
        //when
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        //then
        Assert.assertEquals(
                List.of(secondIngredient, firstIngredient),
                burger.ingredients
        );
    }

    @Test
    public void moveIngredientToBeginning() {
        //when
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1, 0);
        //then
        Assert.assertEquals(
                List.of(secondIngredient, firstIngredient),
                burger.ingredients
        );
    }

    @Test
    public void getPriceAssertValue() {
        //when
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        //then
        float actualSum = burger.getPrice();
        Assert.assertEquals(expectedSum, actualSum, testDelta);
    }

    @Test
    public void getReceipt() {
        //when
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        //then
        String expectedReceipt = String.format("(==== %s ====)%n", expectedBunName) +
                String.format(
                        "= %s %s =%n",
                        firstIngredientType.toString().toLowerCase(),
                        expectedIngredientName
                ) +
                String.format(
                        "= %s %s =%n",
                        secondIngredientType.toString().toLowerCase(),
                        expectedIngredientName
                ) +
                String.format("(==== %s ====)%n", expectedBunName) +
                String.format(
                        "%nPrice: %f%n",
                        expectedSum
                );
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
