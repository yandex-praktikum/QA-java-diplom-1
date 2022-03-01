package praktikum.burgerTestSuit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMoveIngredientTest {
    @Mock
    Ingredient testIngredient;

    @Test
    public void moveIngredientTest() {
        Burger testBurger = new Burger();
//        int countIngredientsBeforeAdd = testBurger.ingredients.size();
        testBurger.addIngredient(testIngredient);
        Ingredient nilfgaardSauce = new Ingredient(IngredientType.SAUCE, "Нильфгаардский ржаной", 990F);
        testBurger.addIngredient(nilfgaardSauce);
        int beforeNilfIndex = testBurger.ingredients.indexOf(nilfgaardSauce);
        testBurger.moveIngredient(beforeNilfIndex, 0);
        int afterNilfIndex = testBurger.ingredients.indexOf(nilfgaardSauce);
        Assert.assertEquals(1, beforeNilfIndex);
        Assert.assertEquals(0, afterNilfIndex);
    }
}