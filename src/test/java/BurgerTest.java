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

    @Mock
    Bun bun;

    @Mock
    private static Ingredient firstIngredient;

    @Mock
    private static Ingredient secondIngredient;

    private Burger burger;

    @Before
    public void setUpMock(){
        burger = new Burger();

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(random.nextFloat());

        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn(ingredientSauceName);
        Mockito.when(firstIngredient.getPrice()).thenReturn(random.nextFloat());

        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn(ingredientFillingName);
        Mockito.when(secondIngredient.getPrice()).thenReturn(random.nextFloat());
    }

    @Test
    public void setBunTest(){
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);

        Assert.assertEquals(List.of(firstIngredient), burger.ingredients);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientToEndTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(0, 1);

        Assert.assertEquals(List.of(secondIngredient, firstIngredient), burger.ingredients);
    }


    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        float expectedSum = bun.getPrice() * 2 + firstIngredient.getPrice() + secondIngredient.getPrice();

        Assert.assertEquals(expectedSum, burger.getPrice(), testDeltaRange);
    }

}
