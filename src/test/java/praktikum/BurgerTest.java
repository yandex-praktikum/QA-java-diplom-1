package praktikum;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    Database database = new Database();
    final int TOTAL_INGREDIENT_AMOUNT = database.availableIngredients().size();

    @Before
    public void startUp() {
        burger = new Burger();
    }

    @Mock
    private Bun mockBun;

    @Test
    public void addIngredientTest(){
        for(int i = 0; i < TOTAL_INGREDIENT_AMOUNT; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        int actualAmount = burger.ingredients.size();
        assertEquals("Amount of ingredients is not equivalent",TOTAL_INGREDIENT_AMOUNT, actualAmount);

    }

    @Test
    public void removeIngredientTest(){
        for(int i = 0; i < TOTAL_INGREDIENT_AMOUNT; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        burger.removeIngredient(TOTAL_INGREDIENT_AMOUNT-1);
        int actualAmount = burger.ingredients.size();
        assertEquals("Ingredient is not removed",TOTAL_INGREDIENT_AMOUNT-1, actualAmount);
    }

    @Test
    public void moveIngredientTest(){
        for(int i = 0; i < TOTAL_INGREDIENT_AMOUNT; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        Ingredient recentIngredient = burger.ingredients.get(TOTAL_INGREDIENT_AMOUNT-1);
        burger.moveIngredient(TOTAL_INGREDIENT_AMOUNT-1, 0);
        assertEquals("Ingredient is not moved", burger.ingredients.get(0), recentIngredient);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(mockBun);
        when(mockBun.getPrice()).thenReturn(200f);
        burger.addIngredient(database.availableIngredients().get(1));
        float expectedPrice = 2*200+database.availableIngredients().get(1).getPrice();
        float actualPrice = burger.getPrice();
        assertEquals("Burger's price calculated incorrectly",expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(mockBun);
        burger.addIngredient(database.availableIngredients().get(0));
        String firstIngredient = database.availableIngredients().get(0).getName();
        when(mockBun.getName()).thenReturn("Bun");
        assertTrue("Receipt contains invalid data",burger.getReceipt().contains("Bun")
                &&burger.getReceipt().contains(firstIngredient));

    }
}
