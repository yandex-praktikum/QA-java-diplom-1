import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.mockito.ArgumentMatchers.eq;
import static praktikum.IngredientType.SAUCE;

// Some change to trigger pull request

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    // Предполагаем, что класс Burger не готов. Проверяем вызов его методов через моки.

    @Mock
    Burger burger;

    @Test
    public void burgerSetBunTest(){
        Bun bun = new Bun("bulka", 100F);
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void burgerAddIngredientTest(){
        Ingredient ingredient = new Ingredient(SAUCE,"maionez", 100F);
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test
    public void burgerRemoveIngredientTest(){
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(0);
    }

    @Test
    public void burgerMoveIngredientTest(){
        burger.moveIngredient(0,1);
        Mockito.verify(burger).moveIngredient(Mockito.anyInt(),eq(1));
    }

}
