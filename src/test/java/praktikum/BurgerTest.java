package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    String cutletIngredientName = "cutlet";
    String ketchupIngredientName = "ketchup";
    String bunName = "Chiabatta";

    @Mock
    Bun bun;

    @Mock
    Ingredient cutletIngredient;
    @Mock
    Ingredient ketchupIngredient;

    @Before
    public void createBurgerObject(){
        this.burger = new Burger();
    }

    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        System.out.println(burger.bun);
        Assert.assertEquals(this.bun, burger.bun);
    }

    @Test
    public void addIngredientWhenOneIngredientWasAddedSuccessfully(){
        this.burger.addIngredient(cutletIngredient);
        Assert.assertEquals(this.cutletIngredient, this.burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientWhenOneIngredientWasRemovedSuccessfully(){
        this.burger.addIngredient(cutletIngredient);
        this.burger.removeIngredient(0);
        Assert.assertEquals(0, this.burger.ingredients.size());
    }

    @Test
    public void moveIngredientWhenInListOfIngredientsTwoItems(){
        List<Ingredient> expectedResult = new ArrayList<>();
        expectedResult.add(ketchupIngredient);
        expectedResult.add(cutletIngredient);

        this.burger.addIngredient(cutletIngredient);
        this.burger.addIngredient(ketchupIngredient);
        this.burger.moveIngredient(0,1);
        Assert.assertEquals(expectedResult, this.burger.ingredients);
    }

    @Test
    public void getPriceWhenTwoIngredientsInBurger(){
        float bunPrice = 15;
        float cutletPrice = 50;
        float ketchupPrice = 10;
        float expectedFullPrice = 90;
        burger.setBuns(bun);
        burger.addIngredient(cutletIngredient);
        burger.addIngredient(ketchupIngredient);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(cutletIngredient.getPrice()).thenReturn(cutletPrice);
        Mockito.when(ketchupIngredient.getPrice()).thenReturn(ketchupPrice);
        Assert.assertEquals(expectedFullPrice,burger.getPrice(), 0);
    }

    @Test
    public void getReceiptWhenTwoIngredientsInBurger(){
        String expectedResult =
                "(==== Chiabatta ====)\r\n" +
                "= filling cutlet =\r\n" +
                "= sauce ketchup =\r\n" +
                "(==== Chiabatta ====)\r\n" +
                "\r\n" +
                "Price: 90,000000\r\n";

        float bunPrice = 15;
        float cutletPrice = 50;
        float ketchupPrice = 10;
        burger.setBuns(bun);
        burger.addIngredient(cutletIngredient);
        burger.addIngredient(ketchupIngredient);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(cutletIngredient.getPrice()).thenReturn(cutletPrice);
        Mockito.when(ketchupIngredient.getPrice()).thenReturn(ketchupPrice);

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(cutletIngredient.getName()).thenReturn(cutletIngredientName);
        Mockito.when(ketchupIngredient.getName()).thenReturn(ketchupIngredientName);

        Mockito.when(cutletIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ketchupIngredient.getType()).thenReturn(IngredientType.SAUCE);

        Assert.assertEquals(expectedResult, burger.getReceipt());


    }

}
