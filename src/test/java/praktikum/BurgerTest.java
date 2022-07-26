package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    Burger burger;
    Ingredient randomIngredient;

    float bunPrice = 100f;
    float ingredientPrice;
    float expectedPrice;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
        randomIngredient = new CreateRandomIngredient().getIngredients();
        ingredientPrice = randomIngredient.getPrice();
        expectedPrice = (bunPrice * 2) + ingredientPrice;
    }

    @Test
    public void setBun() {
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(randomIngredient);

        assertTrue(burger.ingredients.contains(randomIngredient));
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(randomIngredient);
        burger.removeIngredient(burger.ingredients.size() - 1);

        assertFalse(burger.ingredients.contains(randomIngredient));
    }

    @Test
    public void moveIngredient() {
        List<Ingredient> ingredientsList = new ArrayList<>();
        while (burger.ingredients.size() <= 5) {
            randomIngredient = new CreateRandomIngredient().getIngredients();
            burger.ingredients.add(randomIngredient);
            ingredientsList.add(randomIngredient);
        }

        burger.moveIngredient(burger.ingredients.size() - 1, 5);

        assertEquals(burger.ingredients.get(5), ingredientsList.get(5));
    }

    @Test
    public void getPrice() {
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        burger.addIngredient(randomIngredient);

        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        CreateRandomBun randomBun = new CreateRandomBun();

        String bunName = randomBun.getRandomBun().getName();

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        burger.setBuns(bun);

        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200f));

        String expectedReceipt = String.format(("(==== %s ====)%n"), bun.getName()) +
                "= sauce hot sauce =\n" +
                "= sauce chili sauce =\n" +
                "= filling dinosaur =" +
                String.format("%n(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: 800,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
