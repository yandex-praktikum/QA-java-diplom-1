import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    Burger burger = new Burger();

    @Mock
    Ingredient ingredient;


    @Test
    public void addIngredientPutElementInIngredientList(){
        Assert.assertEquals(0, burger.ingredients.size());
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void setBunSetActualBun(){
        Bun bunTest = new Bun("Test", 10);
        burger.setBuns(bunTest);
        Assert.assertEquals("Test", burger.bun.getName());
        Assert.assertEquals(10, burger.bun.getPrice(), 0);
    }

    @Test
    public void removeIngredientRemoveItemFromIngredientList(){
        Assert.assertEquals(0, burger.ingredients.size());
        burger.ingredients.add(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientRemoveCurrentIndexItemAndAddNewIndexItem(){
        for(int i = 0; i < 3; i++){
            burger.ingredients.add(new Ingredient(SAUCE, "Test"+i, 1+i));
        }
        Assert.assertEquals(3, burger.ingredients.size());
        Assert.assertEquals(1, burger.ingredients.get(0).price, 0);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(2, burger.ingredients.get(0).price, 0);
    }

    @Test
    public void getReceiptReturnCorrectReceipt(){
        Bun bun = new Bun("TestBun", 50);
        Ingredient ingredient1 = new Ingredient(SAUCE, "TestSauce", 10);
        Ingredient ingredient2 = new Ingredient(FILLING, "TestFilling", 20);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        MatcherAssert.assertThat(burger.getReceipt(), startsWith("(==== TestBun ====)"));
        MatcherAssert.assertThat(burger.getReceipt(), containsString("= sauce TestSauce ="));
        MatcherAssert.assertThat(burger.getReceipt(), containsString("= filling TestFilling ="));
        MatcherAssert.assertThat(burger.getReceipt(), containsString("Price: 130,000000"));
    }
}
