import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    float expectedPrice = 600F;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    /**
     * Проверка, что метод добавляет в бургер разные ингредиенты: соусы и начинки
     */
    @Test
    public void addSomeIngredientTest(){

    }

    /**
     * Проверка, что метод удаляет ингредиент из булочки
     */
    @Test
    public void removeSomeIngredientTest() {

    }

    /**
     * Проверка, что метод может перемещать (менять местами) ингредиенты внутри булочки
     */
    @Test
    public void moveSomeIngredientsTest() {

    }

    /**
     * Проверка, что метод возвращает цену бургера
     */
    @Test
    public void getBurgerPriceTest() {
        Burger burger = new Burger(bun);
        Mockito.when(bun.getPrice()).thenReturn(300F);
        Mockito.when(ingredient.getPrice()).thenReturn(300F);
        assertThat(expectedPrice, equalTo(burger.getPrice()));
    }

    /**
     * Проверка, что метод возвращает чек с информацией о бургере
     */
    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("red bun");
        Burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sausage");
        Mockito.when(bun.getPrice()).thenReturn(300F);
        Mockito.when(ingredient.getPrice()).thenReturn(300F);
        Burger burger = new Burger();
        assertEquals(true, burger.getReceipt().contains("red bun")); // todo: проверить формат

    }
}
