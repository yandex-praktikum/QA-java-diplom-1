package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger;

    @Before
    public void setUp(){

        burger = new Burger();
    }

    @Test
    public void testAddIngredientInBurger(){
        int size =  burger.ingredients.size();
        burger.addIngredient(ingredient);
        assertEquals("Новый ингридиент не добавлен", burger.ingredients.size(), (size + 1));

    }

    @Test
    public void testMoveIngredientBurger(){

        //подготовка данных
        burger.ingredients.add(ingredient);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.ingredients.add(ingredient2);


        burger.moveIngredient(0,1);
        assertEquals("", burger.ingredients.get(0), ingredient2);


    }

    @Test
    public void testRemoveIngredientBurger(){
        //Подготовка данных
        burger.addIngredient(ingredient);

        int size =  burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals("Новый ингридиент не добавлен", burger.ingredients.size(), (size - 1));

    }

    @Test
    public void testGetPriceBurger(){

        burger.setBuns(bun);
        burger.ingredients.add(ingredient);

        float bunPrice = 100.0F;
        float ingredientPrice = 200.0F;

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        float actual = bunPrice * 2 + ingredientPrice;
        float expected = burger.getPrice();

        assertEquals("Цена бургера посчитана неверно", expected, actual, 0);
    }

    @Test
    public void testGetReceiptBurger(){


        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String bunName = "Классическая";
        IngredientType ingredientType = SAUCE;
        String ingredientName = "Соус том-ян";
        float price = 200.0F;

        String actual = String.format("(==== %s ====)%n" +
                "= %s %s =%n" +
                "(==== %s ====)%n" +
                "%nPrice: %f%n" , bunName, ingredientType.toString().toLowerCase(),
                ingredientName, bunName, price);


        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(burger.getPrice()).thenReturn(price);

        String expected = burger.getReceipt();

        System.out.println(actual);
        System.out.println(expected);

        assertEquals("Чек не соответсвует заданному формату", expected, actual);

    }


}
