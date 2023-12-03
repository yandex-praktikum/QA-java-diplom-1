package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientsTests {
    @Mock
    Ingredient filling;
    @Mock
    Ingredient sause;
    Burger burger = new Burger();

    @Before
    //Добавим бургеру ингрединеты
    public void fillBurger() {
        burger.ingredients.add(sause);
    }

    //Проверим добавление ингредиента
    @Test
    public void addIngredientTest() {
        burger.addIngredient(filling);
        assertTrue("Ингредиент не добавился!", burger.ingredients.contains(filling));
    }

    //Проверим удаление ингредиента
    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(filling);
        burger.removeIngredient(0);
        assertFalse("Ингредиент не удалился!", burger.ingredients.contains(sause));
        assertTrue("Почистился весь список ингредиентов!", burger.ingredients.contains(filling));
    }

    //Проверим изменение местоположения ингредиента
    @Test
    public void moveIngredient() {
        burger.ingredients.add(filling);
        burger.moveIngredient(1, 0);
        assertSame("Ингредиент не переместился!", burger.ingredients.get(0), filling);
    }
}
