package praktikum.burger.test.suit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientInBurgerTest {
    @Mock
    Ingredient testIngredient;

    @Test
    public void burgerAddIngredientTest() {
        Burger testBurger = new Burger();
        int countBeforeAdd = testBurger.ingredients.size();
        testBurger.addIngredient(testIngredient);
        int countAfterAdd = testBurger.ingredients.size();
        assertEquals("Метод добавления ингредиента не сработал",
                1,
                countAfterAdd - countBeforeAdd);
    }

    @Test
    public void removeIngredientTest() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(testIngredient);
        int countBeforeRemove = testBurger.ingredients.size();
        testBurger.removeIngredient(--countBeforeRemove);
        int countAfterRemove = testBurger.ingredients.size();
        Assert.assertEquals("Метод удаления ингредиента не сработал",
                1,
                countBeforeRemove - countAfterRemove);
    }

    @Test
    public void moveIngredientTest() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(testIngredient);
        Ingredient nilfgaardSauce = new Ingredient(IngredientType.SAUCE, "Нильфгаардский ржаной", 990F);
        testBurger.addIngredient(nilfgaardSauce);
        int beforeNilfIndex = testBurger.ingredients.indexOf(nilfgaardSauce);
        testBurger.moveIngredient(beforeNilfIndex, 0);
        int afterNilfIndex = testBurger.ingredients.indexOf(nilfgaardSauce);
        Assert.assertEquals("Перемещение не сработало",
                1, beforeNilfIndex);
        Assert.assertEquals("Перемещение не сработало",
                0, afterNilfIndex);
    }

}
