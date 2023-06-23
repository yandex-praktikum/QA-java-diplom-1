package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun bunMock;

    //сравнение двух наименований булки
    @Test
    public void shouldBeTwoBunNamesEquals() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        String actualName = bun.getName();
        Assert.assertEquals("Должна быть Флюоресцентная булка R2-D3", "Флюоресцентная булка R2-D3", actualName);
    }
    //мок Проверить аргументы
    @Test
    public void checkArgumentsMock() {
        bunMock.getName();
        Mockito.verify(bunMock).getName();
    }
    //сравнение двух прайсов булки
    @Test
    public void shouldBeTwoBunPricesNotEquals() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        Assert.assertNotEquals("Стоимость булки должна быть равной 1255", 988, bun.getPrice(), 0);
    }
    //мок Проверить, сколько раз вызвали метод
    @Test
    public void howManyTimesOtherMethodCalledMock() {
        bunMock.getPrice();
        bunMock.getPrice();
        bunMock.getPrice();
        bunMock.getPrice();
        bunMock.getPrice();
        Mockito.verify(bunMock, Mockito.times(5)).getPrice();
    }
}