import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    Burger burger;

    public Ingredient mockIngredient(IngredientType type, String name, float price) {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getType()).thenReturn(type);
        when(ingredient.getName()).thenReturn(name);
        when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }

    public Bun mockBun(String name, float price) {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn(name);
        when(bun.getPrice()).thenReturn(price);
        return bun;
    }

    @Mock
    Bun bun = mockBun("black-red bun", 290.0F);
    Ingredient ingredient = mockIngredient(FILLING, "sausage", 200.0F);
    Ingredient secondIngredient = mockIngredient(SAUCE, "sour cream", 300.0F);

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        assertEquals( 2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals( 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.setBuns(bun);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        assertEquals( ingredient, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals( 780, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.getPrice();
        String expected = String.format("(==== black-red bun ====)%n" +
                "= filling sausage =%n" +
                "(==== black-red bun ====)%n" +
                "%n" +
                "Price: 780,000000%n");
        assertEquals( expected, burger.getReceipt());
    }
}