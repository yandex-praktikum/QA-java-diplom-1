import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun mockBun;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient newIngredient;

    @Before
    public void startTest() {
        burger = new Burger();
    }

    @Test
    public void checkAddIngredients() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        int ingredientSize = burger.ingredients.size();
        boolean actual = ingredientSize > 0;
        assertTrue("количество ингредиентов должно быть больше 0", actual);
    }

    @Test
    public void checkBunsSet() {
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkDeleteIngredients() {
        Burger burger = new Burger();
        Ingredient ingredient_0 = new Ingredient(SAUCE, "hot sauce", 100);
        Ingredient ingredient_1 = new Ingredient(SAUCE, "sour cream", 200);
        Ingredient ingredient_2 = new Ingredient(SAUCE, "chili sauce", 300);
        burger.addIngredient(ingredient_0);
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        burger.removeIngredient(1);
        int ingredientSize = burger.ingredients.size();
        assertEquals("недопустимое количество ингредиентов", 2, ingredientSize);
    }

    @Test
    public void checkMoveIngredients() {
        burger.addIngredient(ingredient);
        burger.addIngredient(newIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient, burger.ingredients.get(1));

    }

    @Test
    public void checkGetValidPrice() {
        Mockito.when(mockBun.getPrice()).thenReturn(200.4f);
        burger.setBuns(mockBun);
        Float actual = burger.getPrice();
        Float expected = 400.8f;
        assertEquals("Должна быть равна",expected,actual,0.02f);    }

    @Test
    public void checkGetValidReceipt() {
        burger = new Burger();
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);
        Mockito.when(mockBun.getName()).thenReturn("blue bun");
        Mockito.when(mockBun.getPrice()).thenReturn(100F);
        burger.setBuns(mockBun);
        StringBuilder expected = new StringBuilder();
        expected.append(String.format("(==== %s ====)%n",mockBun.getName()));
        expected.append(String.format("= %s %s =%n",burger.ingredients.get(0).getType().toString().toLowerCase(),
                burger.ingredients.get(0).getName()));
        expected.append(String.format("(==== %s ====)%n","blue bun"));
        expected.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String expectedReceipt = expected.toString();
        String actual = burger.getReceipt();
        assertEquals(expectedReceipt,actual);
    }
}
