import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        int sizeOfIngredientsListBeforeAdd = burger.ingredients.size();
        burger.addIngredient(ingredient);
        int sizeOfIngredientListAfterAdd = burger.ingredients.size();
        assertTrue("Ингредиент не добавился в список", sizeOfIngredientsListBeforeAdd < sizeOfIngredientListAfterAdd);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int sizeOfIngredientsList = burger.ingredients.size();
        burger.removeIngredient(0);
        int sizeOfIngredientListAfterRemove = burger.ingredients.size();
        assertEquals("Ингредиент не удалился из списка", sizeOfIngredientsList - 1, sizeOfIngredientListAfterRemove);
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        Ingredient anotherIngredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(1, 0);
        assertEquals(anotherIngredient, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn((float) 100);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 300);
        float expectedPrice = 500;
        float actualPrice = burger.getPrice();
        assertEquals("Итоговая цена посчитана неверно", expectedPrice, actualPrice, 00.1);
    }
}
