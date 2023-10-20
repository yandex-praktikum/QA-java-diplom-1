package bun.tests;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class getBunDataReturnsDataTest {
    @Mock
    Bun bun;
   @Test
    public void getBunNameReturnsNameTest() {
        bun.getName();
        Mockito.when(bun.getName()).thenReturn("булочка");
        Assert.assertEquals("булочка", bun.getName());
    }
    @Test
    public void getBunPriceReturnsPriceTest() {
        bun.getPrice();
        Mockito.when(bun.getPrice()).thenReturn(243F);
        Assert.assertEquals(243F, bun.getPrice(), 0.5);
    }
}