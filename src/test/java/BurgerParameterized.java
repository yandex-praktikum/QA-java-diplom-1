import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class BurgerParameterized {
    @Parameterized.Parameter(0)
    public String nameBun;
    @Parameterized.Parameter(1)
    public IngredientType type;
    @Parameterized.Parameter(2)
    public String nameIngredient;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Parameterized.Parameters(name = "{index}: {0}-{2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"white bun", IngredientType.valueOf("SAUCE"), "sour cream"},
                {"black bun", IngredientType.valueOf("FILLING"), "sausage"}
        });
    }

    @Before
    public void setMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getReceipts() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(ingredient.getName()).thenReturn(nameIngredient);
        burger.getReceipt();
    }
}