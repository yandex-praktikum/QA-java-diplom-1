import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTestMockito {

    @Mock
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient2;

    @Test // проверка выбора булочки
    public void setBunsTest() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test //проверка добавления ингридиентов
    public void addIngredientTest(){
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test // проверка удаления ингридиентов
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(0);
    }

    @Test // проверка перемещения ингридиентов
    public void moveIngredientTest() {
        burger.moveIngredient(0, 1);
        Mockito.verify(burger).moveIngredient(0, 1);
    }

    @Test //проверка правильного подсчета стоимости
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(25f);
        Mockito.when(ingredient.getPrice()).thenReturn(25f);
        float actual = burger.getPrice();
        assertThat( actual, equalTo(75f));
    }

}
