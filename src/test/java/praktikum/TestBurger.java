package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static praktikum.DataForTests.*;


@RunWith(MockitoJUnitRunner.class)

public class TestBurger {
    @Mock
    Bun bun;
    @Spy
    Burger burger;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
        assertNotNull(burger.bun);

    }
    @Test
    public void testAddIngredient() {
        assertEquals("Ожидается 0 ингридиентов в списке",0, burger.ingredients.size());
        burger.addIngredient(ingredient1);
        Mockito.verify(burger).addIngredient(ingredient1);
        assertEquals("Ожидается 1 ингридиент в списке",1, burger.ingredients.size());


    }
    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals("Ожидается 2 ингридиента в списке",2, burger.ingredients.size());
        burger.removeIngredient(burger.ingredients.size()-1);
        assertEquals("Ожидается 1 ингридиент в списке",1, burger.ingredients.size());
        burger.removeIngredient(burger.ingredients.size()-1);
        assertEquals("Ожидается 0 ингридиент в списке",0, burger.ingredients.size());

    }
    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals("Ожидается 2 ингридиента в списке",2, burger.ingredients.size());
        assertEquals(ingredient1 ,burger.ingredients.get(0));
        assertEquals(ingredient2 ,burger.ingredients.get(1));
        burger.moveIngredient(0,1);
        assertEquals("Ожидается 2 ингридиента в списке",2, burger.ingredients.size());
        assertEquals(ingredient2 ,burger.ingredients.get(0));
        assertEquals(ingredient1 ,burger.ingredients.get(1));


    }
    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient1.getPrice()).thenReturn(INGREDIENT_ONE_PRICE);
        Mockito.when(ingredient2.getPrice()).thenReturn(INGREDIENT_TWO_PRICE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals("Ожидается стоимость бургера равная "+BURGER_FULL_PRICE,BURGER_FULL_PRICE,burger.getPrice(), 0F);

    }
    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient1.getName()).thenReturn(INGREDIENT_ONE);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getPrice()).thenReturn(INGREDIENT_ONE_PRICE);
        Mockito.when(ingredient2.getName()).thenReturn(INGREDIENT_TWO);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getPrice()).thenReturn(INGREDIENT_TWO_PRICE);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals("Полученный рецепт не соответствует ожидаемому",DataForTests.gatherBurger(),burger.getReceipt());
    }
}