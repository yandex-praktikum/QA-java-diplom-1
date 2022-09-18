package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient secondIngredient;

    @Test
    public void setBunsExpectedBunField() throws NoSuchFieldException, IllegalAccessException {
        Burger burger = new Burger();
        burger.setBuns(bun);

        Field field = burger.getClass().getDeclaredField("bun");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(burger), bun);
    }

    @Test
    public void addIngredientTwiceExpectedIngredientsField() throws NoSuchFieldException, IllegalAccessException {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);

        Field field = burger.getClass().getDeclaredField("ingredients");
        field.setAccessible(true);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        ingredients.add(secondIngredient);

        assertEquals("Fields didn't match", ingredients, field.get(burger));
    }

    @Test
    public void removeIngredientWithTwoIngredientOnlyOne() throws NoSuchFieldException, IllegalAccessException {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);

        Field field = burger.getClass().getDeclaredField("ingredients");
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(secondIngredient);

        assertEquals(
                "Список для проверки не совпадает с ожидаемым результатом",
                ingredients,
                field.get(burger));
    }

    @Test
    public void moveIngredientWithTwoIngredientSwitchIngredient() throws NoSuchFieldException, IllegalAccessException {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);

        Field field = burger.getClass().getDeclaredField("ingredients");

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(secondIngredient);
        ingredients.add(ingredient);

        assertEquals(
                "Список для проверки не совпадает с ожидаемым результатом",
                ingredients,
                field.get(burger));

    }

    @Test
    public void getPriceWithBunIngredientCalculatePrice() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn((float) 20);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 20);

        assertEquals("Цена не совпадает с ожидаемой", 60 , burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptWithBunIngredientGeneratePrice() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(ingredient.getName()).thenReturn("Мясо бессмертных моллюсков Protostomia");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(burger.getPrice()).thenReturn((float) 20);

        String expectedReceipt = "(==== Флюоресцентная булка R2-D3 ====)\n"
                + "= filling Мясо бессмертных моллюсков Protostomia =\n"
                + "(==== Флюоресцентная булка R2-D3 ====)\n"
                + "\nPrice: 20,000000\n";

        assertEquals("Рецепт составлен неправильно", expectedReceipt, burger.getReceipt());
    }
}