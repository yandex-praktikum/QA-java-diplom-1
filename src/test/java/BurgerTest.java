import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    @Test
    public void validatePrice() {
        Mockito.when(bun.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        assertThat(burger.getPrice(), is(3f));
    }

    @Test
    public void validateReceipt() {
        Mockito.when(bun.getName()).thenReturn("bunName");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("ingredientName");
        String expected = String.format("(==== bunName ====)%n= sauce ingredientName =%n(==== bunName ====)%n%nPrice: 0,000000%n");
        assertThat(burger.getReceipt(), is(expected));
    }
}
