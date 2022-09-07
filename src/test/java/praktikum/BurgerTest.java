package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    String bunName = "red bun";

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Mock
    private Bun bun;
    private Ingredient firstIngredient = mock(Ingredient.class);
    private Ingredient secondIngredient = mock(Ingredient.class);

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);
        String actualResult = bun.getName();
        assertEquals("Название булочки неверно", bunName, actualResult);

    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        assertEquals("Неверное количество ингредиентов в бургере", 1, burger.ingredients.size());

    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);

        assertTrue("Ингредиент не удалён", burger.ingredients.isEmpty());

    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(0, 1);
        assertEquals("Положение ингредиентов не изменено", "secondIngredient", burger.ingredients.get(0).toString());

    }

}