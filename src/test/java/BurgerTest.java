import org.junit.Before;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        List<Bun> buns = new ArrayList<>();
        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);
        buns.add(bun);
        int bunsSize = buns.size();
        assertTrue("Число булочек не может быть ноль", bunsSize > 0);
    }


    @Test
    public void addIngredientTest() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        assertTrue("Число ингредиентов не может быть ноль", burger.ingredients.size() > 0);
    }


    @Test
    public void removeIngredientTest() {
        Ingredient ingredient1 = new Ingredient(SAUCE, "Майонез", 7);
        Ingredient ingredient2 = new Ingredient(SAUCE, "Соус кари", 15);
        Ingredient ingredient3 = new Ingredient(FILLING, "Колбаса", 80);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.removeIngredient(1);
        assertEquals("Неверное количество ингредиентов", 2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient1 = new Ingredient(SAUCE, "Майонез", 7);
        Ingredient ingredient2 = new Ingredient(SAUCE, "Соус кари", 15);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        assertNotEquals("Неверный порядок элементов", burger.ingredients.indexOf(ingredient1), burger.ingredients.indexOf(ingredient2));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(20F);
        burger.setBuns(bun);
        float expectedResult = 40F;
        assertEquals("Некорректная стоимость бургера", expectedResult, burger.getPrice(), TestConstant.DELTA);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(ingredient.getName()).thenReturn("Сыр");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);

        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(bun.getPrice()).thenReturn(100F);

        burger.setBuns(bun);

        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedResult.append(String.format("= %s %s =%n", burger.ingredients.get(0).getType().toString().toLowerCase(), burger.ingredients.get(0).getName()));
        expectedResult.append(String.format("(==== %s ====)%n", "Булочка"));
        expectedResult.append(String.format("%nPrice: %f%n", burger.getPrice()));
        assertEquals("Чек отличается от ожидаемого", expectedResult.toString(), burger.getReceipt());
    }
}