import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient anotherIngredient;

    //
    @Test // тест выбора булочки
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
        burger.removeIngredient(0);
    }

    @Test // тест добавления ингридиента
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
    }

    @Test // тест удаления ингридиента
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());

    }

    @Test // тест перемещения ингридента
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(1, 0);
        assertEquals(ingredient, Burger.ingredients.get(0));
        burger.removeIngredient(0);
        burger.removeIngredient(0);

    }

    @Test // тест получения цены бургера
    public void getPriceBurgerTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(bun.getPrice()).thenReturn(200F);
        when(ingredient.getPrice()).thenReturn(100F);
        assertEquals(500, burger.getPrice(), 0);
        burger.removeIngredient(0);
    }

    @Test // тест получения рецепта бургера
    public void getReceiptBurgerTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);

        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100F);

        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn("hot sauce");
        when(ingredient.getPrice()).thenReturn(100F);

        when(anotherIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(anotherIngredient.getName()).thenReturn("dinosaur");
        when(anotherIngredient.getPrice()).thenReturn(200F);

        String expected =
                "(==== black bun ====)\r\n" +
                        "= sauce hot sauce =\r\n" +
                        "= filling dinosaur =\r\n" +
                        "(==== black bun ====)\r\n" +
                        "\r\n" +
                        "Price: 500,000000\r\n";
        String actual = burger.getReceipt();

        assertEquals(expected, actual);
        burger.removeIngredient(0);
    }
}
