package praktikumTest;

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

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;
    @Mock
    Ingredient ingredient4;
    @Mock
    Ingredient ingredient5;
    @Mock
    Ingredient ingredient6;
    @Mock
    Bun bun1;
    @Mock
    Bun bun2;

    @Before
    public void createInstanceOfBunAndIngredients() {
        burger = new Burger();
        Mockito.when(bun1.getName()).thenReturn("wheat bread");
        Mockito.when(bun1.getPrice()).thenReturn(2.45f);

        Mockito.when(bun2.getName()).thenReturn("rice bread");

        Mockito.when(ingredient1.getType()).thenReturn(FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("salad");
        Mockito.when(ingredient1.getPrice()).thenReturn(0.54f);

        Mockito.when(ingredient2.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient2.getName()).thenReturn("mustard");
        Mockito.when(ingredient2.getPrice()).thenReturn(0.24f);

        Mockito.when(ingredient3.getType()).thenReturn(FILLING);
        Mockito.when(ingredient3.getName()).thenReturn("cucumber");
        Mockito.when(ingredient3.getPrice()).thenReturn(0.14f);

        Mockito.when(ingredient4.getType()).thenReturn(FILLING);
        Mockito.when(ingredient4.getName()).thenReturn("beef");
        Mockito.when(ingredient4.getPrice()).thenReturn(2.21f);

        Mockito.when(ingredient5.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient5.getName()).thenReturn("ketchup");
        Mockito.when(ingredient5.getPrice()).thenReturn(0.04f);

        Mockito.when(ingredient6.getName()).thenReturn("hen");

        burger.setBuns(bun1);
        burger.addIngredient(ingredient1); //salad
        burger.addIngredient(ingredient4); //beef
        burger.addIngredient(ingredient2); //mustard
        burger.addIngredient(ingredient3); //cucumber
        burger.addIngredient(ingredient5); //ketchup
    }

    @Test
    public void setBunTest() {

        Burger burger2 = new Burger();
        burger2.setBuns(bun2);
        Assert.assertEquals("rice bread", burger2.bun.getName());
    }

    @Test
    public void getBurgerPriceTest() {

        Assert.assertEquals(8.07f, burger.getPrice(), 0.0);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient6);
        Assert.assertEquals("hen", burger.ingredients.get(5).getName());
    }
    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        Assert.assertEquals(4, burger.ingredients.size());
    }

    @Test
    public void removeNoneExistingIngredient() {
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
    public void moveIngredientToOutOfRangePositionTest() {
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
        Assert.assertEquals("(==== wheat bread ====)\n" +
                "= filling salad =\n" +
                "= filling beef =\n" +
                "= sauce mustard =\n" +
                "= filling cucumber =\n" +
                "= sauce ketchup =\n" +
                "(==== wheat bread ====)\n" +
                "\nPrice: 8.070000\n", burger.getReceipt());
    }
}
