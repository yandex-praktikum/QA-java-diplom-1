package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Ingredient barbecue;
    Ingredient meat;


    @Before
    public void setBefore() {
        barbecue = new Ingredient(SAUCE, "barbecue", 111);
        meat = new Ingredient(FILLING, "meat", 222);
    }


    @Test
    public void setBunsTest() {
        Burger burger = new Burger();

        burger.setBuns(bun);

        assertEquals("'Bun' was successfully applied", bun, burger.bun);
    }


    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        assertEquals("'Ingredient' was successfully added", singletonList(ingredient), burger.ingredients);
    }


    @Test
    public void removeIngredientTest() {
        List<Ingredient> expectedList = new ArrayList<>(asList(barbecue, meat));

        Burger burger = new Burger();
        burger.addIngredient(barbecue);
        burger.addIngredient(meat);
        List<Ingredient> actualList = burger.ingredients;

        assertEquals("Number of ingredients:" + actualList.size(), expectedList.size(), actualList.size());

        expectedList.remove(1);
        burger.removeIngredient(1);

        assertEquals("Second ingredient was removed", expectedList.size(), actualList.size());

        Ingredient expected = expectedList.get(0);
        Ingredient actual = actualList.get(0);

        assertEquals("Name first ingredient is correct", expected.getName(), actual.getName());
        assertEquals("Price first ingredient is correct", expected.getPrice(), actual.getPrice(), 0);
        assertEquals("Type first ingredientis is correct", expected.getType(), actual.getType());
    }


    @Test
    public void moveIngredientTest() {
        List<Ingredient> expectedList = new ArrayList<>(asList(barbecue, meat));

        Burger burger = new Burger();
        burger.addIngredient(barbecue);
        burger.addIngredient(meat);
        List<Ingredient> actualList = burger.ingredients;

        assertEquals("Number of ingredients before move:" + actualList.size(), expectedList.size(), actualList.size());

        burger.moveIngredient(0, 1);
        expectedList.add(1, expectedList.remove(0));

        assertEquals("Number of ingredients after move:" + actualList.size(), expectedList.size(), actualList.size());

        for (int i = 0; i <= 1; i++) {
            Ingredient expected = expectedList.get(i);
            Ingredient actual = burger.ingredients.get(i);

            assertEquals("Name " + i + "-ingredient is correct", expected.getName(), actual.getName());
            assertEquals("Price " + i + "-ingredient is correct", expected.getPrice(), actual.getPrice(), 0);
            assertEquals("Type " + i + "-ingredient is correct", expected.getType(), actual.getType());
        }
    }

    @Test
    public void getPriceTest() {
        Burger burger = create();

        float bunPrice = 111f;
        float ingredientPrice = 222f;
        when(bun.getPrice()).thenReturn(ingredientPrice);
        when(ingredient.getPrice()).thenReturn(bunPrice);

        assertEquals("Price is correct", (bunPrice + ingredientPrice) * 2, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {

        Burger burger = create();

        when(burger.getPrice()).thenReturn(500f);
        when(ingredient.getName()).thenReturn("barbecue");
        when(ingredient.getType()).thenReturn(SAUCE);
        when(bun.getName()).thenReturn("meat");

        assertEquals("Price is correct",
                format("(==== meat ====)%n") +
                        format("= sauce barbecue =%n") +
                        format("= sauce barbecue =%n") +
                        format("(==== meat ====)%n") +
                        format("%n") +
                        format("Price: 1000,000000%n"),
                burger.getReceipt()
        );

    }

    public Burger create(){
        Burger burger = new Burger();

        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        return burger;
    }
}
