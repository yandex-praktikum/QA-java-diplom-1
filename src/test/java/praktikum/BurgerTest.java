package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    IngredientType ingredientType;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;


    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        // Создание списка ингредиентов
        Ingredient tomato = new Ingredient(IngredientType.SAUCE, "TOMATO", 1234);
        burger.addIngredient(tomato);
        assertEquals("TOMATO", tomato.name);
        assertEquals(1234, tomato.price, 0.0);
    }

    @Test
    public void removeIngredient() {
        // Создание списка ингредиентов
        Ingredient tomato = new Ingredient(IngredientType.SAUCE, "TOMATO", 1234);
        burger.addIngredient(tomato);
        Ingredient mayonnaise = new Ingredient(IngredientType.SAUCE, "MAYONNAISE", 5678);
        burger.addIngredient(mayonnaise);
        // Проверка, что есть 2 элемента в списке. Для tomato индекс 0, для mayonnaise 1
        assertEquals(2, burger.ingredients.size());
        assertEquals("TOMATO", burger.ingredients.get(0).name);
        assertEquals(1234, burger.ingredients.get(0).price, 0.0);
        assertEquals("MAYONNAISE", burger.ingredients.get(1).name);
        assertEquals(5678, burger.ingredients.get(1).price, 0.0);
        // Вызов метода removeIngredient с индексом первого элемента
        burger.removeIngredient(0);
        // Проверка, что количество элементов уменьшилось на 1
        assertEquals(1, burger.ingredients.size());
        // Проверка, что остался ингредиент "mayonnaise" и у него сменился индекс на 0 и что не осталось "tomato"
        assertEquals("MAYONNAISE", burger.ingredients.get(0).name);
        assertEquals(5678, burger.ingredients.get(0).price, 0.0);
        assertNotEquals("TOMATO", burger.ingredients.get(0).name);
        assertNotEquals(1234, burger.ingredients.get(0).price, 0.0);
    }

    @Test
    public void moveIngredient() {
        // Создание списка ингредиентов
        Ingredient tomato = new Ingredient(IngredientType.SAUCE, "TOMATO", 1234);
        burger.addIngredient(tomato);
        Ingredient mayonnaise = new Ingredient(IngredientType.SAUCE, "MAYONNAISE", 5678);
        burger.addIngredient(mayonnaise);
        // Проверка, что есть 2 элемента в списке. Для tomato индекс 0, для mayonnaise 1
        assertEquals(2, burger.ingredients.size());
        assertEquals("TOMATO", burger.ingredients.get(0).name);
        assertEquals(1234, burger.ingredients.get(0).price, 0.0);
        assertEquals("MAYONNAISE", burger.ingredients.get(1).name);
        assertEquals(5678, burger.ingredients.get(1).price, 0.0);
        // Смена индекса
        burger.moveIngredient(0,1);
        // Проверка, что так же осталось 2 элемента в списке. Для tomato индекс сменился на 1, для mayonnaise на 0
        assertEquals(2, burger.ingredients.size());
        assertEquals("TOMATO", burger.ingredients.get(1).name);
        assertEquals(1234, burger.ingredients.get(1).price, 0.0);
        assertEquals("MAYONNAISE", burger.ingredients.get(0).name);
        assertEquals(5678, burger.ingredients.get(0).price, 0.0);
    }

    @Test
    public void getPrice() {
        // Подкладываем значение
        Mockito.when(bun.getPrice()).thenReturn(25F);
        // Создаём булку
        burger.setBuns(bun);
        // Подкладываем значение
        Mockito.when(ingredient.getPrice()).thenReturn(30F);
        // Создаём ингредиент
        burger.addIngredient(ingredient);
        // Проверяем формулу 25*2+30 = 80
        assertEquals(80, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceipt() {
        // Подкладываем значения
        Mockito.when(bun.getName()).thenReturn("Булка");
        Mockito.when(bun.getPrice()).thenReturn(25F);
        Mockito.when(ingredient.getName()).thenReturn("Tomato");
        Mockito.when(ingredient.getPrice()).thenReturn(30F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        // Создаём булку
        burger.setBuns(bun);
        // Создаём ингредиент
        burger.addIngredient(ingredient);

        StringBuilder expected = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        expected.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName()));
        expected.append(String.format("(==== %s ====)%n", bun.getName()));
        expected.append(String.format("%nPrice: %f%n", burger.getPrice()));
        System.out.println(expected);
        System.out.println(burger.getReceipt());
        assertEquals("Проверка рецепта",expected.toString(),burger.getReceipt());

    }
}