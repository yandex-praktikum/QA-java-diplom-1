package praktikumTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    private List<Bun> buns = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();

    @Mock
    Database db;

    @Before
    public void createInstanceOfBunAndIngredients() {
        burger = new Burger();
        buns.add(new Bun("wheat bun", 2.45f));
        buns.add(new Bun("rice bread", 1.09f));
        ingredients.add(new Ingredient(FILLING, "salad", 0.54f));
        ingredients.add(new Ingredient(SAUCE, "mustard", 0.24f));
        ingredients.add(new Ingredient(FILLING, "cucumber", 0.14f));
        ingredients.add(new Ingredient(FILLING, "beef ", 2.21f));
        ingredients.add(new Ingredient(SAUCE, "ketchup", 0.04f));
        ingredients.add(new Ingredient(FILLING, "hen", 1.68f));
        Mockito.when(db.availableBuns()).thenReturn(buns);
        Mockito.when(db.availableIngredients()).thenReturn(ingredients);

        burger.setBuns(db.availableBuns().get(0));
        burger.addIngredient(db.availableIngredients().get(0)); //salad
        burger.addIngredient(db.availableIngredients().get(3)); //beef
        burger.addIngredient(db.availableIngredients().get(1)); //mustard
        burger.addIngredient(db.availableIngredients().get(2)); //cucumber
        burger.addIngredient(db.availableIngredients().get(4)); //ketchup
    }

    @Test
    public void setBunTest() {
        Burger burger2 = new Burger();
        Mockito.when(db.availableBuns()).thenReturn(buns);
        burger2.setBuns(db.availableBuns().get(1));
        Assert.assertEquals("rice bread", burger2.bun.getName());
    }
    @Test
    public void getBurgerPriceTest() {
        Assert.assertEquals(8.07f, burger.getPrice(), 0.0);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(db.availableIngredients().get(5));
        Assert.assertEquals("hen", burger.ingredients.get(5).getName());
    }
    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        Assert.assertEquals(4, burger.ingredients.size());
    }
    @Test
    public void removeNoneExistingIngredient() throws Exception {
        try {
            burger.removeIngredient(5);
            Assert.fail("Ожидалось появление исключения");}
        catch (IndexOutOfBoundsException e) {
            Assert.assertEquals("Index 5 out of bounds for length 5", e.getMessage());
        }
    }
    @Test
    public void moveIngredientsTest() {
        burger.moveIngredient(0, 3);
        Assert.assertEquals("salad", burger.ingredients.get(3).getName());
    }
    @Test
    public void moveIngredientToOutOfRangePositionTest() throws Exception {
        try {
            burger.moveIngredient(1, 5);
            Assert.fail("Ожидалось появление исключения");}
        catch (IndexOutOfBoundsException e) {
            Assert.assertEquals("Index: 5, Size: 4", e.getMessage());
        }
    }
    @Test
    public void quantityReceiptLinesTest() {
        int count =0;
        for (int i=0; i < burger.getReceipt().length(); i++) {
            if (burger.getReceipt().charAt(i) == '\n') {
                count++;
                }
            }
        Assert.assertEquals(9, count);
        }
    @Test
    public void compareFinalResult() {
        Assert.assertEquals("(==== wheat bun ====)\n" +
                "= filling salad =\n" +
                "= filling beef  =\n" +
                "= sauce mustard =\n" +
                "= filling cucumber =\n" +
                "= sauce ketchup =\n" +
                "(==== wheat bun ====)\n" +
                "\nPrice: 8.070000\n", burger.getReceipt());
    }

}
