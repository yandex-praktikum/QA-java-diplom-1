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
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient1;

    @Before
    public void setUp(){
        burger = new Burger();

    }

    @Test
    public void addIngredientTest(){
        int expectedSizeDefault = 0;
        Assert.assertEquals(expectedSizeDefault, burger.ingredients.size());
        burger.addIngredient(ingredient);
        int expectedSize = 1;
        Assert.assertEquals(expectedSize, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        int expectedSize = 0;
        Assert.assertEquals(expectedSize, burger.ingredients.size());
        burger.ingredients.add(ingredient);
        int expectedSizeAfterAdd = 1;
        Assert.assertEquals(expectedSizeAfterAdd, burger.ingredients.size());
        burger.removeIngredient(0);
        Assert.assertEquals(expectedSize, burger.ingredients.size());

    }

    @Test
    public void moveIngredientTest(){
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(1));
        burger.moveIngredient(1,0);
        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn(50F);
        Mockito.when(ingredient.getPrice()).thenReturn(250F);
        burger.setBuns(bun);
        //Цена бургера без ингредиентов
        int expectedPrice = 100;
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
        //Цена бургера с добавлением ингредиентов
        burger.ingredients.add(ingredient);
        int expectedPriceWithIngredient = 350;
        Assert.assertEquals(expectedPriceWithIngredient, burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest(){
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getName()).thenReturn("Кунжутная");
        Mockito.when(ingredient.getName()).thenReturn("Котлета Вкусная");
        burger.setBuns(bun);
        Mockito.when(burger.getPrice()).thenReturn(200F);
        burger.ingredients.add(ingredient);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName()));
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String expected = receipt.toString();
        Assert.assertEquals(expected, burger.getReceipt());
    }


}
