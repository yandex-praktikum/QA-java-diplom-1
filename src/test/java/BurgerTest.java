import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BurgerTest {

    private final Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Test");
        assertEquals("Test", burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getName()).thenReturn("Test");
        Mockito.when(ingredient.getPrice()).thenReturn(100500F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        assertEquals("Test", burger.ingredients.get(0).getName());
        assertTrue(Math.abs(burger.ingredients.get(0).getPrice() - ingredient.getPrice()) < 0.00001);
        assertEquals(IngredientType.FILLING, burger.ingredients.get(0).getType());
    }

    @Test
    public void removeIngredientTest() {
        assertEquals(0, burger.ingredients.size());
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(burger.ingredients.indexOf(ingredient));
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient temp = new Ingredient(IngredientType.FILLING, "Test", 100500);
        Ingredient tempTwo = new Ingredient(IngredientType.SAUCE, "Test2", 100100);
        Ingredient tempThree = new Ingredient(IngredientType.SAUCE, "Test3", 100300);
        burger.addIngredient(temp);
        burger.addIngredient(tempTwo);
        burger.addIngredient(tempThree);
        int oldIndex = burger.ingredients.indexOf(tempThree);
        int newIndex = oldIndex - 1;
        burger.moveIngredient(oldIndex, newIndex);
        assertEquals(newIndex, burger.ingredients.indexOf(tempThree));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(true,Math.abs((bun.getPrice() * 2 + ingredient.getPrice())
                - burger.getPrice()) < 0.00001);
    }

    @Test
    public void getReceiptTest() {
        StringBuilder receiptExpect = new StringBuilder();

        Mockito.when(bun.getName()).thenReturn("Test");
        Mockito.when(ingredient.getName()).thenReturn("Test");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String header = String.format("(==== %s ====)%n", bun.getName());
        String price = String.format("%nPrice: %f%n", burger.getPrice());
        String ingredient = String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(), "Test");

        receiptExpect.append(header);
        receiptExpect.append(ingredient);
        receiptExpect.append(header);
        receiptExpect.append(price);
        assertEquals(receiptExpect.toString(), burger.getReceipt());
    }
}
