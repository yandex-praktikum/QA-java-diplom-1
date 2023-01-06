package praktikumTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    private Burger burger;

    @Before
    public void createInstanceOfBunAndIngredients() {
        burger = new Burger();
        Bun bun = new Bun("wheat bun", 2.45f);
        Ingredient ingredient1 = new Ingredient(FILLING, "salad", 0.54f);
        Ingredient ingredient2 = new Ingredient(SAUCE, "mustard", 0.24f);
        Ingredient ingredient3 = new Ingredient(FILLING, "cucumber", 0.14f);
        Ingredient ingredient4 = new Ingredient(FILLING, "beef ", 2.21f);
        Ingredient ingredient5 = new Ingredient(SAUCE, "ketchup", 0.04f);


        burger.setBuns(bun);
        burger.addIngredient(ingredient1); //salad
        burger.addIngredient(ingredient4); //beef
        burger.addIngredient(ingredient2); //mustard
        burger.addIngredient(ingredient3); //cucumber
        burger.addIngredient(ingredient5); //ketchup
    }

    @Test
    public void setBunTest() {
        Burger burger2 = new Burger();
        Bun bun2 = new Bun("rice bread", 1.09f);
        burger2.setBuns(bun2);
        Assert.assertEquals("rice bread", burger2.bun.getName());
    }
    @Test
    public void getBurgerPriceTest() {

        Assert.assertEquals(8.07f, burger.getPrice(), 0.0);
    }
    @Test
    public void addIngredientTest() {
        Ingredient ingredient6 = new Ingredient(FILLING, "hen", 1.68f);
        burger.addIngredient(ingredient6);

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
