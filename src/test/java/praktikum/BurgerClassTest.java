package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static  praktikum.IngredientType.SAUCE;
import static  praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerClassTest {

    private Burger burger;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;

    @Mock
    Ingredient ingredientThree;

    @Test
    //проверить выбор булочки
    public void checkSetBun() {
        burger.setBuns(bun);
        assertEquals("Проблемы с параметром bun класса Berger", bun,burger.bun);
    }

    @Test
    //проверить добавление ингредиента
    public void checkAddIngredient(){
        burger.addIngredient(ingredientOne);
        assertTrue("Ошибка в методе addIngredient класса Burger", burger.ingredients.contains(ingredientOne));
    }

    @Test
    //проверить удаление ингредиента
    public void checkRemoveIngredient(){
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(burger.ingredients.indexOf(ingredientOne));
        assertFalse("Ошибка в методе removeIngredient класса Burger", burger.ingredients.contains(ingredientOne));
    }

    @Test
    //проверить перемешивание ингредиентов
    public void checkMoveIngredient(){
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        int indexIngredientOne = burger.ingredients.indexOf(ingredientOne);
        int indexIngredientTwo = burger.ingredients.indexOf(ingredientTwo);
        burger.moveIngredient(indexIngredientOne, indexIngredientTwo);
        assertEquals( "Ошибка в методе moveIngredient класса Burger", ingredientOne, burger.ingredients.get(indexIngredientTwo));
    }

    @Test
    //проверить получение цены бургера
    public void checkGetPrice(){
        Mockito.when(bun.getPrice()).thenReturn(45F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(25F);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(10F);

        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientTwo);

        assertEquals("Ошибка в методе getPrice класса Burger", 160, burger.getPrice(), 1e-8);
    }

    @Test
    //проверить чек
    public void checkGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("White bun");
        Mockito.when(bun.getPrice()).thenReturn(45F);
        Mockito.when(ingredientOne.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientOne.getName()).thenReturn("Chili");
        Mockito.when(ingredientOne.getPrice()).thenReturn(10F);
        Mockito.when(ingredientTwo.getType()).thenReturn(FILLING);
        Mockito.when(ingredientTwo.getName()).thenReturn("Cheese");
        Mockito.when(ingredientTwo.getPrice()).thenReturn(35F);
        Mockito.when(ingredientThree.getType()).thenReturn(FILLING);
        Mockito.when(ingredientThree.getName()).thenReturn("Tomato");
        Mockito.when(ingredientThree.getPrice()).thenReturn(20F);

        String stringExpected = (String.format("(==== White bun ====)%n" +
                "= sauce Chili =%n" +
                "= filling Cheese =%n" +
                "= filling Cheese =%n" +
                "= filling Tomato =%n" +
                "= filling Tomato =%n" +
                "= filling Tomato =%n" +
                "(==== White bun ====)%n" +
                "%n" +
                "Price: 230,000000%n"));


        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);
        burger.addIngredient(ingredientThree);
        burger.addIngredient(ingredientThree);

        assertEquals("Ошибка в методе getReceipt класса Burger", stringExpected, burger.getReceipt());
    }

    @Test
    //проверить пустой чек
    public void checkGetReceiptIsZero() {
        Mockito.when(bun.getName()).thenReturn("");
        Mockito.when(bun.getPrice()).thenReturn(0F);

        String stringExpected = (String.format("(====  ====)%n" +
                "(====  ====)%n" +
                "%n" +
                "Price: 0,000000%n"));

        burger.setBuns(bun);
        assertEquals("Ошибка в методе getReceipt класса Burger", stringExpected, burger.getReceipt());
    }
}
