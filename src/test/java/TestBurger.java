import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger = new Burger();

    @Test
    public void checkSetBun() {
        burger.setBuns(bun);
        Assert.assertTrue(burger.bun != null);
    }
}
