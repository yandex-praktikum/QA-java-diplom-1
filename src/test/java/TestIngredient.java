import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class TestIngredient {
    @Mock
    Ingredient Ingredient;

    @Test

    public void getType() {
        Ingredient.getType();
        Mockito.verify(Ingredient).getType();

    }
    @Test
    public void getName() {
        Ingredient.getName();
        Mockito.verify(Ingredient).getName();

    }
    @Test
    public void getPrice() {
        Ingredient.getPrice();
        Mockito.verify(Ingredient).getPrice();
           }

}
