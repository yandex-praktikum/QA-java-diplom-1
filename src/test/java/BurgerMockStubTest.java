import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


@RunWith(MockitoJUnitRunner.class)
public class BurgerMockStubTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    private Burger burger = new Burger();

    @Test
    public void getBunsName() {
        burger.setBuns(bun);
        burger.bun.getName();
        Mockito.verify(bun, Mockito.times(1)).getName();
    }

    @Test
    public void getBunsPrice() {
        burger.setBuns(bun);
        burger.bun.getPrice();
        burger.bun.getPrice();
        Mockito.verify(bun, Mockito.times(2)).getPrice();
    }

    @Test
    public void getIngredientPrice() {
        ingredient.getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
    }

    @Test
    public void getIngredientName() {
        ingredient.getName();
        Mockito.verify(ingredient, Mockito.times(1)).getName();
    }

    @Test
    public void getIngredientTypeThreeTimes() {
        ingredient.getType();
        ingredient.getType();
        ingredient.getType();
        Mockito.verify(ingredient, Mockito.times(3)).getType();
    }

}
