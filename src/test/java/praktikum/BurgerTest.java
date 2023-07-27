package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    IngredientType ingredientType1;
    @Mock
    IngredientType ingredientType2;
    @Mock
    Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals("Булочка не соответствует ожидаемой", bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient1);
        assertTrue("Ингридиент не найден в составе бургера", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertFalse("Ингридиент найден в составе бургера", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);

        assertEquals("Ингридиент не соответствует ожидаемому", ingredient1, burger.ingredients.get(1));
        assertEquals("Ингридиент не соответствует ожидаемому", ingredient2, burger.ingredients.get(0));
    }


    @Test
    public void getPrice() {
        float priceBun = 50f;
        float price1 = 25.60f;
        float price2 = 48.10f;
        float expectedPrice = 2*priceBun + price1 + price2;

        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(ingredient1.getPrice()).thenReturn(price1);
        Mockito.when(ingredient2.getPrice()).thenReturn(price2);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals("Цена не соответствует ожидаемой", expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void getReceipt() {
        Mockito.when(bun.getName()).thenReturn("Peanut bun");
        Mockito.when(ingredientType1.toString()).thenReturn("FILLING");
        Mockito.when(ingredientType2.toString()).thenReturn("SAUCE");
        Mockito.when(ingredient1.getName()).thenReturn("Unicorn kebab");
        Mockito.when(ingredient2.getName()).thenReturn("Salsa");
        Mockito.when(ingredient1.getType()).thenReturn(ingredientType1);
        Mockito.when(ingredient2.getType()).thenReturn(ingredientType2);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expected1 = """
                (==== Peanut bun ====)\r
                = filling Unicorn kebab =\r
                = sauce Salsa =\r
                (==== Peanut bun ====)\r
                \r
                Price: 0,000000\r
                """;

        assertEquals("Рецепт не соответствует ожидаемому", expected1, burger.getReceipt());
    }
}