import org.junit.Assert;
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
public class BurgerTest {
    Burger burger = new Burger();
    List<Ingredient> ingredientList = burger.ingredients;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Test
    public void setBunTest(){
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }
    @Test
    public void ingredientAddTest(){
        burger.addIngredient(ingredient1);
        Assert.assertFalse("EEEE", burger.ingredients.isEmpty());
        Assert.assertTrue("AAA", burger.ingredients.contains(ingredient1));
    }
    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(2, ingredientList.size());
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredient1, ingredientList.get(1));
        Assert.assertEquals(ingredient2, ingredientList.get(0));
    }
    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(2, ingredientList.size());
        burger.removeIngredient(0);
        Assert.assertEquals(1,ingredientList.size());
    }
    @Test
    public void priceTest(){
        Mockito.when(bun.getPrice()).thenReturn(91F);
        Mockito.when(ingredient1.getPrice()).thenReturn(140F);
        Mockito.when(ingredient2.getPrice()).thenReturn(121F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(3,ingredientList.size());
        float actualPrice = burger.getPrice();
        Assert.assertEquals(583F, actualPrice, 0F);
    }

    @Test
    public void recipeTest(){
        Mockito.when(ingredient1.getName()).thenReturn("Говядина");
        Mockito.when(ingredient2.getName()).thenReturn("Сырный");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getName()).thenReturn("С кунжутом");
        Mockito.when(bun.getPrice()).thenReturn(41F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String expectedRecipe = "(==== С кунжутом ====)\n" + "= filling Говядина =\n"+ "= sauce Сырный =\n" + "(==== С кунжутом ====)\n" + "\n" + "Price: 82,000000\n";
        Assert.assertEquals(expectedRecipe, burger.getReceipt());
    }
}
