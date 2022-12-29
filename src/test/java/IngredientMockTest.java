import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientMockTest {

    @Mock
    Ingredient ingredientMock;

    @Test
    public void getPriceIngredientTest(){
        ingredientMock.getPrice();
        ingredientMock.getPrice();
        ingredientMock.getPrice();
        ingredientMock.getPrice();
        Mockito.verify(ingredientMock, Mockito.times(4)).getPrice();
    }

    @Test
    public void getPriceIngredientStabTest(){
        Mockito.when(ingredientMock.getPrice()).thenReturn(378.6f);
        Assert.assertEquals(378.6f, ingredientMock.getPrice(), 0);
    }

    @Test
    public void getNameIngredientTest(){
        ingredientMock.getName();
        Mockito.verify(ingredientMock, Mockito.times(1)).getName();
    }

    @Test
    public void getNameIngredientStabTest(){
        Mockito.when(ingredientMock.getName()).thenReturn("Лист салата");
        Assert.assertEquals("Лист салата", ingredientMock.getName());
    }

    @Test
    public void getTypeIngredientTest(){
        ingredientMock.getType();
        ingredientMock.getType();
        Mockito.verify(ingredientMock, Mockito.times(2)).getType();
    }

    @Test
    public void getTypeIngredientStabTest(){
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        Assert.assertEquals(IngredientType.FILLING, ingredientMock.getType());
    }

}
