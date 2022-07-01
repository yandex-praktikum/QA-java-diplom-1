import lombok.EqualsAndHashCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
@EqualsAndHashCode
public class BurgerTest {

    Burger burger = new Burger();
    Bun bun = Mockito.spy(new Bun("black bun", 100f));
    Ingredient burgerIngredient1 = new Ingredient(SAUCE, "hot sauce", 100f);
    Ingredient burgerIngredient2 = new Ingredient(IngredientType.FILLING, "cutlet", 100f);

    @Test
    public void setBunsForBurger() {
        burger.setBuns(bun);
        assertEquals("Актуальный результат отличается от ожидаемого", burger.bun, bun);
    }

    @Test
    public void addIngredientsForBurger() {
        int expectedBurgerIngredientsAmount = burger.ingredients.size() + 1;
        burger.addIngredient(burgerIngredient1);
        int actualBurgerIngredientsAmount = burger.ingredients.size();
        assertEquals("Актуальный результат отличается от ожидаемого", expectedBurgerIngredientsAmount, actualBurgerIngredientsAmount);
        assertTrue(burger.ingredients.get(0).equals(burgerIngredient1));
    }

    @Test
    public void checkRemoveBurgerIngredient() {
        burger.addIngredient(burgerIngredient1);
        burger.addIngredient(burgerIngredient2);
        burger.removeIngredient(0);
        int actualBurgerIngredientsAmount = burger.ingredients.size();
        assertEquals("Актуальный результат отличается от ожидаемого", 1, actualBurgerIngredientsAmount);
    }

    @Test
    public void checkMoveBurgerIngredient() {
        burger.addIngredient(burgerIngredient1);
        burger.addIngredient(burgerIngredient2);
        burger.moveIngredient(1, 0);
        assertTrue("Актуальный и ожидаемый результаты равны", burger.ingredients.get(0).equals(burgerIngredient2));
    }

    @Test
    public void getBurgerPrice() {
        burger.setBuns(bun);
        burger.addIngredient(burgerIngredient1);
        burger.addIngredient(burgerIngredient2);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        float result = burger.getPrice();
        assertEquals("Актуальный результат отличается от ожидаемого", 400, result, 0);
    }

    @Test
    public void getBurgerReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(burgerIngredient1);
        burger.addIngredient(burgerIngredient2);
        Mockito.when(bun.getName()).thenReturn("black bun");
        String actual = burger.getReceipt();
        assertTrue(actual.contains(String.format("(==== %s ====)%n", bun.getName())));
        System.out.println(burger.getReceipt());
    }
}


