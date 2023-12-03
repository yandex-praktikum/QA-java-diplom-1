package praktikum;

import org.junit.Before;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import org.mockito.Mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientsTests {
    @Mock
    Bun bun;
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

    //Проверим добавление булки
    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertTrue(burger.bun == bun);
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
        assertTrue("Ингредиент не переместился!", burger.ingredients.get(0) == filling);
    }
}
