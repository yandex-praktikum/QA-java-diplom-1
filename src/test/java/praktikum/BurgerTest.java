package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

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
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        addIngredientInList(1);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        addIngredientInList(3);
        burger.removeIngredient(1);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        addIngredientInList(3);
        Ingredient ingredientItem = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredientItem);
        burger.moveIngredient(3, 1);
        assertEquals(ingredientItem, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        addIngredientInList(2);
        assertEquals(600f, burger.getPrice(), 0);
    }


    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot space");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);

        String testBun = getReceiptAndPrice(10, bun.getPrice(), ingredient.getPrice());

        assertEquals(burger.getReceipt(), testBun);

    }

    void addIngredientInList(int index) {
        for (int i = 0; i < index; i++) {
            burger.addIngredient(ingredient);
        }
    }

    float burgerPrice(float bunPrice, float ingredientPrice, int ingredientCount) {
        return bunPrice * 2 + ingredientPrice * ingredientCount;
    }

    private String getReceiptAndPrice(int ingredientCount, float bunPrice, float ingredientPrice) {
        StringBuilder receiptAndPrice = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        addIngredientInList(ingredientCount);
        for (Ingredient ingredient : burger.ingredients) {
            receiptAndPrice.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        float price = burgerPrice(bunPrice, ingredientPrice, ingredientCount);
        receiptAndPrice.append(String.format("(==== %s ====)%n", bun.getName()));
        receiptAndPrice.append(String.format("%nPrice: %f%n", price));

        return receiptAndPrice.toString();
    }
}