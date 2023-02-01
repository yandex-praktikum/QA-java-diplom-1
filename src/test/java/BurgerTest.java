import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();
    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock;

    //изменение булки
    @Test
    public void setBunsPositiveTestMock(){
        Mockito.when(bunMock.getName()).thenReturn("green bun");
        burger.setBuns(bunMock);
        String bunActual = burger.bun.getName();
        String bunExpected = "green bun";
        Assert.assertEquals(bunExpected,bunActual);
    }

    @Test
    public void setBunsNegativeTestMock(){
        Mockito.when(bunMock.getName()).thenReturn("green bun");
        burger.setBuns(bunMock);
        String bunActual = burger.bun.getName();
        String bunExpected = "red bun";
        Assert.assertNotEquals(bunExpected,bunActual);
    }

    //добавление ингредиента
    @Test
    public void addIngredientTest() {
        Ingredient ingredient = new Ingredient(FILLING, "dinosaur", 200);
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    //удаление ингредиента
    @Test
    public void  removeIngredientTest(){
        burger = BurgerCreated.create();
        Ingredient ingredientTest = new Ingredient(FILLING, "dinosaur", 200);
        burger.addIngredient(ingredientTest);
        int index = 2;
        burger.removeIngredient(index);
        Assert.assertFalse(burger.ingredients.contains(ingredientTest));
        BurgerCreated.delete();
    }

    //перемещение ингредиента
    @Test
    public void moveIngredient(){
        burger = BurgerCreated.create();
        Ingredient ingredientTest = new Ingredient(SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredientTest);
        int index = 2;
        int newIndex = 0;
        burger.moveIngredient(index, newIndex);
        Ingredient actual = burger.ingredients.get(newIndex);
        Assert.assertEquals(ingredientTest, actual);
        BurgerCreated.delete();
    }

    //цена бургера
    @Test
    public void getPriceReturn() {
        Mockito.when(bunMock.getPrice()).thenReturn(100F);
        Mockito.when(ingredientMock.getPrice()).thenReturn(200F);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock);
        float actualPrice = burger.getPrice();
        float expectedPrice = 600;
        Assert.assertEquals(expectedPrice, actualPrice,0);
    }

    //чек для бургера
    @Test
    public void getReceiptReturn() {
        Mockito.when(bunMock.getName()).thenReturn("green bun");
        Mockito.when(ingredientMock.getName()).thenReturn("hot sauce");
        Mockito.when(bunMock.getPrice()).thenReturn(100F);
        Mockito.when(ingredientMock.getPrice()).thenReturn(200F);
        Mockito.when(ingredientMock.getType()).thenReturn(SAUCE);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock);
        String actualReceipt = burger.getReceipt();
      //  System.out.println(actualReceipt);
        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", "green bun", "sauce", "hot sauce", "sauce", "hot sauce", "green bun", 600F);
     //   System.out.println(expectedReceipt);
        Assert.assertEquals(expectedReceipt,actualReceipt);
    }
}