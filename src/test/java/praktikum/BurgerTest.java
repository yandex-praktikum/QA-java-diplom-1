package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bunMock;
    @Mock
    Burger burgerMock;
    @Mock
    Ingredient ingredientsMock;
    @Mock
    IngredientType ingredientTypeMock;

    @Test
    public void setBuns() {
        burgerMock.setBuns(bunMock);
        Mockito.verify(burgerMock).setBuns(bunMock);
    }

    @Test
    public void addIngredient() {
        burgerMock.addIngredient(ingredientsMock);
        Mockito.verify(burgerMock).addIngredient(ingredientsMock);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        Burger burgerSpy = Mockito.spy(burger);

        burgerSpy.addIngredient(ingredientsMock);
        burgerSpy.removeIngredient(0);

        Mockito.verify(burgerSpy).removeIngredient(0);
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        Burger burgerSpy = Mockito.spy(burger);

        burgerSpy.addIngredient(ingredientsMock);
        burgerSpy.addIngredient(ingredientsMock);
        burgerSpy.moveIngredient(0, 1);

        Mockito.verify(burgerSpy).moveIngredient(0, 1);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        Burger burgerSpy = Mockito.spy(burger);

        burgerSpy.setBuns(bunMock);
        burgerSpy.addIngredient(ingredientsMock);
        burgerSpy.getPrice();

        Mockito.verify(bunMock).getPrice();
        Mockito.verify(ingredientsMock).getPrice();
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        Burger burgerSpy = Mockito.spy(burger);

        burgerSpy.setBuns(bunMock);
        burgerSpy.addIngredient(ingredientsMock);
        Mockito.when(ingredientsMock.getType()).thenReturn(ingredientTypeMock.valueOf("SAUCE"));

        burgerSpy.getReceipt();
        Mockito.verify(bunMock, Mockito.times(2)).getName();
        Mockito.verify(ingredientsMock).getType();
        Mockito.verify(ingredientsMock).getName();
    }
}