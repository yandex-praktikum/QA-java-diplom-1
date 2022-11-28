package Burger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    private final float DELTA = 0.001f;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void gettingBunForBurger() {
        burger.setBuns(bun);
    }

    @Test
    public void addingIngredientInBurger() {
        burger.addIngredient(ingredient);
        assertNotNull(burger.ingredients);
        int size = burger.ingredients.size();
        System.out.println("В списке содержится " + size + " ингредиент(а)");
    }

    @Test
    public void removingIngredientFromBerger() {
        burger.addIngredient(ingredient);
        int index = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(index);
        System.out.println("Список ингредиентов пуст - " + burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientFromBerger() {
        burger.addIngredient(ingredient);
        int indexFirstIngredient = burger.ingredients.indexOf(ingredient);
        Ingredient secondIngredient = new Ingredient(SAUCE, "Котлета", 0.5F);
        burger.addIngredient(secondIngredient);
        int indexSecondIngredient = burger.ingredients.indexOf(secondIngredient);
        burger.moveIngredient(indexSecondIngredient, indexFirstIngredient);
        assertEquals("Данные не совпадают", secondIngredient, burger.ingredients.get(0));
        System.out.println("Теперь в бургере первый ингредиент это - " + burger.ingredients.get(0).getName());
    }

    @Test
    public void getingFullBurgerPrice() {

        float priceBun = 0.25f;
        float priceIngredient = 0.7f;
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(priceBun);
        Ingredient secondIngredient = new Ingredient(SAUCE, "Котлета", 0.5f);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        when(ingredient.getPrice()).thenReturn(priceIngredient);
        float expected = priceBun*2+0.5f+priceIngredient;
        assertEquals("Данные не совпадают", expected, burger.getPrice(), DELTA);
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
    }

    @Test
    public void getingRecipeBurger() {
        float priceBun = 0.25f;
        float priceIngredient = 0.7f;
        Ingredient secondIngredient = new Ingredient(SAUCE, "Кетчуп", 0.1f);
        when(bun.getName()).thenReturn("myFirstBun");
        when(bun.getPrice()).thenReturn(priceBun);
        when(ingredient.getType()).thenReturn(FILLING);
        when(ingredient.getName()).thenReturn("котлета");
        when(ingredient.getPrice()).thenReturn(priceIngredient);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(ingredient, Mockito.times(1)).getType();
        Mockito.verify(ingredient, Mockito.times(1)).getName();
    }
}
