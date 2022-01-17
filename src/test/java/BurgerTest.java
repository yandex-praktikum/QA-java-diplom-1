import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bun = new Bun("Говядина", 7.29F);
    @Mock
    List<Ingredient> ingredients = new ArrayList<>();

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertEquals(bun.name,"Говядина");
        assertEquals(bun.price,7.29F,0);
    }
}
