package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static praktikum.constants.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient sauce;
    @Mock
    Ingredient filling;


    @Test
    public void setBunsSuccess() {
        burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientSuccess() {
        burger = new Burger();
        int ingredientSizeBefore = burger.ingredients.size();
        burger.addIngredient(ingredient);
        int ingredientSizeAfter = burger.ingredients.size();
        assertEquals(ingredientSizeAfter, ingredientSizeBefore + 1);
    }

    @Test
    public void removeIngredientSuccess() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(INGREDIENT_INDEX);
        assertEquals(INGREDIENT_LIST_SIZE_AFTER_DELETE, burger.ingredients.size());
    }

    @Test
    public void moveIngredientSuccess() {
        burger = new Burger();
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(INGREDIENT_INDEX, NEW_INGREDIENT_INDEX);
        assertEquals(filling, burger.ingredients.get(INGREDIENT_INDEX));
    }

    @Test
    public void getPriceSuccess() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(BUN_FLUORESCENT_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(FILLING_MEAT_IMMORTAL_MOLLUSKS_PRICE);
        float burgerPrice = (BUN_FLUORESCENT_PRICE * 2 + FILLING_MEAT_IMMORTAL_MOLLUSKS_PRICE);
        assertEquals(
                burgerPrice,
                burger.getPrice(), 0);
    }

    @Test
    public void getReceiptSuccess() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        Mockito.when(bun.getName()).thenReturn(BUN_FLUORESCENT);
        Mockito.when(bun.getPrice()).thenReturn(BUN_FLUORESCENT_PRICE);
        Mockito.when(sauce.getType()).thenReturn(SAUCE);
        Mockito.when(sauce.getName()).thenReturn(SAUCE_SPACY_X);
        Mockito.when(sauce.getPrice()).thenReturn(SAUCE_SPACY_X_PRICE);
        Mockito.when(filling.getType()).thenReturn(FILLING);
        Mockito.when(filling.getName()).thenReturn(FILLING_MEAT_IMMORTAL_MOLLUSKS);
        Mockito.when(filling.getPrice()).thenReturn(FILLING_MEAT_IMMORTAL_MOLLUSKS_PRICE);
        Assert.assertEquals(
                RECEIPT,
                burger.getReceipt());
    }

}
