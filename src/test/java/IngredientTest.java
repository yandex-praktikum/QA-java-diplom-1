import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;


@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Mock
    Ingredient ingredient;

    Database database = new Database();

    @Test
    public void getPriceTest() {
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        assertEquals("Цена не совпадает", database.availableIngredients().get(0).price, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getErrorPriceWithBiggerPriceTest() {
        Mockito.when(ingredient.getPrice()).thenReturn(101F);
        assertTrue("Цена совпадает",database.availableIngredients().get(0).price != ingredient.getPrice());
    }

    @Test
    public void getErrorPriceWithLessPriceTest() {
        Mockito.when(ingredient.getPrice()).thenReturn(99F);
        assertTrue("Цена совпадает",database.availableIngredients().get(0).price != ingredient.getPrice());
    }

    @Test
    public void getNameTest() {
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        assertEquals("Неправильное имя",database.availableIngredients().get(0).name, ingredient.getName());
    }

    @Test
    public void getWrongNameTest() {
        Mockito.when(ingredient.getName()).thenReturn("hot chili");
        assertNotEquals( "Имя совпало",database.availableIngredients().get(0).name, ingredient.getName());
    }

    @Test
    public void getNullNameTest() {
        Mockito.when(ingredient.getName()).thenReturn(null);
        assertNotEquals( "Имя совпало",database.availableIngredients().get(0).name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        assertEquals("Неправильный тип",database.availableIngredients().get(0).type, ingredient.getType());
    }

    @Test
    public void getWrongTypeTest() {
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        assertNotEquals("Тип совпадает",database.availableIngredients().get(0).type, ingredient.getType());
    }
}