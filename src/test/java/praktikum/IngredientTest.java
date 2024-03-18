package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    @Mock
    Ingredient ingredient;
    @Test
    public void getPriceTest() {
        ingredient.getPrice();
        Mockito.verify(ingredient).getPrice();
    }
    @Test
    public void getNameTest() {
        ingredient.getName();
        Mockito.verify(ingredient).getName();
    }
    @Test
    public void getTypeTest(){
        ingredient.getType();
        Mockito.verify(ingredient).getType();
    }
}
