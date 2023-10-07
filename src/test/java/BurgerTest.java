import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BurgerTest extends BaseTest {

    @Mock
    Bun bun;

    @Mock
    private static Ingredient firstIngredient;

    @Mock
    private static Ingredient secondIngredient;

    @Before
    public void setUpMock(){
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(random.nextFloat());

        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn(ingredientSauceName);
        Mockito.when(firstIngredient.getPrice()).thenReturn(random.nextFloat());

        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn(ingredientFillingName);
        Mockito.when(secondIngredient.getPrice()).thenReturn(random.nextFloat());
    }
}
