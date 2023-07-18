import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;


    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient ingredient2;

    private Burger burger;

    @Before
    public void prepareData() {
        burger = Mockito.spy(new Burger());
        Mockito.when(bun.getName()).thenReturn(TestData.BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(TestData.BUN_PRICE);

        Mockito.when(ingredient.getName()).thenReturn(TestData.INGREDIENT_NAME);
        Mockito.when(ingredient.getType()).thenReturn(TestData.INGREDIENT_TYPE);
        Mockito.when(ingredient.getPrice()).thenReturn(TestData.INGREDIENT_PRICE);

        Mockito.when(ingredient2.getName()).thenReturn(TestData.INGREDIENT_NAME2);
        Mockito.when(ingredient2.getType()).thenReturn(TestData.INGREDIENT_TYPE2);
        Mockito.when(ingredient2.getPrice()).thenReturn(TestData.INGREDIENT_PRICE2);
    }


    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
        assertEquals("Имя для Bun неверное.", TestData.BUN_NAME, burger.bun.getName());
        assertEquals("Цена для Bun неверная.", TestData.BUN_PRICE, burger.bun.getPrice());
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredient);
        assertEquals("Неверный размер массива ingredients.", 1, burger.ingredients.size());
        assertEquals("Имя для Ingredient неверен.", TestData.INGREDIENT_NAME, burger.ingredients.get(0).getName());
        assertEquals("Цена для Ingredient неверен.", TestData.INGREDIENT_PRICE, burger.ingredients.get(0).getPrice());
        assertEquals("Тип для Ingredient неверен.", TestData.INGREDIENT_TYPE, burger.ingredients.get(0).getType());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(0);
        assertEquals("Неверный размер массива ingredients.", 0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Mockito.verify(burger, Mockito.times(1)).moveIngredient(0, 1);
        assertEquals("Неверный размер массива ingredients.", 2, burger.ingredients.size());
        assertEquals("Имя для Ingredient неверен.", TestData.INGREDIENT_NAME, burger.ingredients.get(1).getName());
        assertEquals("Цена для Ingredient неверен.", TestData.INGREDIENT_PRICE, burger.ingredients.get(1).getPrice());
        assertEquals("Тип для Ingredient неверен.", TestData.INGREDIENT_TYPE, burger.ingredients.get(1).getType());
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        float actual = burger.getPrice();
        float expected = bun.getPrice() * 2 + ingredient.getPrice() + ingredient2.getPrice();
        Mockito.verify(burger, Mockito.times(1)).getPrice();
        assertEquals("Неверная цена.", expected, actual);
    }


    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        String expected = "(==== The bun ====)\n" +
                "= filling Котлета =\n" +
                "= sauce Кепчуп =\n" +
                "(==== The bun ====)\n" +
                "\n" +
                "Price: 13,440000\n";
        String actual = burger.getReceipt();
        Mockito.verify(burger, Mockito.times(1)).getReceipt();
        assertEquals("Неверный рецепт.", expected, actual);
    }

}
