package ingredient.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;

import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceTest() {
        Mockito.when(ingredient.getPrice()).thenReturn(300F);
        Assert.assertEquals(300, ingredient.getPrice(), 0.5);
    }

    @Test
    public void getNameTest() {
        Mockito.when(ingredient.getName()).thenReturn("Cutlet");
        Assert.assertEquals("Cutlet", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Assert.assertEquals(SAUCE, ingredient.getType());
    }
}