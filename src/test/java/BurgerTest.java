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



@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    private Burger burger;

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "TestNameIngredient", 5.5f);


    @Test
    public void addIngredientTest() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
        System.out.println(ingredient);
        System.out.println(burger.ingredients.get(0));
    }


    @Test
    public void removeIngredientTest() {
        int sizeExpected = 0;
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(sizeExpected, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "TestName2", 10f);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        //System.out.println(burger.ingredients.get(0));
        //System.out.println(burger.ingredients.get(1));
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient, burger.ingredients.get(1));
        //System.out.println(burger.ingredients.get(0));
        //System.out.println(burger.ingredients.get(1));
    }

    @Mock
    public Bun bun;

    @Test
    public void getPriceTest() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "TestName", 5.5f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float priceExpected = 31f;
        Assert.assertEquals(priceExpected, burger.getPrice(),0f);
    }


    @Test
    public void getReceiptTest() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(bun.getName()).thenReturn("TestNameOfBun");
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expectedReceipt = "(====" + bun.getName() + "====)=filling" + ingredient.getName() + "=(====" + bun.getName() + "====)Price:" + String.format("%f", 25.5f);
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, actualReceipt.replaceAll("\r\n?|\n", "").replace(" ", ""));
        System.out.println(expectedReceipt);
    }
}




