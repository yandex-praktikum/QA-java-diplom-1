import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient cheese;
    @Mock
    Ingredient cutlet;
    @Mock
    Ingredient cheeseSauce;
    @Mock
    Ingredient ketchup;
    @Mock
    Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        burger.addIngredient(cheeseSauce);
        burger.addIngredient(cutlet);
        burger.addIngredient(cheese);

        Mockito.when(bun.getPrice()).thenReturn(1f);
        Mockito.when(cheese.getPrice()).thenReturn(2f);
        Mockito.when(cutlet.getPrice()).thenReturn(3f);
        Mockito.when(cheeseSauce.getPrice()).thenReturn(1.5f);

        Mockito.when(bun.getName()).thenReturn("Кунжутная");
        Mockito.when(cheese.getName()).thenReturn("Чедер");
        Mockito.when(cutlet.getName()).thenReturn("Говяжья");
        Mockito.when(cheeseSauce.getName()).thenReturn("Сырнный соус");

        Mockito.when(cheese.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(cutlet.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(cheeseSauce.getType()).thenReturn(IngredientType.SAUCE);
    }

    @After
    public void shutdown(){
        burger.bun = null;
        burger.ingredients.clear();
    }

    @Test
    public void setBunsSetNotNull(){
        burger.setBuns(bun);
        Assert.assertNotNull("Ожидание: начиличе булочки", burger.bun);
    }

    @Test
    public void addIngredientAddIngredientToList(){
        burger.addIngredient(cheeseSauce);
        Assert.assertEquals("Ожидание: Бургер будет из че 4 ингредиентов", 4 , burger.ingredients.size());
    }

    @Test
    public void removeIngredientDecreaseListSize(){
        burger.removeIngredient(0);
        Assert.assertEquals("Ожидание: бургер будет состоять из 3 ингридиетов", 2, burger.ingredients.size());
       // Assert.assertFalse("Ожидание: бургер без сыра", burger.ingredients.contains(cheese));
    }

    @Test
    public void moveIngredientChangeIngredientIndex(){
        burger.moveIngredient(0, 2);
        Assert.assertEquals("Ожидание: сыр будет на втором месте", 1, burger.ingredients.indexOf(cheese));
    }

    @Test
    public void getPriceReturnSumOfAllIngredients(){
        float ingredientsSum = bun.getPrice()+cheese.getPrice()+cutlet.getPrice()+ ketchup.getPrice();
        burger.setBuns(bun);
        Assert.assertEquals("Цена не соответсвует собраному бургеру", ingredientsSum, burger.getPrice(), 8f);
    }

    @Test
    public void getReceiptReturnAllIngredientsString(){
        String expectedReceipt = "(==== Кунжутная ====)\r\n"+
                "= sauce Сырнный соус =\r\n"+
                "= filling Говяжья =\r\n"+
                "= filling Чедер =\r\n"+
                "(==== Кунжутная ====)\r\n"+
                "\r\n"+
                "Price: 8,500000\r\n";
        burger.setBuns(bun);
        Assert.assertEquals("Невернынй рецепт", expectedReceipt, burger.getReceipt());
    }



}



