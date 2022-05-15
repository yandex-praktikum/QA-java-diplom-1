import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Bun mockBun;
    Ingredient mockIngredient;
    Burger burger;
    List<Ingredient> ingredients;
    float priceIngredient1;
    float priceIngredient2;
    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient  ingredient3;
    List<Ingredient> ingredientListBase;


    @Before
    public void setUp(){
        mockBun = Mockito.mock(Bun.class);
        mockIngredient = Mockito.mock(Ingredient.class);
        burger = new Burger();
        burger.bun = mockBun;
        float priceIngredient1 = 0.3f;
        float priceIngredient2 = 1.3f;
        float priceIngredient3 = 0.2f;
        ingredient1 = new Ingredient(IngredientType.SAUCE, "ketchup", priceIngredient1);
        ingredient2 = new Ingredient(IngredientType.FILLING, "bacon", priceIngredient2);
        ingredient3 = new Ingredient(IngredientType.FILLING, "cucumber", priceIngredient3);
    }

    @Test
    public void testBurgerGetReceipt () {
        burger.addIngredient(ingredient1);

        Mockito.when(mockBun.getName()).thenReturn("Булочка белая");
        Mockito.when(mockBun.getPrice()).thenReturn(2.5f);
        String expectedReceipt = String.format("(==== Булочка белая ====)%n" +
                "= sauce ketchup =%n" +
                "(==== Булочка белая ====)%n" +
                "%n" +
                "Price: 5,300000%n");
        assertEquals("Incorrect receipt generation", expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testAddIngredientSuccessfully() {
        List<Ingredient> ingredientListBase = new ArrayList<>();
        ingredientListBase.add(ingredient1);
        ingredientListBase.add(ingredient3);
        ingredientListBase.add(ingredient2);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient2);
        List<Ingredient> ingredientListBurger = burger.ingredients;

        assertEquals("addIngredient doesn't work properly",ingredientListBase,ingredientListBurger);
    }

    @Test
    public void testRemoveIngredientSuccessfully() {
        List<Ingredient> ingredientListBase = new ArrayList<>();
        ingredientListBase.add(ingredient3);
        ingredientListBase.add(ingredient2);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);
        List<Ingredient> ingredientListBurger = burger.ingredients;
        assertEquals("removeIngredient doesn't work properly",ingredientListBase,ingredientListBurger);
    }

    @Test
    public void testMoveIngredientSuccessfully() {
        ingredientListBase = new ArrayList<>();
        ingredientListBase.add(ingredient2);
        ingredientListBase.add(ingredient1);
        ingredientListBase.add(ingredient3);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(1,0);

        List<Ingredient> ingredientListBurger = burger.ingredients;
        assertEquals("removeIngredient doesn't work properly",ingredientListBase,ingredientListBurger);
    }



    @Test
    public void testMoveAndRemoveIngredientsSuccessfully() {
        ingredientListBase = new ArrayList<>();
        ingredientListBase.add(ingredient3);
        ingredientListBase.add(ingredient2);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(2,0);
        burger.removeIngredient(1);

        List<Ingredient> ingredientListBurger = burger.ingredients;

    assertEquals(" moveIngredient and removeIngredient don't work properly together",ingredientListBase,ingredientListBurger);
}


    @Test
    public void testGetPriceSuccessfully() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(2,0);
        burger.removeIngredient(1);

        Mockito.when(mockBun.getPrice()).thenReturn(2.5f);

        float priceToCompare = mockBun.getPrice()*2 +  ingredient2.getPrice() + ingredient3.getPrice();
        assertEquals(priceToCompare,burger.getPrice(), 0.0f);

    }

}
