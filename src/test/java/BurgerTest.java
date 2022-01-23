import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.junit.Assert.*;

public class BurgerTest {

    private Burger burger;

    @Before
    public void createBurger(){

        burger = new Burger();
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE,"Сырный",1.5f));
        burger.ingredients.add(new Ingredient(IngredientType.FILLING,"Мясная котлета",10.5f));
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE,"Сметанный",1.5f));
        burger.setBuns(new Bun("Ржанная",1.4f));
    }


    @Test
    public void shouldAddIngredient() {

        burger.addIngredient(new Ingredient(IngredientType.FILLING,"Лук",8.34f));
        int actualCountIngredients = burger.ingredients.size();
        int expectedCountIngredients = 4;
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

        Ingredient firstIngredient = burger.ingredients.get(1);
        Ingredient secondIngredient = burger.ingredients.get(2);
        burger.moveIngredient(1,2);
        Ingredient firstIngredientBeforeMoving = burger.ingredients.get(2);
        Ingredient secondIngredientBeforeMoving = burger.ingredients.get(1);
        assertEquals(firstIngredient,firstIngredientBeforeMoving);
        assertEquals(secondIngredient,secondIngredientBeforeMoving);

    }

    @Test
    public void shouldSetBuns() {

        Bun bun = new Bun("Ржанная",1.4f);
        burger.setBuns(bun);
        Bun burgerBun = burger.bun;
        assertNotNull(burgerBun);

    }

    @Test
    public void shouldGetReceipt() {
        String receipt = burger.getReceipt();
        assertNotNull(receipt);

    }


}
