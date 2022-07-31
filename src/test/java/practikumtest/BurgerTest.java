package practikumtest;

import org.junit.*;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    Burger burger;

    Ingredient ingredientSauceOne = new Ingredient(SAUCE, "Соус Spicy-X", 99.99f);
    Ingredient ingredientSauceTwo = new Ingredient(SAUCE, "Соус традиционный галактический", 17.00f);
    Ingredient ingredientFilling = new Ingredient(FILLING, "Мини-салат Экзо-Плантаго", 3333.33f);
    Bun bun = new Bun("Краторная булка N-200i", 1333.00f);

    @Before
    public void setUp() {
        burger = new Burger();
        burger.addIngredient(ingredientSauceOne);
        burger.addIngredient(ingredientSauceTwo);
        burger.addIngredient(ingredientFilling);
        burger.setBuns(bun);
    }

    //Проверка, что метод возвращает ингредиенты
    @Test
    public void addIngredientsTest() {
        assertEquals(burger.ingredients.get(0), ingredientSauceOne);
        assertEquals(burger.ingredients.get(1), ingredientSauceTwo);
        assertEquals(burger.ingredients.get(2), ingredientFilling);
    }

    //Проверка, что метод возвращает булку
    @Test
    public void addBunTest() {
        Assert.assertEquals(burger.bun, bun);
    }

    //Проверка, что метод возвращает
    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);                                         //Удаляем первый ингредиент
        assertEquals(burger.ingredients.get(0), ingredientSauceTwo);        //Проверяем что второй ингредиент стал первым
    }

    //Проверка перемещения ингредиентов в бургере
    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(0, 2);                                        //Меняем местами ингредиенты
        assertEquals(burger.ingredients.get(0), ingredientSauceTwo);
        assertEquals(burger.ingredients.get(2), ingredientSauceOne);
    }
}