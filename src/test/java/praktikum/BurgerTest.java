package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private static Ingredient  ingredient ;



    @Before
    public  void  setUp(){
        burger = new Burger();
        MockitoAnnotations.openMocks(this);
        when(bun.getPrice()).thenReturn(2f);
        when(bun.getName()).thenReturn("ТестоваяБулка");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getName()).thenReturn("ТестоваяНачинка");
        when(ingredient.getPrice()).thenReturn(100F);
    }


    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(new Ingredient(null, "ingredient_1", 10f));
        burger.addIngredient(new Ingredient(null, "ingredient_2", 20f));
        burger.moveIngredient(1, 0);

        assertEquals("ingredient_2", burger.ingredients.get(0).name);
        assertEquals("ingredient_1", burger.ingredients.get(1).name);
    }

    @Test
    public void checkGetPrice() {
        burger.setBuns(bun);


        burger.addIngredient(new Ingredient(null, "ingredient_1", 10f));
        burger.addIngredient(new Ingredient(null, "ingredient_2", 20f));

        float expected = bun.getPrice()*2
                        + burger.ingredients.get(0).price
                        + burger.ingredients.get(1).price;
        float actual = burger.getPrice();
        assertEquals(expected, actual,0.0);

    }

    @Test
    public void checkGetReceipt() {

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String qwe = ingredient.getName();
        assertTrue(burger.getReceipt().contains("Тестовая")
                        &&  burger.getReceipt().contains(qwe)
        );
    }
}