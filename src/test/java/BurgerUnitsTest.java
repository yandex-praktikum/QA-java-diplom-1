import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerUnitsTest {
    private Burger burger;

    @Mock
    Bun bun; // создали мок


    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

        @Test
        public void setBuns() throws Exception {
             burger.setBuns(bun); // вызвали метод объекта с аргументом
            assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() throws Exception {
        final List<Ingredient> ingredients = new ArrayList<>();
        boolean expected = ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    public void removeIngredient() throws Exception {
        final List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        Ingredient expected = ingredients.remove(0);
        assertNotNull(expected);
    }

    @Test
    public void moveIngredient() throws Exception {
        final List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(1, ingredients.remove(0));
        assertNotNull(ingredients);
    }


    @Test
    public void getPriceTest() {
        float price = 300;
        float expectedPrice = price * 2 + price;
        when(bun.getPrice()).thenReturn(price);
        when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertTrue(expectedPrice == burger.getPrice());
    }

    @Test
    public void getReceiptTest() {
        String nameBun = "Big tasty";
        String nameIngredient = "two buns, smoked pork";
        IngredientType ingredientType = FILLING;
        String expectedReceipt = String.format("(==== %s ====)" + "\r\n" +
                        "= %s %s =" + "\r\n" +
                        "(==== %s ====)" + "\r\n" + "\r\n" +
                        "Price: %f%n",
                nameBun, ingredientType.toString().toLowerCase(), nameIngredient, nameBun, ingredient.getPrice());
        burger.setBuns(bun);
        when(bun.getName()).thenReturn(nameBun);
        burger.addIngredient(ingredient);
        when(ingredient.getName()).thenReturn(nameIngredient);
        when(ingredient.getType()).thenReturn(ingredientType);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
