import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class BurgerMockTest {
    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTestShouldCheckAddingBuns() {
        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);
        Bun actual = burger.bun;
        assertEquals(bun, actual);
    }

    @Test
    public void addIngredientTestShouldAddIngredientToList() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        List<Ingredient> actualList = burger.ingredients;
        List<Ingredient> expectedList = List.of(ingredient);
        assertEquals("Список ингредиентов не изменился", expectedList, actualList);
    }

    @Test
    public void removeIngredientTestShouldRemoveIngredientFromList() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> actualList = burger.ingredients;
        assertEquals("Список ингредиентов не пустой", 0, actualList.size());
    }

    @Test
    public void moveIngredientTestShouldChangeIngredientIndex() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Ingredient newIngredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn("RexBurger");
        burger.addIngredient(ingredient);
        burger.addIngredient(newIngredient);
        burger.moveIngredient(0, 1);
        String expectedIngredient = "RexBurger";
        assertEquals(expectedIngredient, burger.ingredients.get(1).getName());
    }

    @Test
    public void getPriceBunReturnCorrectPrice() {
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        float expectedPrice = 200F;
        assertEquals("Цена считается некорректно", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceiptTestShouldReturnValidReceipt() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(ingredient.getName()).thenReturn("sausage");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt =
                String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("= %s %s =%n", burger.ingredients.get(0).getType().toString().toLowerCase(),
                                burger.ingredients.get(0).getName()) +
                        String.format("(==== %s ====)%n", "red bun") +
                        String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals(expectedReceipt, actualReceipt);
    }
}
