import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
@Mock
Bun bun;
@Mock
Ingredient ingredient;

    public String getActualReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== Gary ====)%n"));
        receipt.append(String.format("= sauce Колбаса =%n"));
        receipt.append(String.format("(==== Gary ====)%n"));
        receipt.append(String.format("%nPrice: 38,000000%n"));
        return receipt.toString();
    }


    @Test
    public void getPriceTest() {
       Burger burger = new Burger();
       burger.setBuns(bun);
       burger.addIngredient(ingredient);
       Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(12));
       Mockito.when(ingredient.getPrice()).thenReturn(Float.valueOf(14));
       int actualPrice =  (int) burger.getPrice();
       int expectedPrice = 38;

       assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Gary");
        Mockito.when(ingredient.getName()).thenReturn("Колбаса");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(12));
        Mockito.when(ingredient.getPrice()).thenReturn(Float.valueOf(14));
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = getActualReceipt();

        assertEquals(expectedReceipt, actualReceipt);

    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int actualSize = burger.ingredients.size();
        int expectedSize = 1;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int actualSize = burger.ingredients.size();
        int expectedSize = 0;

        assertEquals(expectedSize, actualSize);
    }

}
