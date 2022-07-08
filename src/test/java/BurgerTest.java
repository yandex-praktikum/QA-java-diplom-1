import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        System.out.println(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    private void countIngredients(int count) {
        for (int i = 1; i <= count; i++) {
            ingredient.price = i;
            burger.addIngredient(ingredient);
        }
    }

    @Test
    public void testAddIngredient() {
        countIngredients(5);
        int expected = 5;
        int actual = burger.ingredients.size();
        System.out.println(burger.ingredients.size());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveIngredient() {
        burger.setBuns(bun);
        countIngredients(3);
        burger.removeIngredient(1);
        int expectedSize = 2;
        int actualSize = burger.ingredients.size();
        int expectedPrice = 3;
        float actualPrice = burger.ingredients.get(0).price;
        System.out.println(burger.ingredients.size());
        System.out.println(burger.ingredients.get(0).price);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void testMoveIngredient() {
        burger.setBuns(bun);
        countIngredients(3);
        int oldIndex = 0;
        int newIndex = 2;
        int expected = 3;
        burger.moveIngredient(oldIndex, newIndex);
        float actual = burger.ingredients.get(2).price;
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        countIngredients(5);
        Mockito.when(bun.getPrice()).thenReturn(66.55f);
        float expectedBunPrice = 66.55f;
        float actualBunPrice = bun.getPrice();
        Mockito.when(ingredient.getPrice()).thenReturn(99.99f);
        float expectedIngredientPrice = 99.99f;
        float actualIngredientPrice = ingredient.getPrice();
        System.out.println(burger.getPrice());
        Assert.assertEquals(expectedBunPrice, actualBunPrice, 0);
        Assert.assertEquals(expectedIngredientPrice, actualIngredientPrice, 0);
    }


}