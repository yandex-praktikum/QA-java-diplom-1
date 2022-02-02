import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
   private Ingredient ingredientFilling;
    @Mock
   private Ingredient ingredientSauce;
    @Mock
   private Bun bun;

    @Before
    public void createBurger(){

        burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Ржанная");
        Mockito.when(bun.getPrice()).thenReturn(1.4f);

        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(10.5f);
        Mockito.when(ingredientFilling.getName()).thenReturn("Мясная котлета");

        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(1.5f);
        Mockito.when(ingredientSauce.getName()).thenReturn("Сырный");

        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);

    }


    @Test
    public void shouldAddIngredient() {

        burger.addIngredient(ingredientFilling);
        int actualCountIngredients = burger.ingredients.size();
        int expectedCountIngredients = 3;
        assertEquals(expectedCountIngredients,actualCountIngredients);
    }

    @Test
    public void shouldRemoveIngredient() {

        Ingredient removingIngredient = burger.ingredients.get(0);
        burger.removeIngredient(0);
        boolean containsIngredient = burger.ingredients.contains(removingIngredient);
       assertFalse(containsIngredient);
    }

    @Test
    public void shouldMoveIngredient() {

        Ingredient firstIngredient = burger.ingredients.get(0);
        Ingredient secondIngredient = burger.ingredients.get(1);
        burger.moveIngredient(0,1);
        Ingredient firstIngredientBeforeMoving = burger.ingredients.get(1);
        Ingredient secondIngredientBeforeMoving = burger.ingredients.get(0);
        assertEquals(firstIngredient,firstIngredientBeforeMoving);
        assertEquals(secondIngredient,secondIngredientBeforeMoving);

    }

    @Test
    public void shouldSetBuns() {

        burger.setBuns(bun);

        assertNotNull(burger.bun);

    }

    @Test
    public void shouldGetValidReceipt() {

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== Ржанная ====)" + "\r\n"+ "= sauce Сырный ="+"\r\n"+
                "= filling Мясная котлета =" +"\r\n" + "(==== Ржанная ====)"+ "\r\n"+"\r\n"+ "Price: 14,800000" + "\r\n";

        Assert.assertEquals(actualReceipt,expectedReceipt);


    }


}
